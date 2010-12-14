package com.amalto.workbench.detailtabs.exception;

public class CommitValidationException extends Exception {

    private static final long serialVersionUID = -4360609696577298950L;

    public CommitValidationException(String msg, Exception reason) {
        super(msg, reason);
    }

    public CommitValidationException(String msg) {
        super(msg);
    }

}
