package net.tecno360.gamecc.services.impl;

import net.tecno360.gamecc.dto.GameDTO;
import net.tecno360.gamecc.dto.GameMinDTO;
import net.tecno360.gamecc.entities.Game;
import net.tecno360.gamecc.exception.GameNotFoundException;
import net.tecno360.gamecc.projections.GameMinProjection;
import net.tecno360.gamecc.repositories.GameRepository;
import net.tecno360.gamecc.services.interfaces.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements IGameService {

    private final  GameRepository gameRepo;
    @Autowired
    public GameServiceImpl(GameRepository gameRepo) {
        this.gameRepo = gameRepo;
    }

    @Transactional(readOnly = true)
    @Override
    public List<GameMinDTO> findAllGames(){
        List<Game> result = gameRepo.findAll();
        return result.stream().map(GameMinDTO::new).toList();

    }

    @Transactional(readOnly = true)
    @Override
    public Optional<GameDTO> findGameById(Long id){

        Game result = gameRepo
                .findById(id)
                .orElseThrow(() ->
                        new GameNotFoundException("Game with id:" + id + " does not exist!"));

        return Optional.of(new GameDTO(result));
    }

    @Transactional(readOnly = true)
    @Override
    public List<GameMinDTO> findGameByClassification(Long classificationId){

        List<GameMinProjection> result = gameRepo.searchByClassification(classificationId);

        return result.stream().map(GameMinDTO::new).toList();
    }
}
