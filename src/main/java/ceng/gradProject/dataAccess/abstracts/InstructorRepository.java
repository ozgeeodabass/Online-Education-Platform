package ceng.gradProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ceng.gradProject.entities.concretes.Course;
import ceng.gradProject.entities.concretes.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

	List<Instructor> getByDepartment_DeptId(int id);
	
	@Query(("From Instructor where instrFirstName=:fName and instrLastName=:lName"))
	Instructor getByName(String fName, String lName);
	
	List<Course> getAllCoursesByInstrId(int id);
	
}
