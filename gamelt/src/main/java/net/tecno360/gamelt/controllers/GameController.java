package net.tecno360.gamelt.controllers;

import net.tecno360.gamelt.dto.GameDTO;
import net.tecno360.gamelt.entities.Game;
import net.tecno360.gamelt.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameDTO> getAll(){
        return gameService.findAll();

    }
}
