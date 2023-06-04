package br.com.isertech.mycv.mycvback.error.exception;

public class InfoNotFoundException extends RuntimeException {
    public InfoNotFoundException(String id) {
        super(id);
    }
}
