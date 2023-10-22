package com.insper.user.user;

public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException() {
        super("E-mail já cadastrado");
    }
}
