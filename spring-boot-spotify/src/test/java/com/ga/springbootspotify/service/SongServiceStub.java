package com.ga.springbootspotify.service;

import com.ga.springbootspotify.model.Song;

public class SongServiceStub implements SongService {


    @Override
    public Song createSong(Song newSong) {

        Song song = new Song();
        song.setSongname("sample");

        return song;
    }

    @Override
    public Iterable<Song> listSongs() {

        Song song = new Song();
//        song.

        return null;
    }
}


//    @Override
//    public UserProfile createUserProfile(String username, UserProfile newProfile) {
//        UserProfile userProfile = new UserProfile();
//        userProfile.setEmail("batman@superhero.com");
//
//        return userProfile;
//    }
