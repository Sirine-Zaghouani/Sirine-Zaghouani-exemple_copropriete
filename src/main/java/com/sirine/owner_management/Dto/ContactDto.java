package com.sirine.owner_management.Dto;

import com.sirine.owner_management.entity.Contact;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class ContactDto {

    private Long id;
    private Long phoneNumber;
    private String email;

    public static Contact toEntity(ContactDto contactDto) {
        Contact contact = new Contact();
        contact.setId(contactDto.getId());
        contact.setPhoneNumber(contactDto.getPhoneNumber());
        contact.setEmail(contactDto.getEmail());
        return contact;
    }

    public static ContactDto fromEntity(Contact contact) {
        return ContactDto.builder()
                .id(contact.getId())
                .phoneNumber(contact.getPhoneNumber())
                .email(contact.getEmail())
                .build();
    }

    // Méthode pour convertir une liste d'entités Contact en une liste de DTO ContactDto
    public static List<ContactDto> toDtoList(List<Contact> contacts) {
        return contacts.stream()
                .map(ContactDto::fromEntity) // Utilisation de la méthode fromEntity pour chaque Contact
                .collect(Collectors.toList());
    }

    // Méthode pour convertir une liste de DTO ContactDto en une liste d'entités Contact
    public static List<Contact> toEntityList(List<ContactDto> contactDtos) {
        return contactDtos.stream()
                .map(ContactDto::toEntity) // Utilisation de la méthode toEntity pour chaque ContactDto
                .collect(Collectors.toList());
    }
}
