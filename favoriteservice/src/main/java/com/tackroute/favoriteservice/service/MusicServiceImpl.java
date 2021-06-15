package com.tackroute.favoriteservice.service;

import com.tackroute.favoriteservice.exception.FavoriteAlreadyExistException;
import com.tackroute.favoriteservice.exception.FavoriteDoesNotExistException;
import com.tackroute.favoriteservice.exception.FavoriteListDoesNotExist;
import com.tackroute.favoriteservice.model.Favorite;
import com.tackroute.favoriteservice.model.Song;
import com.tackroute.favoriteservice.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicServiceImpl implements MusicService {
    private MusicRepository musicRepository;

    @Autowired
    public MusicServiceImpl(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @Override
    public Favorite addToFavorite(Favorite favorite) throws FavoriteAlreadyExistException {
        Optional<Favorite> favoriteResult = musicRepository.findById(favorite.getEmail());
        if(favoriteResult.isPresent()){
            List<Song> newsList = favoriteResult.get().getSongs();
            boolean present = false;
            for(Song song: newsList){
                if(song.getSongTitle().equals(favorite.getSongs().get(0).getSongTitle())){
                    present = true;
                }
            }
            if(present) throw new FavoriteAlreadyExistException();
            favoriteResult.get().getSongs().add(favorite.getSongs().get(0));
            return musicRepository.save(favoriteResult.get());
        }else return musicRepository.save(favorite);
    }

    @Override
    public Favorite removeFromFavorite(String email, String songTitle) throws FavoriteDoesNotExistException {
        return null;
    }

    @Override
    public List<Song> getFavoriteMusic(String email) throws FavoriteListDoesNotExist {
        return null;
    }




 /*   public Music saveMusic(Music music) {
        return musicRepository.save(music);
    }

    public List<Music> getMusicList() {
        return musicRepository.findAll();
    }*/

  /* public Music getBySongTitleAndArtistName(String songTitle,String artistName) {
        return musicRepository.findBySongTitleAndArtistName(songTitle,artistName);
    }*/

   /* public Music getBySongTitle(String songTitle)
    {
        return musicRepository.findByTitle(songTitle);
    }*/


}
