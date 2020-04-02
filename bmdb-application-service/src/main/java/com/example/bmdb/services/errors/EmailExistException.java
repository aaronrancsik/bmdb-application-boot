package com.example.bmdb.services.errors;

public class EmailExistException extends Exception{

    public EmailExistException(Exception innerException) {
        this.innerException = innerException;
    }
    Exception innerException;

}
