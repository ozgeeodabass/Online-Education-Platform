package ceng.gradProject.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ceng.gradProject.entities.concretes.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
	
	Course getByCourseTitle(String title);
	
	//@Query("From Course where subject.subjectId=:subjectId")
	List<Course> getBySubject_SubjectId(int subjectId);
	
	List<Course> getByCourseTitleContainsIgnoreCase(String title);
	
	List<Course> getByInstructor_InstrId(int instrId);
	
	List<Course> getByEnrolledUsers_UserId(int userId);
	
	List<Course> getByDepartment_DeptId(int deptId);
	
	Course getByMedias_MediaId(int mediaId);
	
}
