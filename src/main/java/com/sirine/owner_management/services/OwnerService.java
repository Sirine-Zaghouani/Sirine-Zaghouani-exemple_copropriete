package com.sirine.owner_management.services;
import com.sirine.owner_management.entity.Owner;

import java.util.List;
import java.util.Optional;

public interface OwnerService {

    Owner saveOwner(Owner owner);

    List<Owner> findAllOwners();

    Optional<Owner> findOwnerById(Long id);

    void removeOwner(Long id);

    Optional<Owner> findOwnerByCin(String cin);
    Optional<Owner> findOwnerByEmail(String email);

    Optional<Owner> findOwnerByUsername(String username);

    Optional<Owner> findOwnersByBlock(String block);


}