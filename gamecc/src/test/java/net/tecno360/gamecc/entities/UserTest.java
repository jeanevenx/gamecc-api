package net.tecno360.gamecc.entities;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserTest {

    @Test
    void validateUserProperties(){
        User user = new User();

        UUID uuid = UUID.randomUUID();

        user.setId(uuid);
        user.setName("Jean Evenx");
        user.setEmail("jeanvnx@gmail.com");
        user.setUsername("vnxe");
        user.setPassword("123fhTIJN#12");

        assertEquals(uuid, user.getId());
        assertEquals("Jean Evenx", user.getName());
        assertEquals("jeanvnx@gmail.com", user.getEmail());
        assertEquals("vnxe", user.getUsername());
        assertEquals("123fhTIJN#12", user.getPassword());
    }
}
