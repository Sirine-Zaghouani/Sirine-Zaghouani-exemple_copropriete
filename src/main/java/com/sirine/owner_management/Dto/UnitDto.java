package com.sirine.owner_management.Dto;

import com.sirine.owner_management.entity.Unit;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class UnitDto {

    private Long id;
    private String unitName;
    private int floorArea;
    private String emplacement;
    private int numberRooms;
    private String block;

    public static Unit toEntity(UnitDto unitDto) {
        Unit unit = new Unit();
        unit.setId(unitDto.getId());
        unit.setUnitName(unitDto.getUnitName());
        unit.setFloorArea(unitDto.getFloorArea());
        unit.setEmplacement(unitDto.getEmplacement());
        unit.setNumberRooms(unitDto.getNumberRooms());
        unit.setBlock(unitDto.getBlock());
        return unit;
    }

    public static UnitDto fromEntity(Unit unit) {
        return UnitDto.builder()
                .id(unit.getId())
                .unitName(unit.getUnitName())
                .floorArea(unit.getFloorArea())
                .emplacement(unit.getEmplacement())
                .numberRooms(unit.getNumberRooms())
                .block(unit.getBlock())
                .build();
    }

    public static List<UnitDto> toDtoList(List<Unit> units) {
        return units.stream()
                .map(UnitDto::fromEntity)
                .collect(Collectors.toList());
    }

    public static List<Unit> toEntityList(List<UnitDto> unitDtos) {
        return unitDtos.stream()
                .map(UnitDto::toEntity)
                .collect(Collectors.toList());
    }
}
