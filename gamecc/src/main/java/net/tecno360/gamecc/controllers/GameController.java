package net.tecno360.gamecc.controllers;

import net.tecno360.gamecc.dto.GameDTO;
import net.tecno360.gamecc.dto.GameMinDTO;
import net.tecno360.gamecc.services.GameService;
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
        return gameService.findAllGames();

    }

    @GetMapping(value = "/{id}")
    public GameDTO getById(@PathVariable Long id){
        return gameService.findGameById(id);
    }
}
