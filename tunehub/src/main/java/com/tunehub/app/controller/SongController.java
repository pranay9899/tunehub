package com.tunehub.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tunehub.app.entity.Song;
import com.tunehub.app.services.SongService;

@Controller
public class SongController {

	@Autowired
	SongService service;

	@PostMapping("/addsong")
	public String addSong(@ModelAttribute Song song) {
		if (service.addSong(song)) {
			return "adminhome";
		}
		return "newsong";
	}

	@GetMapping("/viewsongs")
	public String viewSongs(Model model) {
		List<Song> allSongs = service.fetchSongs();
		model.addAttribute("songs", allSongs);
		System.out.println(allSongs);
		return "displaysongs";
	}
}
