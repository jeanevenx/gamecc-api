package net.tecno360.gamelt.repositories;

import net.tecno360.gamelt.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
