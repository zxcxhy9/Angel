package com.xhy.angel.application;

import com.xhy.angel.api.dto.Test2Request;
import com.xhy.angel.api.dto.Test1Request;
import com.xhy.angel.api.dto.TestResponse;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    public TestResponse test1(Test1Request test1Request) {
        TestResponse testResponse = new TestResponse();
        testResponse.setName(test1Request.getName());
        testResponse.setUuid(test1Request.getUuid());
        testResponse.setDateTime(test1Request.getDateTime());

        return testResponse;
    }

    public TestResponse test2(Test2Request test2Request) {
        TestResponse testResponse = new TestResponse();
        testResponse.setName(test2Request.getName());
        testResponse.setUuid(test2Request.getUuid());
        testResponse.setDateTime(test2Request.getDateTime());

        return testResponse;
    }

}
