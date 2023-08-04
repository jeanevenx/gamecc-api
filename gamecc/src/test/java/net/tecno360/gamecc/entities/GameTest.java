package net.tecno360.gamecc.entities;

import jakarta.persistence.Column;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GameTest {

    @Test
    void validateGameProperties(){
        Game game = new Game();

        game.setId(1);
        game.setTitle("Red Dead Redemption 2");
        game.setYear(2018);
        game.setGenre("Role-playing (RPG), Adventure");
        game.setPlatforms("XBox, Playstation, PC");
        game.setScore(4.7);
        game.setImgUrl("https://cdn.akamai.steamstatic.com/steam/apps/1174180/header.jpg?t=1671485009");
        game.setShortDescription("Some short description for this game.");
        game.setLongDescription("Some long description for this super and funny game.");

        assertEquals(1, game.getId());
        assertEquals("Red Dead Redemption 2", game.getTitle());
        assertEquals(2018, game.getYear());                                                                                
        assertEquals("Role-playing (RPG), Adventure", game.getGenre());
        assertEquals("XBox, Playstation, PC", game.getPlatforms());
        assertEquals(4.7, game.getScore());
        assertEquals("https://cdn.akamai.steamstatic.com/steam/apps/1174180/header.jpg?t=1671485009", game.getImgUrl());
        assertEquals("Some short description for this game.", game.getShortDescription());
        assertEquals("Some long description for this super and funny game.", game.getLongDescription());


        
    }

}




