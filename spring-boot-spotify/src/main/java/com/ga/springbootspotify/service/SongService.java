package com.ga.springbootspotify.service;

import com.ga.springbootspotify.model.Song;

public interface SongService {

    public Song createSong(Song song);

    public Iterable<Song> listSongs();

}


//    public User createUser(User newUser);
//
//    public User login(String username, String password);