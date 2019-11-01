package com.xhy.angel.api;

import com.xhy.angel.api.dto.Test1Request;
import com.xhy.angel.api.dto.Test2Request;
import com.xhy.angel.api.dto.TestResponse;
import com.xhy.angel.application.TestService;
import io.swagger.annotations.ApiOperation;
import com.xhy.angel.common.dto.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping(value = "test")
public class TestController {
    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }


    @PostMapping("/test1")
    @ApiOperation("使用POST 方法！你好，SpringBoot！")
    public ApiResponse<TestResponse> test1(@Valid @RequestBody Test1Request test1Request) {
        return ApiResponse.success(testService.test1(test1Request));
    }

    @GetMapping("/test2")
    @ApiOperation("使用GET 方法！你好，SpringBoot！")
    public ApiResponse<TestResponse> test2(@Valid Test2Request test2Request) {
        return ApiResponse.success(testService.test2(test2Request));
    }



}
