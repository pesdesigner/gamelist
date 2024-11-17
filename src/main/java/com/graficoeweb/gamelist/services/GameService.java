package com.graficoeweb.gamelist.services;

import com.graficoeweb.gamelist.dto.GameDTO;
import com.graficoeweb.gamelist.dto.GameMinDTO;
import com.graficoeweb.gamelist.entities.Game;
import com.graficoeweb.gamelist.repositories.GameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }
    public List<GameMinDTO> findAll() {
       List<Game> result = gameRepository.findAll();
       return result.stream().map(x -> new GameMinDTO(x)).toList();
    }

}
