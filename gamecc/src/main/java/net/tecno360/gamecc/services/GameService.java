package net.tecno360.gamecc.services;

import net.tecno360.gamecc.dto.GameDTO;
import net.tecno360.gamecc.dto.GameMinDTO;
import net.tecno360.gamecc.entities.Game;
import net.tecno360.gamecc.projections.GameMinProjection;
import net.tecno360.gamecc.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepo;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAllGames(){
        List<Game> result = gameRepo.findAll();
        return result.stream().map(GameMinDTO::new).toList();

    }

    @Transactional(readOnly = true)
    public GameDTO findGameById(Long id){
        Game result = gameRepo.findById(id).orElseThrow();

        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findGameByClassification(Long ClassificationId){
        List<GameMinProjection> result = gameRepo.searchByClassification(ClassificationId);

        return result.stream().map(GameMinDTO::new).toList();
    }
}
