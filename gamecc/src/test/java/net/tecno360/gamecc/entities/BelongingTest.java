package net.tecno360.gamecc.entities;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BelongingTest {
    @Test
    void validateBelongingProperties(){

        Belonging belonging = new Belonging();

        belonging.setId(new BelongingPK(new Game(),new ClassificationList()));

        belonging.setPosition(0);

        assertEquals(new BelongingPK(new Game(),new ClassificationList()), belonging.getId());
        assertEquals(0, belonging.getPosition());
    }


}
