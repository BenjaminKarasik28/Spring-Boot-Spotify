package com.ga.springbootspotify.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "songs")
public class Song {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String songname;

    @Column
    private String length;

    public Song() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSongname() {
        return songname;
    }

    public void setSongname(String songname) {
        this.songname = songname;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "user_song",
            joinColumns = {@JoinColumn(name = "song_id")},
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;

    public List<User> getUsers(){ return users; }

    public void setUsers(List<User> users) { this.users = users; }

}