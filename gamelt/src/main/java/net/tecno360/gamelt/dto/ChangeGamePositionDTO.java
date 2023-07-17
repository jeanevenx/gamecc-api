package net.tecno360.gamelt.dto;

public class ChangeGamePositionDTO {
    private Integer originIndex;
    private Integer destinationIndex;

    public ChangeGamePositionDTO() {
    }

    public Integer getOriginIndex() {
        return originIndex;
    }

    public void setOriginIndex(Integer originIndex) {
        this.originIndex = originIndex;
    }

    public Integer getDestinationIndex() {
        return destinationIndex;
    }

    public void setDestinationIndex(Integer destinationIndex) {
        this.destinationIndex = destinationIndex;
    }
}
