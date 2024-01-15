package com.tunehub.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunehub.app.entity.Song;
import com.tunehub.app.repository.SongRepository;

@Service
public class SongServiceImplementation implements SongService {

	@Autowired
	SongRepository repo;

	@Override
	public List<Song> fetchSongs() {
		List<Song> allSongs = repo.findAll();
		return allSongs;
	}

	@Override
	public boolean addSong(Song song) {
		if (repo.findByLink(song.getLink()) == null) {
			repo.save(song);
			return true;
		}

		System.out.println("Failed to add Song Alredy exists");
		return false;

	}

	@Override
	public void updateSong(Song song) {
		repo.save(song);
	}

}
