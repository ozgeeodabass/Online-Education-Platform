package ceng.gradProject.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ceng.gradProject.business.abstracts.DepartmentService;
import ceng.gradProject.core.utilities.results.DataResult;
import ceng.gradProject.core.utilities.results.Result;
import ceng.gradProject.entities.concretes.Department;

@RestController
@RequestMapping("/api/departments")
@CrossOrigin
public class DepartmentController {

	private DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) {
		super();
		this.departmentService = departmentService;
	}
	
	@GetMapping("/getByDepartmentName")
	public DataResult<Department> getByDeptName(String name) {
		return this.departmentService.getByDeptName(name);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Department>> getAll() {
		return this.departmentService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(Department department) {
		return this.departmentService.add(department);
	}
	
	@DeleteMapping("/delete")
	public Result delete(Department department) {
		return this.departmentService.delete(department);
	}
	
	@PostMapping("/update")
	public DataResult<Department> update(Department department) {
		return this.departmentService.update(department);
	}
	
	@GetMapping("/getByDeptId")
	public DataResult<Department> getByDeptId(int id) {
		return this.departmentService.getByDeptId(id);
	}
}
