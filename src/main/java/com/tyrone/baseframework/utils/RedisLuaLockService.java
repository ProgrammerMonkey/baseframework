package com.tyrone.baseframework.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: topsmart
 * @description: 基于lua的分布式redis锁
 * @author: Tyrone
 * @create: 2020-03-03 10:51
 **/
@Component
public class RedisLuaLockService {
    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());
    @Autowired
    private RedisTemplate redisTemplate;

    public Boolean lock(String key, String time, String value) {
        DefaultRedisScript<String> lockScript = new DefaultRedisScript<String>();
        lockScript.setScriptSource(
                new ResourceScriptSource(new ClassPathResource("lua/add.lua")));
        lockScript.setResultType(String.class);
        // 封装参数
        List<Object> keyList = new ArrayList<Object>();
        keyList.add(key);
        keyList.add(time);
        keyList.add(value);
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        String result = (String) redisTemplate.execute(lockScript, keyList);
//        LOGGER.info("获取redis锁结果：" + result);
        if (!"ok".equals(result.toLowerCase())) {
            return false;
        }
        return true;
    }

    public Long releaseLock(String key, String value) {
        System.out.println("=============" + key + ":" + value + "=======================");

        DefaultRedisScript<Long> lockScripts = new DefaultRedisScript<Long>();
        lockScripts.setScriptSource(
                new ResourceScriptSource(new ClassPathResource("lua/unlock.lua")));
        lockScripts.setResultType(Long.class);
        // 封装参数
        List<Object> keyList = new ArrayList<Object>();
        keyList.add(key);
        keyList.add(value);
        Long result = (Long) redisTemplate.execute(lockScripts, keyList);
//        LOGGER.info("释放锁结果" + result);
        return result;
    }


}
