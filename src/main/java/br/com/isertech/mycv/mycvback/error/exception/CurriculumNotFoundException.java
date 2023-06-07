package br.com.isertech.mycv.mycvback.error.exception;

public class CurriculumNotFoundException extends RuntimeException {
    public CurriculumNotFoundException(String id) {
        super(id);
    }
}
