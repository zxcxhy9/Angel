package com.xhy.angel.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xhy.angel.common.constants.CodeEnum;
import lombok.Data;

@Data
public class ApiResponse<T> {
    @JsonProperty("code")
    private String code = null;
    @JsonProperty("data")
    private T data = null;
    @JsonProperty("message")
    private String message = null;

    public ApiResponse() {

    }

    public ApiResponse(String code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public static <T> ApiResponse<T> success(T data) {
        ApiResponse<T> response = new ApiResponse();
        response.setCode(CodeEnum.SUCCESS.getCode());
        response.setMessage(CodeEnum.SUCCESS.getMessage());
        response.setData(data);
        return response;
    }

    public static ApiResponse fail(String msg){
        ApiResponse response = new ApiResponse();
        response.setCode(CodeEnum.FAIL.getCode());
        response.setMessage(msg);
        return response;
    }

    public static <T> ApiResponse<T> fail(String msg, CodeEnum codeEnum){
        ApiResponse<T> response = new ApiResponse();
        response.setCode(codeEnum.getCode());
        response.setMessage(msg);
        return response;
    }

    public static <T> ApiResponse.ApiResponseBuilder<T> builder() {
        return new ApiResponse.ApiResponseBuilder();
    }

    @JsonProperty("code")
    public void setCode(String code){
        this.code = code;
    }

    @JsonProperty("data")
    public void setData(T data){
        this.data = data;
    }

    @JsonProperty("message")
    public void setMessage(String message){
        this.message = message;
    }

    public static class ApiResponseBuilder<T> {
        private String code;
        private T data;
        private String message;

        ApiResponseBuilder(){}

        @JsonProperty("code")
        public ApiResponse.ApiResponseBuilder<T> code(String code){
            this.code = code;
            return this;
        }

        @JsonProperty("data")
        public ApiResponse.ApiResponseBuilder<T> data(T data){
            this.data = data;
            return this;
        }

        @JsonProperty("message")
        public ApiResponse.ApiResponseBuilder<T> message(String message){
            this.message = message;
            return this;
        }

        public ApiResponse<T> build() {
            return new ApiResponse(this.code, this.data, this.message);
        }

        public String toString() {
            return "ApiResponse.ApiResponseBuilder(code=" + this.code + ", data=" + this.data + ", message=" + this.message + ")";
        }
    }
}
