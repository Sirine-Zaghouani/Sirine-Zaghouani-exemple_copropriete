package com.sirine.owner_management.repository;

import com.sirine.owner_management.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    Optional<Owner> findByCin(String cin);

    Optional<Owner> findByUsername(String username);

}

