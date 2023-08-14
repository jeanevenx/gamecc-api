package net.tecno360.gamecc.services.unit;

import net.tecno360.gamecc.dto.GameMinDTO;
import net.tecno360.gamecc.entities.Game;
import net.tecno360.gamecc.repositories.GameRepository;
import net.tecno360.gamecc.services.impl.GameServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class GameServiceTests {

    @InjectMocks
    private GameServiceImpl gameService;

    @Mock
    private GameRepository gameRepository;

    @Test
    public void testFindAllGameMinDTO(){

       Mockito.when(gameRepository.findAll()).thenReturn(listGame());

       List<GameMinDTO> gameToGameMinDTO = listGame().stream().map(GameMinDTO::new).toList();

       List<GameMinDTO> gameMinDTO = gameService.findAllGameMinDTOs();

       Assertions.assertEquals(gameToGameMinDTO, gameMinDTO);

    }


    List<Game> listGame(){
        Game game = new Game();

        game.setId(1L);
        game.setTitle("Red Dead Redemption 2");
        game.setScore(4.7);
        game.setYear(2018);
        game.setGenre("Role-playing (RPG), Adventure");
        game.setPlatforms("XBox, Playstation, PC");
        game.setImgUrl("https://cdn.akamai.steamstatic.com/steam/apps/1174180/header.jpg?t=1671485009");
        game.setShortDescription("Lorem ipsum dolor sit amet consectetur adipisicing elit.");
        game.setLongDescription("Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam!");

        List<Game> list = new ArrayList<>();

        list.add(game);

        return list;
    }

}
