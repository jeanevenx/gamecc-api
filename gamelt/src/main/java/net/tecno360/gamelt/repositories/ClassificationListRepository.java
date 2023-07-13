package net.tecno360.gamelt.repositories;

import net.tecno360.gamelt.entities.ClassificationList;
import net.tecno360.gamelt.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassificationListRepository extends JpaRepository<ClassificationList, Long> {
}
