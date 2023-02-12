package ceng.gradProject.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ceng.gradProject.business.abstracts.SubjectService;
import ceng.gradProject.core.utilities.results.DataResult;
import ceng.gradProject.core.utilities.results.Result;
import ceng.gradProject.entities.concretes.Subject;

@RestController
@RequestMapping("/api/subjects")
@CrossOrigin
public class SubjectsController {
	private SubjectService subjectService;

	@Autowired
	public SubjectsController(SubjectService subjectService) {
		this.subjectService = subjectService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Subject>> getAll(){
		return subjectService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(Subject subject) {
		return subjectService.add(subject);
	}
	
	@PostMapping("/updateSubject")
	public DataResult<Subject> update(Subject subject) {
		return this.subjectService.update(subject);
	}
	
	@DeleteMapping("/deleteSubject")
	public Result delete(Subject subject) {
		return this.subjectService.delete(subject);
	}
	
	@GetMapping("/getBySubjectId")
	public DataResult<Subject> getBySubjectId(int id) {
		return this.subjectService.getBySubjectId(id);
	}

}
