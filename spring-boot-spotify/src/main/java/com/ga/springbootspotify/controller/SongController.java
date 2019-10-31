package com.ga.springbootspotify.controller;


        import com.ga.springbootspotify.model.Song;
        import com.ga.springbootspotify.service.SongService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/song")
public class SongController {

    @Autowired
    private SongService songService;

        @PostMapping
        public Song createSong(@RequestBody Song song){
            return songService.createSong(song);
        }


        @GetMapping("/list")
        public Iterable<Song> listSongs() {
        return songService.listSongs();

    }

    //
//    @PostMapping("/signup")
//    public User createUser(@RequestBody User newUser){
//        return userService.createUser(newUser);
//    }

}


//
//    @GetMapping("/login/{username}/{password}")
//    public User login(@PathVariable String username, @PathVariable String password) {
//        return userService.login(username, password);
//    }
//
//
//}
