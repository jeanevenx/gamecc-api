package net.tecno360.gamelt.controllers;

import net.tecno360.gamelt.dto.ClassificationListDTO;
import net.tecno360.gamelt.dto.GameDTO;
import net.tecno360.gamelt.dto.GameMinDTO;
import net.tecno360.gamelt.services.ClassificationListService;
import net.tecno360.gamelt.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/classifications")
public class ClassificationListController {

    @Autowired
    private ClassificationListService ClassificationService;

    @GetMapping
    public List<ClassificationListDTO> getAll(){
        return ClassificationService.getAllClassification();

    }

}
