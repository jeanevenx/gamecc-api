package net.tecno360.gamecc.services.interfaces;

import net.tecno360.gamecc.dto.ClassificationListDTO;

import java.util.List;
import java.util.Optional;

public interface IClassificationListService {
    List<ClassificationListDTO> getAllClassification();
    Optional<ClassificationListDTO> getClassificationById(Long id);
    void move(Long id, int originIndex, int destinationIndex);
}
