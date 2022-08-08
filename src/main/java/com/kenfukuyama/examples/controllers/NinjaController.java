package com.kenfukuyama.examples.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kenfukuyama.examples.models.Dojo;
import com.kenfukuyama.examples.models.Ninja;
import com.kenfukuyama.examples.services.DojoService;
import com.kenfukuyama.examples.services.NinjaService;

@Controller // this will return .jsp
public class NinjaController {
    private final NinjaService ninjaService;
    private final DojoService dojoService;

    public NinjaController(NinjaService ninjaService, DojoService dojoService) {
        this.ninjaService = ninjaService;
        this.dojoService = dojoService;
    }
    
    
    
    // ! Get Ninjas
    @GetMapping("/ninjas")
    public String ninjas(@ModelAttribute("ninja") Ninja ninja, Model model) {
    	List<Dojo> dojos = dojoService.allDojos();
    	model.addAttribute("dojos",dojos);
    	
        return "newNinja.jsp";

    }
    
    
 // ! POST ninjas
    @PostMapping("/ninjas")
    public String ninjaCreate(@Valid @ModelAttribute("ninja") Ninja ninja,
            BindingResult result) {

        if (result.hasErrors()) {
            return "newNinja.jsp";
        }

        ninjaService.createNinja(ninja);
        return "redirect:/ninjas";
    }
    
	

}
