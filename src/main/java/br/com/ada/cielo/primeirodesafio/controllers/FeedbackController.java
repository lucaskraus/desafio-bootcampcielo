package br.com.ada.cielo.primeirodesafio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ada.cielo.primeirodesafio.components.FeedbackComponent;
import br.com.ada.cielo.primeirodesafio.modelos.CustomerFeedbackDto;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	
	@Autowired
	FeedbackComponent component;
	
    @GetMapping(path = "/teste", produces = "application/json")
    public String teste() {
        return "Teste";
    }
    
    @PostMapping(path = "/")
    public CustomerFeedbackDto publicarFeeedback(@RequestBody CustomerFeedbackDto feedback) {
    	return component.publicarFeeedback(feedback);
    }

}
