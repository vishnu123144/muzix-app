package com.tackroute.favoriteservice.service;

import com.tackroute.favoriteservice.exception.FavoriteAlreadyExistException;
import com.tackroute.favoriteservice.exception.FavoriteDoesNotExistException;
import com.tackroute.favoriteservice.exception.UserAlreadyExistsException;
import com.tackroute.favoriteservice.exception.UserNotFoundException;
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
        if (favoriteResult.isPresent()) {
            List<Song> newsList = favoriteResult.get().getSongs();
            boolean present = false;
            for (Song song : newsList) {
                if (song.getSongTitle().equals(favorite.getSongs().get(0).getSongTitle())) {
                    present = true;
                }
            }
            if (present) throw new FavoriteAlreadyExistException();
            favoriteResult.get().getSongs().add(favorite.getSongs().get(0));
            return musicRepository.save(favoriteResult.get());
        } else return musicRepository.save(favorite);
    }

    @Override
    public Optional<Favorite> getAllFavorites(String email) {
        final Optional<Favorite> allFavorite = this.musicRepository.findById(email);
        if (allFavorite.isPresent())
            return allFavorite;
        else
            throw new UserNotFoundException();
    }

    @Override
    public List<Song> deleteFavouriteByFavouriteId(String email, String favouriteId) throws FavoriteDoesNotExistException, UserNotFoundException {
        Optional<Favorite> fav = getAllFavorites(email);

        int index = 0;
        boolean found = false;
        if (fav != null) {
            List<Song> details = fav.get().getSongs();
            for (int i = 0; i < details.size(); i++) {
                if (details.get(i).getFavoriteId().equals(favouriteId)) {
                    index = i;
                    found = true;
                    break;
                }
            }
            if (found) {
                Song favdetail = details.get(index);
                details.remove(index);
                fav.get().setSongs(details);
                musicRepository.save(fav.get());
                return details;
            } else {
                throw new FavoriteDoesNotExistException("Favourite Not Found");
            }
        } else {
            throw new UserNotFoundException("User Not Found");
        }
    }

    @Override
    public Favorite createFavoriteList(String email, Favorite favorite) throws UserAlreadyExistsException {
        final Optional<Favorite> user = musicRepository.findById(email);
        if (user.isPresent()) {
            throw new UserAlreadyExistsException("User Already Exist");
        } else {
            return musicRepository.save(favorite);
        }
    }

}
