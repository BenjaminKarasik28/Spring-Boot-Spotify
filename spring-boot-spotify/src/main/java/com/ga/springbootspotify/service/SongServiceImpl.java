package com.ga.springbootspotify.service;

import com.ga.springbootspotify.model.Song;
import com.ga.springbootspotify.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongRepository songRepository;

    @Override
    public Song createSong(Song song) {
        return songRepository.save(song);
    }

    @Override
    public Iterable<Song> listSongs() {
        return songRepository.findAll();
    }
}
