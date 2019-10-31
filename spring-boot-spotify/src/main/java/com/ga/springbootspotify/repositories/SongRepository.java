package com.ga.springbootspotify.repositories;

import com.ga.springbootspotify.model.Song;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Long> {


}
