package com.xhy.angel.api;

import com.xhy.angel.api.dto.Test1Request;
import com.xhy.angel.api.dto.TestResponse;
import com.xhy.angel.application.TestService;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.equalTo;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class TestControllerTest {

    private TestService testService;

    @Before
    public void setUp() {
        testService = mock(TestService.class);
        RestAssuredMockMvc.standaloneSetup(new TestController(testService));
    }

    @Test
    public void shouldReturnTestResponse(){
        TestResponse testResponse = new TestResponse();

        Test1Request test1Request = new Test1Request();
        LocalDateTime dateTime = LocalDateTime.of(2019,1,1,1,1,1);
        test1Request.setDateTime(dateTime);
        test1Request.setName("哈哈");
        test1Request.setUuid("1234567890");

        Mockito.when(testService.test1(test1Request)).thenReturn(testResponse);

        given()
                .body(test1Request)
                .contentType("application/json")
        .when()
                .post("/test/test1")
                .then()
                .log().all()
                .statusCode(200)
                .body("uuid",equalTo("1234567890"))
                .body("name", equalTo("哈哈"))
                .body("dateTime", equalTo(""));
    }
}