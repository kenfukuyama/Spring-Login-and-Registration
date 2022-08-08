package com.kenfukuyama.examples.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kenfukuyama.examples.models.Dojo;
import com.kenfukuyama.examples.repositories.DojoRepo;

@Service
public class DojoService {
    private final DojoRepo dojoRepo;
	
	public DojoService(DojoRepo dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
	public List<Dojo> allDojos() {
		return dojoRepo.findAll();
	}	
	
    public Dojo createDojo(Dojo dojo) {
        return dojoRepo.save(dojo);
    }
    
    
 // retrieves a dojo
    public Dojo findDojo(Long id) {
    	// Optional Dojo that may or may not conatin Dojo
        Optional<Dojo> optionalDojo = dojoRepo.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
    
    

    // udpated
    public Dojo updateDojo(Dojo dojo) {
        return dojoRepo.save(dojo);
    }
    
    
    // Delete a dojo
    public void deleteDojo(Long id) {
        dojoRepo.deleteById(id);
        return;
    }

}
