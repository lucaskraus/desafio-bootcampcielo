package br.com.ada.cielo.primeirodesafio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ada.cielo.primeirodesafio.components.FeedbackComponent;
import br.com.ada.cielo.primeirodesafio.modelos.CustomerFeedbackDTO;
import br.com.ada.cielo.primeirodesafio.modelos.CustomerFeedbackVO;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

	@Autowired
	FeedbackComponent component;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping(path = "/novo-feedback", produces = "application/json")
	public CustomerFeedbackVO publicarFeeedback(@RequestBody CustomerFeedbackDTO feedback) throws Exception {
		return component.publicarFeeedback(feedback);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(path = "/", produces = "application/json")
	public List<CustomerFeedbackVO> buscarFeedbacks(@RequestParam(required = false) String tipo)
			throws Exception {
		return component.buscarFeedbacks(tipo);
	}

}
