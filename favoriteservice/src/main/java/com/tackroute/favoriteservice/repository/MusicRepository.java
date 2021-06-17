package com.tackroute.favoriteservice.repository;

import com.tackroute.favoriteservice.model.Favorite;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends MongoRepository<Favorite, String> {
    // Music findBySongTitleAndArtistName(String songTitle,String artistName);
    //Music findByTitle(String songTitle);
}
