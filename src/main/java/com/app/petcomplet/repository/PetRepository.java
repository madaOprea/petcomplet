package com.app.petcomplet.repository;

import com.app.petcomplet.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

@Repository
public interface PetRepository extends JpaRepository<Pet, String> {
}
