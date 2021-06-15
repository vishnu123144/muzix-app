package com.tackroute.favoriteservice.exception;

public class FavoriteDoesNotExistException extends RuntimeException
{
    public FavoriteDoesNotExistException(String message)
    {
        super(message);
    }

}
