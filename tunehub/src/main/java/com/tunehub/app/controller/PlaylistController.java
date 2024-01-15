package com.tunehub.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tunehub.app.entity.Playlist;
import com.tunehub.app.entity.Song;
import com.tunehub.app.services.PlaylistService;
import com.tunehub.app.services.SongService;

@Controller
public class PlaylistController {

	@Autowired
	SongService songservice;

	@Autowired
	PlaylistService playlistservice;

	@GetMapping("/createplaylist")
	public String createPlaylist(Model model) {
		List<Song> listOfSongs = songservice.fetchSongs();
		model.addAttribute("songs", listOfSongs);
		return "createplaylist";
	}

	@PostMapping("/addplaylist")
	public String addplaylist(@ModelAttribute Playlist playlist) {
		playlistservice.addPlaylist(playlist);
		System.out.println("playlist added");

		List<Song> listOfSongs = playlist.getSongs();
		for (Song song : listOfSongs) {
			song.getPlaylists().add(playlist);
			songservice.updateSong(song);
		}
		return "adminhome";
	}

	@GetMapping("/viewplaylists")
	public String viewPlaylists(Model model) {
		List<Playlist> playlists = playlistservice.fetchAllPlaylists();
		model.addAttribute("playlists", playlists);
		return "displayplaylists";
	}

}
