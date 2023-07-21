package net.tecno360.gamecc.services;

import net.tecno360.gamecc.dto.ClassificationListDTO;
import net.tecno360.gamecc.entities.ClassificationList;
import net.tecno360.gamecc.projections.GameMinProjection;
import net.tecno360.gamecc.repositories.ClassificationListRepository;
import net.tecno360.gamecc.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClassificationListService {
    @Autowired
    private ClassificationListRepository classificationListRepo;
    @Autowired
    private GameRepository gameRepo;

    @Transactional(readOnly = true)
    public List<ClassificationListDTO> findAllClassification(){
        List<ClassificationList> result = classificationListRepo.findAll();
        return result.stream().map(ClassificationListDTO::new).toList();

    }

    @Transactional(readOnly = true)
    public ClassificationListDTO getClassificationById(Long id){
        ClassificationList result = classificationListRepo.findById(id).orElseThrow();

        return new ClassificationListDTO(result);
    }

    @Transactional(readOnly = true)
    public void move(Long id, int originIndex, int destinationIndex){
        List<GameMinProjection> classification = gameRepo.searchByClassification(id);
        GameMinProjection obj = classification.remove(originIndex);
        classification.add(destinationIndex, obj);

        int min = Math.min(originIndex, destinationIndex);
        int max = Math.max(originIndex, destinationIndex);


        for(int i=min; i<= max; i++){
            classificationListRepo.updateBelongingPosition(id, classification.get(i).getId(), i);
        }

    }
}
