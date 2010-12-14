package com.amalto.workbench.detailtabs.exception;

public class CommitException extends Exception {

    private static final long serialVersionUID = 1076006458876794715L;

    public CommitException(String msg, Exception reason) {
        super(msg, reason);
    }

    public CommitException(String msg) {
        super(msg);
    }

}
