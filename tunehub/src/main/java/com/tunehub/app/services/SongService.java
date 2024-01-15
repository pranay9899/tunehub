package com.tunehub.app.services;

import java.util.List;

import com.tunehub.app.entity.Song;

public interface SongService {

	public List<Song> fetchSongs();

	public boolean addSong(Song song);

	public void updateSong(Song song);

}
