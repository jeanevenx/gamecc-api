package net.tecno360.gamelt.services;

import net.tecno360.gamelt.dto.ClassificationListDTO;
import net.tecno360.gamelt.dto.GameDTO;
import net.tecno360.gamelt.dto.GameMinDTO;
import net.tecno360.gamelt.entities.ClassificationList;
import net.tecno360.gamelt.entities.Game;
import net.tecno360.gamelt.repositories.ClassificationListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClassificationListService {
    @Autowired
    private ClassificationListRepository classificationRepo;

    @Transactional(readOnly = true)
    public List<ClassificationListDTO> getAllClassification(){
        List<ClassificationList> result = classificationRepo.findAll();
        return result.stream().map(ClassificationListDTO::new).toList();

    }

    @Transactional(readOnly = true)
    public ClassificationListDTO getClassificationById(Long id){
        ClassificationList result = classificationRepo.findById(id).orElseThrow();

        return new ClassificationListDTO(result);
    }
}
