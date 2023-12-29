package ru.lesson.exception;

import java.util.function.Supplier;

public class ErrException extends Exception {
    public ErrException(String err) {
        super(err);
    }
}
