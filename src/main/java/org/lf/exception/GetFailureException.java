package org.lf.exception;

public class GetFailureException extends RuntimeException {

    public GetFailureException() {
        super();
    }

    public GetFailureException(String msg) {
        super(msg);
    }

}
