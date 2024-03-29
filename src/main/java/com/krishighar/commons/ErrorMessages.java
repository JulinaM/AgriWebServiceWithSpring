package com.krishighar.commons;

public enum ErrorMessages {
    NULL_REQUEST(1),
    INVALID_PASSWORD(2),
    INVALID_USERNAME(3),
    NULL_USER_ID(4),
    INTERNAL_SERVER_ERROR(5),
    CONNECTION_ERROR(6),
    INVALID_EMAIL(7),
    INVALID_DEVICE_ID(8),
    DB_INSERTION_FAILURE(9);

    private int value;

    private ErrorMessages(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}