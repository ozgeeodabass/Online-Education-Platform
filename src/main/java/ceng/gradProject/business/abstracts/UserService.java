package ceng.gradProject.business.abstracts;

import java.util.List;
import ceng.gradProject.core.utilities.results.DataResult;
import ceng.gradProject.core.utilities.results.Result;
import ceng.gradProject.entities.concretes.Course;
import ceng.gradProject.entities.concretes.User;

public interface UserService {

	DataResult<User> getByName(String name);
	DataResult<List<User>> getAll();
	Result add(User user);
	Result delete(User user);
	DataResult<List<User>> getByDepartment(int id);
	DataResult<User> update(User user);
	DataResult<User> getByUserId(int id);
	DataResult<List<Course>> getAllEnrolledCoursesByUserId(int id);
	Result login(String name, String password);
	DataResult<List<Course>> addToEnrolledCourses(int userId, int courseId);
}
