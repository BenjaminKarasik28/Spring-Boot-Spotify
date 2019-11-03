package com.ga.springbootspotify.controller;

import com.ga.springbootspotify.model.Song;
import com.ga.springbootspotify.service.SongServiceStub;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SongControllerTest {

    private SongController songController;

    @Before
    public void initializeSongController(){
        songController = new SongController();
        songController.setSongService(new SongServiceStub());
    }

    @Test
    public void createSong_SaveSong_Success(){
        Song song = new Song();
        song.setSongname("sample");

        Song newSong = songController.createSong(song);
//
        Assert.assertNotNull(newSong);
        Assert.assertEquals(newSong.getSongname(), song.getSongname());
    }


}


//    @Override
//    public Iterable<Song> listSongs() {
//        return null;
//    }