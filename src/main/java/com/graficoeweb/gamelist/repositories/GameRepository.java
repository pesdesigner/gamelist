package com.graficoeweb.gamelist.repositories;

import com.graficoeweb.gamelist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
