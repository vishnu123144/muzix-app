package com.tackroute.favoriteservice.exception;

public class FavoriteListDoesNotExistException extends RuntimeException {
    public FavoriteListDoesNotExistException() {

    }

    public FavoriteListDoesNotExistException(String message) {
        super(message);
    }
}
