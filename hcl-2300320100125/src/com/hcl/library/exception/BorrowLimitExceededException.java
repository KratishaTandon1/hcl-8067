package com.hcl.library.exception;

public class BorrowLimitExceededException extends LibraryException {
    public BorrowLimitExceededException(String msg) {
        super(msg);
    }
}