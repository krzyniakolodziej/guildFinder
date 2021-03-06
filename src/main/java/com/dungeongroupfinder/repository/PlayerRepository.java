package com.dungeongroupfinder.repository;

import com.dungeongroupfinder.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

    List<Player> findByName(String name);

    @Query(value = "SELECT * FROM players WHERE guild_id = :id", nativeQuery = true)
    List<Player> findByGuildId(@Param("id") int id);

    List<Player> findById(int id);

    @Query(value = "show tables", nativeQuery = true)
    List<String> getTables();
}
