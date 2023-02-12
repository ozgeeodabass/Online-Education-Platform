package ceng.gradProject.business.abstracts;

import java.util.List;
import ceng.gradProject.core.utilities.results.DataResult;
import ceng.gradProject.core.utilities.results.Result;
import ceng.gradProject.entities.concretes.Course;

public interface CourseService {
	DataResult<List<Course>> getAll();
	
	Result add(Course course);
	
	Result delete(Course course);
	
	DataResult<Course> update(Course course);
	
	DataResult<Course> getByCourseId(int id);
	
	DataResult<List<Course>> getAllByPage(int pageNo, int pageSize);
	
	DataResult<Course> getByCourseTitle(String title);
	
	DataResult<List<Course>> getBySubject(int id);
	
	DataResult<List<Course>> getByCourseTitleContains(String name);
	
	DataResult<List<Course>> getByInstructor(int id);
	
	DataResult<List<Course>> getByUsers(int id);
	
	DataResult<List<Course>> getByDepartment(int id);
	
	DataResult<Course> getByMediaId(int id);
}
