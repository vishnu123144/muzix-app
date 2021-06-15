package com.tackroute.favoriteservice.controller;

import com.tackroute.favoriteservice.exception.FavoriteAlreadyExistException;
import com.tackroute.favoriteservice.model.Favorite;
import com.tackroute.favoriteservice.model.Song;
import com.tackroute.favoriteservice.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MusicController {
    private MusicService musicService;

    @Autowired
    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }


    @PostMapping("/addsong")
    public ResponseEntity<?> addToFavorites(@RequestBody Favorite favorite) {
        try {
            Favorite response = musicService.addToFavorite(favorite);
            return new ResponseEntity<Favorite>(response, HttpStatus.OK);
        } catch (FavoriteAlreadyExistException exception) {
            return new ResponseEntity<String>("Song already exists.", HttpStatus.CONFLICT);
        }
    }
    @GetMapping("/welcome")
    public String welcome()
    {
        return "welcome";
    }

 /*   @PostMapping("/saveSong")
    public String saveMusic(@RequestBody Song song) {
        Song songSaved = musicService.saveMusic(song);
        if (songSaved != null) {
            return "details Saved Successfully";
        } else {
            return "Details Not saved";
        }
    }*/


/*    @GetMapping("/getAllSongs")
    public List<Song> getMusicList() {
        return musicService.getMusicList();
    }
    */

   /* @GetMapping("/getBySongAndArtist/{songTitle}/{artistName}")
    public Music getBySongTitleAndArtist(@RequestParam("songTitle") String songTitle,@RequestParam("artistName") String artistName)
    {
        return musicService.getBySongTitleAndArtistName(songTitle,artistName);
    }*/

   /* @GetMapping("/getBySongTitle/{songTitle}")
    public Music getBySongTitle(@RequestParam("songTitle") String songTitle)
    {
        return musicService.getBySongTitle(songTitle);
    }*/

}
