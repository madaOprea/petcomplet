package com.app.petcomplet.service;

import com.app.petcomplet.model.Pet;
import com.app.petcomplet.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetServiceImplementation implements PetService {

    private final PetRepository petRepository;

    @Autowired
    public PetServiceImplementation(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }
}
