package com.elsevier.submissions.cdd.petstore.server.controller;

import com.elsevier.submissions.cdd.petstore.server.api.PetApi;
import com.elsevier.submissions.cdd.petstore.server.model.Pet;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController implements PetApi {
    
    @Override
    public ResponseEntity<Pet> _getPetById(Long petId) {
        Pet entity = new Pet()
                .id(petId)
                .name("Mock Pet");
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(entity);
    }
}
