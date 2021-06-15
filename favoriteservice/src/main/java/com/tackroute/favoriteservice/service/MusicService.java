package com.tackroute.favoriteservice.service;

import com.tackroute.favoriteservice.exception.FavoriteAlreadyExistException;
import com.tackroute.favoriteservice.exception.FavoriteDoesNotExistException;
import com.tackroute.favoriteservice.exception.FavoriteListDoesNotExistException;
import com.tackroute.favoriteservice.model.Favorite;
import com.tackroute.favoriteservice.model.Song;

import java.util.List;

public interface MusicService {

    Favorite addToFavorite(Favorite favorite) throws FavoriteAlreadyExistException;

    Favorite removeFromFavorite(String email, String songTitle) throws FavoriteDoesNotExistException;

    List<Song> getFavoriteMusic(String email) throws FavoriteListDoesNotExistException;

}
