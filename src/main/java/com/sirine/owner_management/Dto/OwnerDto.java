package com.sirine.owner_management.Dto;
import com.sirine.owner_management.entity.Contact;
import com.sirine.owner_management.entity.Owner;
import com.sirine.owner_management.entity.Unit;
import lombok.Builder;
import lombok.Data;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class OwnerDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String cin;
    private Date dateBirth;
    private String gender;
    private String address;
    private List<ContactDto> contacts;
    private List<UnitDto> units;

    public static Owner toEntity(OwnerDto ownerDto) {
        Owner owner = new Owner();
        owner.setId(ownerDto.getId());
        owner.setFirstName(ownerDto.getFirstName());
        owner.setLastName(ownerDto.getLastName());
        owner.setUsername(ownerDto.getUsername());
        owner.setCin(ownerDto.getCin());
        owner.setDateBirth(ownerDto.getDateBirth());
        owner.setGender(ownerDto.getGender());
        owner.setAddress(ownerDto.getAddress());
        List<ContactDto> contacts = ownerDto.getContacts();
        List<UnitDto> units = ownerDto.getUnits();
        return owner;
    }

    // Méthode pour convertir Owner en OwnerDto
    public static OwnerDto fromEntity(Owner owner) {
        List<ContactDto> contactDtos = owner.getContacts().stream()
                .map(ContactDto::fromEntity) // Convertir chaque Contact en ContactDto
                .collect(Collectors.toList());
        List<UnitDto> unitDtos = owner.getUnits().stream()
                .map(UnitDto::fromEntity) // Convertir chaque Contact en ContactDto
                .collect(Collectors.toList());

        return OwnerDto.builder()
                .id(owner.getId())
                .firstName(owner.getFirstName())
                .lastName(owner.getLastName())
                .username(owner.getUsername())
                .cin(owner.getCin())
                .dateBirth(owner.getDateBirth())
                .gender(owner.getGender())
                .contacts(contactDtos)
                .address(owner.getAddress())
                .units(unitDtos)
                .build();
    }
    // Méthode pour convertir une liste d'entités Owner en une liste de DTO OwnerDto
    public static List<OwnerDto> toDtoList(List<Owner> owners) {
        return owners.stream()
                .map(OwnerDto::fromEntity) // Utilisation de la méthode fromEntity pour chaque Owner
                .collect(Collectors.toList());
    }
}
