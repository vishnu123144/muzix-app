package com.tackroute.favoriteservice.exception;

public class FavoriteDoesNotExistException extends RuntimeException {
    public FavoriteDoesNotExistException() {

    }

    public FavoriteDoesNotExistException(String message) {

        super(message);
    }

}
