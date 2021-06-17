package com.tackroute.favoriteservice.service;

import com.tackroute.favoriteservice.exception.FavoriteAlreadyExistException;
import com.tackroute.favoriteservice.exception.FavoriteListDoesNotExistException;
import com.tackroute.favoriteservice.model.Favorite;
import com.tackroute.favoriteservice.model.Song;

import java.util.List;
import java.util.Optional;

public interface MusicService {
    Favorite addToFavorite(Favorite favorite) throws FavoriteAlreadyExistException;

    Optional<Favorite> getAllFavorites(String email);

    List<Song> deleteFavouriteByFavouriteId(String email, String favouriteId);

    Favorite createFavoriteList(String email, Favorite favorite);



}
