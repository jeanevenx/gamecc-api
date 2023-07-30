package net.tecno360.gamecc.controllers;

import net.tecno360.gamecc.dto.ChangeGamePositionDTO;
import net.tecno360.gamecc.dto.ClassificationListDTO;
import net.tecno360.gamecc.dto.GameMinDTO;
import net.tecno360.gamecc.services.impl.ClassificationListServiceImpl;
import net.tecno360.gamecc.services.impl.GameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/classifications")
public class ClassificationListController {

    @Autowired
    private ClassificationListServiceImpl classificationListServiceImpl;

    @Autowired
    private GameServiceImpl gameServiceImpl;

    @GetMapping
    public List<ClassificationListDTO> getAll(){
        return classificationListServiceImpl.getAllClassification();

    }

    @GetMapping(value = "/{id}/games")
    public List<GameMinDTO> getGameByClassification(@PathVariable Long id){

        return gameServiceImpl.findGameByClassification(id);
    }

    @PostMapping(value = "/{id}/replacement")
    public void move(@PathVariable Long id, @RequestBody ChangeGamePositionDTO body){

        classificationListServiceImpl.move(id, body.getOriginIndex(), body.getDestinationIndex());
    }


}
