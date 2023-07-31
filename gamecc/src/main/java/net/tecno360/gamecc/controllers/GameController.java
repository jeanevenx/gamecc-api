package net.tecno360.gamecc.controllers;

import net.tecno360.gamecc.dto.GameDTO;
import net.tecno360.gamecc.dto.GameMinDTO;
import net.tecno360.gamecc.exception.GameNotFoundException;
import net.tecno360.gamecc.services.impl.GameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    private final GameServiceImpl gameServiceImpl;

    public GameController(GameServiceImpl gameServiceImpl) {
        this.gameServiceImpl = gameServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<GameMinDTO>> getAll(){
        List<GameMinDTO> games = gameServiceImpl.findAllGames();

            return ResponseEntity.status(HttpStatus.OK).body(games);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<GameDTO>> getGameById(@PathVariable Long id){
        Optional<GameDTO> games = gameServiceImpl.findGameById(id);
        return ResponseEntity.status(HttpStatus.OK).body(games);
    }
}
