package net.tecno360.gamecc.entities;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ClassificationListTest {
    @Test
    void validateClassificationProperties(){
        ClassificationList classification = new ClassificationList();

        classification.setId(1L);
        classification.setName("Aventura e RPG");

        assertEquals(1L, classification.getId());
        assertEquals("Aventura e RPG", classification.getName());
    }
}
