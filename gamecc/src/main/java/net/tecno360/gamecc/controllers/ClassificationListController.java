package net.tecno360.gamecc.controllers;

import net.tecno360.gamecc.dto.ChangeGamePositionDTO;
import net.tecno360.gamecc.dto.ClassificationListDTO;
import net.tecno360.gamecc.dto.GameMinDTO;
import net.tecno360.gamecc.services.ClassificationListService;
import net.tecno360.gamecc.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/classifications")
public class ClassificationListController {

    @Autowired
    private ClassificationListService classificationListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<ClassificationListDTO> getAll(){
        return classificationListService.findAllClassification();

    }

    @GetMapping(value = "/{id}/games")
    public List<GameMinDTO> getGameByClassification(@PathVariable Long id){

        return gameService.findGameByClassification(id);
    }

    @PostMapping(value = "/{id}/replacement")
    public void move(@PathVariable Long id, @RequestBody ChangeGamePositionDTO body){

        classificationListService.move(id, body.getOriginIndex(), body.getDestinationIndex());
    }


}
