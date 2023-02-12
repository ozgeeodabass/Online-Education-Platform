package ceng.gradProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ceng.gradProject.entities.concretes.Course;
import ceng.gradProject.entities.concretes.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	
	User getByUserNameIgnoreCase(String name);
	
	List<User> getByDepartment_DeptId(int id);
	
	List<Course> getAllEnrolledCoursesByUserId(int id);

}
