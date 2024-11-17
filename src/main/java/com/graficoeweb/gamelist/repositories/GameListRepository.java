package com.graficoeweb.gamelist.repositories;

import com.graficoeweb.gamelist.entities.Game;
import com.graficoeweb.gamelist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
