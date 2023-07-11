package net.tecno360.gamelt.services;

import net.tecno360.gamelt.dto.GameDTO;
import net.tecno360.gamelt.entities.Game;
import net.tecno360.gamelt.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepo;
    public List<GameDTO> findAll(){
        List<Game> result = gameRepo.findAll();
        return result.stream().map(GameDTO::new).toList();

    }
}
