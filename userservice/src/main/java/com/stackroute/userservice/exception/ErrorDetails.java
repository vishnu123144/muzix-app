package com.stackroute.userservice.exception;
import java.util.Date;
public class ErrorDetails {
    private Date time;
    private String message;
    private String url;
    public ErrorDetails() {
    }
    public ErrorDetails(Date time, String message, String url) {
        this.time = time;
        this.message = message;
        this.url = url;
    }
    public Date getTime() {
        return time;
    }
    public void setTime(Date time) {
        this.time = time;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    @Override
    public String toString() {
        return "ErrorDetails{" +
                "time=" + time +
                ", message='" + message + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}




