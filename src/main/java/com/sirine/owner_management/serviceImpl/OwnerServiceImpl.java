package com.sirine.owner_management.serviceImpl;

import com.sirine.owner_management.entity.Owner;
import com.sirine.owner_management.repository.OwnerRepository;
import com.sirine.owner_management.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public Owner saveOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public List<Owner> findAllOwners() {
        return ownerRepository.findAll();
    }

    @Override
    public Optional<Owner> findOwnerById(Long id) {
        return ownerRepository.findById(id);
    }

    @Override
    public void removeOwner(Long id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public Optional<Owner> findOwnerByCin(String cin) {
        return ownerRepository.findByCin(cin);
    }


    @Override
    public Optional<Owner> findOwnerByUsername(String username) {
        return ownerRepository.findByUsername(username);
    }

    @Override
    public Optional<Owner> findOwnerByEmail(String email) {
        List<Owner> owners = ownerRepository.findAll();
        Optional<Owner> ownerOptional = owners.stream()
                .filter(owner -> owner.getContacts().stream()
                        .anyMatch(contact -> email.equals(contact.getEmail())))
                .findFirst();
        return ownerOptional;
    }

    @Override
    public Optional<Owner> findOwnersByBlock(String block){
        List<Owner> owners = ownerRepository.findAll();
        Optional<Owner> ownerOptional = owners.stream()
                .filter(owner -> owner.getUnits().stream()
                        .anyMatch(unit -> block.equals(unit.getBlock())))
                .findFirst();
        return ownerOptional;
    }
}
