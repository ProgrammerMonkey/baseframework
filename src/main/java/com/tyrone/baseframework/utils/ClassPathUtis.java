package com.tyrone.baseframework.utils;

import java.io.InputStream;

/**
 * @program: baseframework
 * @description: 获取项目文件绝对路径
 * @author: Tyrone
 * @create: 2020-07-02 14:04
 **/
public class ClassPathUtis {
    /**
     * Description: 获取项目文件流，springboot项目中打成jar包后文件路径或发生变化不再适用原先的方法，故用此方法
     *
     * @param shortPath
     * @return: java.io.InputStream
     * @Author: Tyrone
     * @date: 2020/7/2
     **/
    public static InputStream getFileInputStream(String shortPath) {
        //第一种方法
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(shortPath);
        //第二种方法
//        ClassPathResource classPathResource = new ClassPathResource(shortPath);
//        InputStream inputStream =classPathResource.getInputStream();
        //第三种方法  this.getClass()
//        InputStream inputStream = ClassPathUtis.class.getResourceAsStream(shortPath);
        //第四种方法 对于打成jar包会找不到路径
//        推测主要原因是springboot内置tomcat，打包后是一个jar包，
//        无法直接读取jar包中的文件，读取只能通过类加载器读取
//        File file = ResourceUtils.getFile(shortPath);
//        InputStream inputStream = new FileInputStream(file);
        return inputStream;
    }
}
