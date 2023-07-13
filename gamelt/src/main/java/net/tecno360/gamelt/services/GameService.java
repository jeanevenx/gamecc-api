package net.tecno360.gamelt.services;

import net.tecno360.gamelt.dto.GameDTO;
import net.tecno360.gamelt.dto.GameMinDTO;
import net.tecno360.gamelt.entities.Game;
import net.tecno360.gamelt.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.util.ClassUtils.isPresent;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepo;

    @Transactional(readOnly = true)
    public List<GameMinDTO> getAllGames(){
        List<Game> result = gameRepo.findAll();
        return result.stream().map(GameMinDTO::new).toList();

    }

    @Transactional(readOnly = true)
    public GameDTO getGameById(Long id){
        Game result = gameRepo.findById(id).orElseThrow();

        return new GameDTO(result);
    }
}
