package net.tecno360.gamecc.services.unit;

import net.tecno360.gamecc.dto.ClassificationListDTO;
import net.tecno360.gamecc.entities.ClassificationList;
import net.tecno360.gamecc.repositories.ClassificationListRepository;
import net.tecno360.gamecc.services.impl.ClassificationListServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
public class ClassificationListServiceTests {

    @InjectMocks
    private ClassificationListServiceImpl classificationListService;

    @Mock
    private ClassificationListRepository classificationListRepository;

    @Test
    public void testGetAllClassification(){
        List<ClassificationList> list = new ArrayList<>();
        list.add(getClassification());

        when(classificationListRepository.findAll()).thenReturn(list);

        List<ClassificationListDTO> expectedClassificationDTO = list.stream().map(ClassificationListDTO::new).toList();

        List<ClassificationListDTO> result = classificationListService.getAllClassification();

        Assertions.assertEquals(expectedClassificationDTO, result);
    }

    @Test
    public void testGetClassificationById(){
        Optional<ClassificationList> classificationList = Optional.of(getClassification());

        when(classificationListRepository.findById(1L)).thenReturn(classificationList);

        Optional<ClassificationListDTO> result = classificationListService.getClassificationById(1L);

        Optional<ClassificationListDTO> expectedClassificationDTO = Optional.of(new ClassificationListDTO(getClassification()));

        Assertions.assertEquals(expectedClassificationDTO, result);
    }

    protected static ClassificationList getClassification(){
        ClassificationList classificationList = new ClassificationList();
        classificationList.setId(1L);
        classificationList.setName("Aventura e RPG");

        return classificationList;
    }
}
