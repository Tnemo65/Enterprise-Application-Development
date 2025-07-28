package com.example.demo.model;

public class RequestData {
    private String id;
    private String message;

    // Constructors
    public RequestData() {}
    public RequestData(String id, String message) {
        this.id = id;
        this.message = message;
    }

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    @Override
    public String toString() {
        return "RequestData{id='" + id + "', message='" + message + "'}";
    }
}