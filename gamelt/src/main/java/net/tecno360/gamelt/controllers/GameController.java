package net.tecno360.gamelt.controllers;

import net.tecno360.gamelt.dto.GameDTO;
import net.tecno360.gamelt.dto.GameMinDTO;
import net.tecno360.gamelt.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDTO> getAll(){
        return gameService.getAllGames();

    }

    @GetMapping(value = "/{id}")
    public GameDTO getById(@PathVariable Long id){
        return gameService.getGameById(id);
    }
}
