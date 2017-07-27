package com.example.com.model;

/**
 * Created by Balan Vishnu on 22-Mar-17.
 */

public class ApiResponse {
    private String tag;
    private Integer success;
    private Integer error;
    private String msg;
    private String status;

    public String getTag() {
        return tag;
    }

    public Integer getSuccess() {
        return success;
    }

    public Integer getError() {
        return error;
    }

    public String getMsg() {
        return msg;
    }

    public String getStatus() {
        return status;
    }
}
