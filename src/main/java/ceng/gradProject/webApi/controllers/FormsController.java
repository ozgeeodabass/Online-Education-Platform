package ceng.gradProject.webApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ceng.gradProject.business.abstracts.FormService;
import ceng.gradProject.core.utilities.results.Result;
import ceng.gradProject.entities.concretes.Form;

@RestController
@RequestMapping("/api/forms")
@CrossOrigin
public class FormsController {
	
	private FormService formService;

	@Autowired
	public FormsController(FormService formService) {
		this.formService = formService;
	}
	
	@PostMapping("/add")
	public Result add(Form form) {
		return this.formService.add(form);
	}
}
