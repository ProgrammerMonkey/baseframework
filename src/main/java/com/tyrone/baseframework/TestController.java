package com.tyrone.baseframework;

import com.tyrone.baseframework.result.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: baseframework
 * @description:
 * @author: Tyrone
 * @create: 2019-11-15 18:49
 */
@RestController()
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping(value = "/test")
    public RestResponse test() {
        RestResponse restResponse = new RestResponse();
        String data = testService.test();
        restResponse.setData(data);
        return restResponse;
    }

}
