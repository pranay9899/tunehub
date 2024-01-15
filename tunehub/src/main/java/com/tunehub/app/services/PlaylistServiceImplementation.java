package com.tunehub.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunehub.app.entity.Playlist;
import com.tunehub.app.repository.PlaylistRepository;

@Service
public class PlaylistServiceImplementation implements PlaylistService {

	@Autowired
	PlaylistRepository repo;

	@Override
	public void addPlaylist(Playlist playlist) {
		repo.save(playlist);
	}

	@Override
	public List<Playlist> fetchAllPlaylists() {

		return repo.findAll();
	}

}
