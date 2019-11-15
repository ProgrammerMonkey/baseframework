package com.tyrone.baseframework;

import com.tyrone.baseframework.constant.CodeRes;
import com.tyrone.baseframework.exception.ServiceException;
import org.springframework.stereotype.Service;

/**
 * @program: baseframework
 * @description:
 * @author: Tyrone
 * @create: 2019-11-15 18:53
 */
@Service
public class TestServiceImpl implements TestService {


    @Override
    public String test() {
        throw new ServiceException(CodeRes.CODE_1015);
    }
}
