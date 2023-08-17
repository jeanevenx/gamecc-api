package net.tecno360.gamecc.dto;

import net.tecno360.gamecc.entities.ClassificationList;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClassificationListDTO that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "ClassificationListDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
