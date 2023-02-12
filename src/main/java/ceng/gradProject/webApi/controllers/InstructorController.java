package ceng.gradProject.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ceng.gradProject.business.abstracts.InstructorService;
import ceng.gradProject.core.utilities.results.DataResult;
import ceng.gradProject.core.utilities.results.Result;
import ceng.gradProject.entities.concretes.Course;
import ceng.gradProject.entities.concretes.Instructor;

@RestController
@RequestMapping("/api/instructors")
@CrossOrigin

public class InstructorController {
	
	private InstructorService instService;

	public InstructorController(InstructorService instService) {
		super();
		this.instService = instService;
	}
	
	@GetMapping("/getByName")
	public DataResult<Instructor> getByName(String fName, String lName) {
		return this.instService.getByName(fName, lName);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Instructor>> getAll() {
		return this.instService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(Instructor instr) {
		return this.instService.add(instr);
	}
	
	@DeleteMapping("/delete")
	public Result delete(Instructor instr) {
		return this.instService.delete(instr);
	}
	
	@GetMapping("/getByDepartment")
	public DataResult<List<Instructor>> getByDepartment(int id) {
		return this.instService.getByDepartment(id);
	}
	
	@PostMapping("/update")
	public DataResult<Instructor> update(Instructor instr) {
		return this.instService.update(instr);
	}
	
	@GetMapping("/getByInstrId")
	public DataResult<Instructor> getByInstrId(int id) {
		return this.instService.getByInstrId(id);
	}
	
	@GetMapping("/getAllCoursesByInstrId")
	public DataResult<List<Course>> getAllCoursesByInstrId(int id) {
		return this.instService.getAllCoursesByInstrId(id);
	}
	
	
	@GetMapping("/getAboutInstructor")
	public DataResult<String> getAboutInstr(int id){
		return this.instService.getAboutInstr(id);
	}
}