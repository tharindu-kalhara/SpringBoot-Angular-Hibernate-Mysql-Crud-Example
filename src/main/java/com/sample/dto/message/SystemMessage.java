package com.sample.dto.message;

/**
 * Created by Tharindu Kalhara on 9/22/2017.
 */
public class SystemMessage {
    private String message;

    public SystemMessage() {
    }

    public SystemMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
