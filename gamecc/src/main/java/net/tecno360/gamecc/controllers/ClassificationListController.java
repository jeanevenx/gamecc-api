package net.tecno360.gamecc.controllers;

import net.tecno360.gamecc.dto.ChangeGamePositionDTO;
import net.tecno360.gamecc.dto.ClassificationListDTO;
import net.tecno360.gamecc.dto.GameMinDTO;
import net.tecno360.gamecc.services.impl.ClassificationListServiceImpl;
import net.tecno360.gamecc.services.impl.GameServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/classifications")
public class ClassificationListController {

    private final ClassificationListServiceImpl classificationListServiceImpl;
    private final GameServiceImpl gameServiceImpl;

    public ClassificationListController(ClassificationListServiceImpl classificationListServiceImpl, GameServiceImpl gameServiceImpl) {
        this.classificationListServiceImpl = classificationListServiceImpl;
        this.gameServiceImpl = gameServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<ClassificationListDTO>> getAll(){
        List<ClassificationListDTO> classifications = classificationListServiceImpl
                        .getAllClassification();
        return ResponseEntity.status(HttpStatus.OK).body(classifications);

    }

    @GetMapping(value = "/{id}/games")
    public ResponseEntity<List<GameMinDTO>> getGameByClassification(@PathVariable Long id){
        Optional<ClassificationListDTO> classification = classificationListServiceImpl
                .getClassificationById(id);
        List<GameMinDTO> gameMinDTOList = gameServiceImpl
                .findGameByClassification(classification.orElseThrow().getId());

        return ResponseEntity.status(HttpStatus.OK).body(gameMinDTOList);
    }

    @PostMapping(value = "/{id}/replacement")
    public void swapGame(@PathVariable Long id, @RequestBody ChangeGamePositionDTO body){

        classificationListServiceImpl.move(id, body.getOriginIndex(), body.getDestinationIndex());

    }


}
