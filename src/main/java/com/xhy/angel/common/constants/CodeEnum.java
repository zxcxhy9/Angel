package com.xhy.angel.common.constants;

public enum CodeEnum {
    SUCCESS("2000", "操作成功"),
    FAIL("10000", "操作失败"),
    NOT_FIND_ERROR("10030", "未查询到信息"),
    SAVE_ERROR("2002", "保存信息失败");

    private String code;
    private String message;

    CodeEnum(String code, String message){
        this.code = code;
        this.message = message;
    }

    public String getCode(){
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
