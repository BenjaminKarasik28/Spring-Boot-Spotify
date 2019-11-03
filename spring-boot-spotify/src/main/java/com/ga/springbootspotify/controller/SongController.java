package com.ga.springbootspotify.controller;


        import com.ga.springbootspotify.model.Song;
        import com.ga.springbootspotify.service.SongService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/song")
public class SongController {


    private SongService songService;

    @Autowired
    public void setSongService(SongService songService){
        this.songService = songService;
    }


        @PostMapping
        public Song createSong(@RequestBody Song song){
            return songService.createSong(song);
        }


        @GetMapping("/list")
        public Iterable<Song> listSongs() {
        return songService.listSongs();

    }

}
