package com.tackroute.favoriteservice.controller;

import com.tackroute.favoriteservice.exception.FavoriteAlreadyExistException;
import com.tackroute.favoriteservice.model.Favorite;
import com.tackroute.favoriteservice.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class MusicController {
    private MusicService musicService;

    @Autowired
    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }

    @GetMapping("welcome")
    public String welcome() {
        return "welcome";
    }

    @PostMapping("addsong")
    public ResponseEntity<?> addToFavorites(@RequestBody Favorite favorite) {
        try {
            Favorite response = musicService.addToFavorite(favorite);
            return new ResponseEntity<Favorite>(response, HttpStatus.OK);
        } catch (FavoriteAlreadyExistException exception) {
            return new ResponseEntity<String>("Song already exists.", HttpStatus.CONFLICT);
        }
    }

    @GetMapping("favourite/{email}/getAllFavourites")
    public ResponseEntity<?> getAllFavourites(@PathVariable String email) {
        return new ResponseEntity<>(this.musicService.getAllFavorites(email), HttpStatus.OK);
    }

    @DeleteMapping("favourite/{email}/deleteFromFavourite/{favId}")
    public void deleteFromFavourite(@PathVariable("email") String email, @PathVariable String favId) {
        musicService.deleteFavouriteByFavouriteId(email, favId);
    }

    @PostMapping("{email}/createFavouriteList")
    public ResponseEntity<?> createFavouriteList(@PathVariable("email") String email, @RequestBody Favorite user) {
        return new ResponseEntity<>(this.musicService.createFavoriteList(email, user), HttpStatus.CREATED);
    }

}
