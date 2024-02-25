package com.sirine.owner_management.controller;

import com.sirine.owner_management.Dto.OwnerDto;
import com.sirine.owner_management.entity.Owner;
import com.sirine.owner_management.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @PostMapping("/create")
    public ResponseEntity<OwnerDto> createOwner(@RequestBody OwnerDto ownerDto) {
        Owner owner = OwnerDto.toEntity(ownerDto); // Convertir OwnerDto en Owner
        Owner createdOwner = ownerService.saveOwner(owner); // Enregistrer le propriétaire dans la base de données
        OwnerDto createdOwnerDto = OwnerDto.fromEntity(createdOwner); // Convertir Owner en OwnerDto
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOwnerDto);
    }

   @GetMapping
    public ResponseEntity<List<OwnerDto>> getAllOwners() {
        List<Owner> owners = ownerService.findAllOwners();
        return ResponseEntity.ok(OwnerDto.toDtoList(owners));
    }

    @DeleteMapping("/{ownerId}")
    public ResponseEntity<Void> deleteOwner(@PathVariable Long ownerId) {
        ownerService.removeOwner(ownerId);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/cin/{cin}")
    public ResponseEntity<OwnerDto> getOwnerByCin(@PathVariable String cin) {
        Optional<Owner> optionalOwner = ownerService.findOwnerByCin(cin);
        if (optionalOwner.isPresent()) {
            Owner owner = optionalOwner.get();
            OwnerDto ownerDto = OwnerDto.fromEntity(owner);
            return ResponseEntity.ok(ownerDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<OwnerDto> getOwnerByUsername(@PathVariable String username) {
        Optional<Owner> optionalOwner = ownerService.findOwnerByUsername(username);
        if (optionalOwner.isPresent()) {
            Owner owner = optionalOwner.get();
            OwnerDto ownerDto = OwnerDto.fromEntity(owner);
            return ResponseEntity.ok(ownerDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
   @GetMapping("/email/{email}")
    public ResponseEntity<OwnerDto> getOwnerByEmail(@PathVariable String email) {
        Optional<Owner> optionalOwner = ownerService.findOwnerByEmail(email);
        if (optionalOwner.isPresent()) {
            Owner owner = optionalOwner.get();
            OwnerDto ownerDto = OwnerDto.fromEntity(owner);
            return ResponseEntity.ok(ownerDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/block/{block}")
    public ResponseEntity<OwnerDto> getOwnersByBlock(@PathVariable String block) {
        Optional<Owner> optionalOwner = ownerService.findOwnersByBlock(block);
        if (optionalOwner.isPresent()) {
            Owner owner = optionalOwner.get();
            OwnerDto ownerDto = OwnerDto.fromEntity(owner);
            return ResponseEntity.ok(ownerDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
