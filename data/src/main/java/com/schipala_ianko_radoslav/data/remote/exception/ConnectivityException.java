package com.schipala_ianko_radoslav.data.remote.exception;

public class ConnectivityException extends RuntimeException {

    public ConnectivityException(String message) {
        super("Server was not reached: " + message);
    }
}
