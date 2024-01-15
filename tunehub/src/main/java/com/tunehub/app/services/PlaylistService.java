package com.tunehub.app.services;

import java.util.List;

import com.tunehub.app.entity.Playlist;

public interface PlaylistService {

	public void addPlaylist(Playlist playlist);

	public List<Playlist> fetchAllPlaylists();

}
