package com.kenfukuyama.examples.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kenfukuyama.examples.models.Ninja;
import com.kenfukuyama.examples.repositories.NinjaRepo;

@Service
public class NinjaService {
    private final NinjaRepo ninjaRepo;
	
	public NinjaService(NinjaRepo ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	
	public List<Ninja> allNinjas() {
		return ninjaRepo.findAll();
	}	
	
    public Ninja createNinja(Ninja ninja) {
        return ninjaRepo.save(ninja);
    }
    
    
 // retrieves a ninja
    public Ninja findNinja(Long id) {
    	// Optional Ninja that may or may not conatin Ninja
        Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
        if(optionalNinja.isPresent()) {
            return optionalNinja.get();
        } else {
            return null;
        }
    }
    
    

    // udpated
    public Ninja updateNinja(Ninja ninja) {
        return ninjaRepo.save(ninja);
    }
    
    
    // Delete a ninja
    public void deleteNinja(Long id) {
        ninjaRepo.deleteById(id);
        return;
    }

}
