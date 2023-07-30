package net.tecno360.gamecc.services.impl;

import net.tecno360.gamecc.dto.ClassificationListDTO;
import net.tecno360.gamecc.entities.ClassificationList;
import net.tecno360.gamecc.projections.GameMinProjection;
import net.tecno360.gamecc.repositories.ClassificationListRepository;
import net.tecno360.gamecc.repositories.GameRepository;
import net.tecno360.gamecc.services.interfaces.IClassificationListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClassificationListServiceImpl implements IClassificationListService {
    @Autowired
    private ClassificationListRepository classificationListRepo;
    @Autowired
    private GameRepository gameRepo;

    @Transactional(readOnly = true)
    @Override
    public List<ClassificationListDTO> getAllClassification(){
        List<ClassificationList> result = classificationListRepo.findAll();
        return result.stream().map(ClassificationListDTO::new).toList();

    }

    @Transactional(readOnly = true)
    @Override
    public Optional<ClassificationListDTO> getClassificationById(Long id){
        ClassificationList result = classificationListRepo.findById(id).orElseThrow();

        return Optional.of(new ClassificationListDTO(result));
    }

    @Transactional(readOnly = true)
    @Override
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
