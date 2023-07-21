package net.tecno360.gamecc.dto;

import net.tecno360.gamecc.entities.ClassificationList;

public class ClassificationListDTO {
    private Long id;
    private String name;

    public ClassificationListDTO() {
    }

    public ClassificationListDTO(ClassificationList entity) {
        id = entity.getId();
        name  = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
