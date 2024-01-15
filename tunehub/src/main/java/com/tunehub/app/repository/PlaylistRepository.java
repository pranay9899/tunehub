package com.tunehub.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunehub.app.entity.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {

}
