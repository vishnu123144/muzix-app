package com.tackroute.favoriteservice.exception;

public class FavoriteListDoesNotExistException extends RuntimeException {
    public FavoriteListDoesNotExistException(String message) {
        super(message);
    }
}
