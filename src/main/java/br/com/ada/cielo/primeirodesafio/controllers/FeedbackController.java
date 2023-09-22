package br.com.ada.cielo.primeirodesafio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ada.cielo.primeirodesafio.components.FeedbackComponent;
import br.com.ada.cielo.primeirodesafio.modelos.CustomerFeedbackDTO;
import br.com.ada.cielo.primeirodesafio.modelos.CustomerFeedbackVO;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	
	@Autowired
	FeedbackComponent component;
	    
    @PostMapping(path = "/", produces = "application/json")
    public CustomerFeedbackVO publicarFeeedback(@RequestBody CustomerFeedbackDTO feedback) throws Exception {
    	return component.publicarFeeedback(feedback);
    }

}
