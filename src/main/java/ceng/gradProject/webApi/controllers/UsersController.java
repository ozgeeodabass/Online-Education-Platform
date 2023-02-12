package ceng.gradProject.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ceng.gradProject.business.abstracts.UserService;
import ceng.gradProject.core.utilities.results.DataResult;
import ceng.gradProject.core.utilities.results.Result;
import ceng.gradProject.entities.concretes.Course;
import ceng.gradProject.entities.concretes.User;

@RestController
@RequestMapping("/api/users")
@CrossOrigin()
public class UsersController {
	
	private UserService userService;

	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/getByName")
	public DataResult<User> getByName(String name) {
		return this.userService.getByName(name);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<User>> getAll() {
		return this.userService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody User user) {
		return this.userService.add(user);
	}
	
	@DeleteMapping("/delete")
	public Result delete(User user) {
		return this.userService.delete(user);
	}
	
	@GetMapping("/getByDepartment")
	public DataResult<List<User>> getByDepartment(int id) {
		return this.userService.getByDepartment(id);
	}
	
	@PostMapping("/update")
	public DataResult<User> update(User user) {
		return this.userService.update(user);
	}
	
	@GetMapping("/getByUserId")
	public DataResult<User> getByUserId(int id) {
		return this.userService.getByUserId(id);
	}

	@GetMapping("/getAllEnrolledCoursesByUserId")
	public DataResult<List<Course>> getAllEnrolledCoursesByUserId(int id) {
		return this.userService.getAllEnrolledCoursesByUserId(id);
	}
	
	@PostMapping("/addToEnrolledCourses")
	public DataResult<List<Course>> addToEnrolledCourses(int userId, int courseId) {
		return this.userService.addToEnrolledCourses(userId, courseId);
	}
	
	@GetMapping("/login")
	public Result login(String name, String password) {
		return this.userService.login(name, password);
	}
}
