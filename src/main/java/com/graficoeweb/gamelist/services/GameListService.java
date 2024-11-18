package com.graficoeweb.gamelist.services;

import com.graficoeweb.gamelist.dto.GameListDTO;
import com.graficoeweb.gamelist.entities.GameList;
import com.graficoeweb.gamelist.projections.GameMinProjection;
import com.graficoeweb.gamelist.repositories.GameListRepository;
import com.graficoeweb.gamelist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private GameListRepository gameListRepository;
    @Transactional(readOnly = true)
    public List<GameListDTO> findAll()
    {
       List<GameList> result = gameListRepository.findAll();
       return result.stream().map(x -> new GameListDTO(x)).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++){
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }

}
