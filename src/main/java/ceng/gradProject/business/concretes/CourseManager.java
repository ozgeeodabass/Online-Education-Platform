package ceng.gradProject.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ceng.gradProject.business.abstracts.CourseService;
import ceng.gradProject.core.utilities.results.DataResult;
import ceng.gradProject.core.utilities.results.Result;
import ceng.gradProject.core.utilities.results.SuccessDataResult;
import ceng.gradProject.core.utilities.results.SuccessResult;
import ceng.gradProject.dataAccess.abstracts.CourseRepository;
import ceng.gradProject.entities.concretes.Course;

@Service
public class CourseManager implements CourseService {

	private CourseRepository courseRepository;
	
	
	public CourseManager(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}

	@Override
	public DataResult<List<Course>> getAll() {
		
		List<Course> courses = courseRepository.findAll();
		List<Course> coursesResponse = new ArrayList<Course>();
		
		for (Course course : courses) {
			Course responseItem = new Course();
			responseItem.setCourseId(course.getCourseId());
			responseItem.setCourseTitle(course.getCourseTitle());
			responseItem.setCourseDescription(course.getCourseDescription());
			responseItem.setDepartment(course.getDepartment());
			responseItem.setEnrolledUsers(course.getEnrolledUsers());
			responseItem.setInstructor(course.getInstructor());
			responseItem.setMedias(course.getMedias());
			responseItem.setSubject(course.getSubject());
			
			
			coursesResponse.add(responseItem);
			
		}
		return new SuccessDataResult<List<Course>>(coursesResponse,"Kurslar Listelendi");
	}

	@Override
	public Result add(Course course) {
		course.setCourseTitle(course.getCourseTitle());
		course.setCourseDescription(course.getCourseDescription());
		course.setDepartment(course.getDepartment());
		course.setInstructor(course.getInstructor());
		course.setSubject(course.getSubject());
		
		this.courseRepository.save(course);
		return new SuccessResult("Kurs Eklendi");
		
	}

	@Override
	public DataResult<Course> getByCourseTitle(String title) {
		Course course = courseRepository.getByCourseTitle(title);
		Course courseResponse = new Course();
	
		courseResponse.setCourseId(course.getCourseId());
		courseResponse.setCourseTitle(course.getCourseTitle());
		courseResponse.setCourseDescription(course.getCourseDescription());
		courseResponse.setDepartment(course.getDepartment());
		courseResponse.setEnrolledUsers(course.getEnrolledUsers());
		courseResponse.setInstructor(course.getInstructor());
		courseResponse.setMedias(course.getMedias());
		courseResponse.setSubject(course.getSubject());
			

		return new SuccessDataResult<Course>(courseResponse,"Kurslar Listelendi");
	}

	@Override
	public DataResult<List<Course>> getBySubject(int id) {
		List<Course> courses = courseRepository.getBySubject_SubjectId(id);
		List<Course> coursesResponse = new ArrayList<Course>();
		
		for (Course course : courses) {
			Course responseItem = new Course();
			responseItem.setCourseId(course.getCourseId());
			responseItem.setCourseTitle(course.getCourseTitle());
			responseItem.setCourseDescription(course.getCourseDescription());
			responseItem.setDepartment(course.getDepartment());
			responseItem.setEnrolledUsers(course.getEnrolledUsers());
			responseItem.setInstructor(course.getInstructor());
			responseItem.setMedias(course.getMedias());
			responseItem.setSubject(course.getSubject());
			
			coursesResponse.add(responseItem);
			
		}
		return new SuccessDataResult<List<Course>>(coursesResponse,"Kurslar Listelendi");
	}

	@Override
	public DataResult<List<Course>> getByCourseTitleContains(String name) {
		List<Course> courses = courseRepository.getByCourseTitleContainsIgnoreCase(name);
		List<Course> coursesResponse = new ArrayList<Course>();
		
		for (Course course : courses) {
			Course responseItem = new Course();
			responseItem.setCourseId(course.getCourseId());
			responseItem.setCourseTitle(course.getCourseTitle());
			responseItem.setCourseDescription(course.getCourseDescription());
			responseItem.setDepartment(course.getDepartment());
			responseItem.setEnrolledUsers(course.getEnrolledUsers());
			responseItem.setInstructor(course.getInstructor());
			responseItem.setMedias(course.getMedias());
			responseItem.setSubject(course.getSubject());
			
			coursesResponse.add(responseItem);
			
		}
		return new SuccessDataResult<List<Course>>(coursesResponse,"Kurslar Listelendi");
	}

	@Override
	public DataResult<List<Course>> getByInstructor(int id) {
		List<Course> courses = courseRepository.getByInstructor_InstrId(id);
		List<Course> coursesResponse = new ArrayList<Course>();
		
		for (Course course : courses) {
			Course responseItem = new Course();
			responseItem.setCourseId(course.getCourseId());
			responseItem.setCourseTitle(course.getCourseTitle());
			responseItem.setCourseDescription(course.getCourseDescription());
			responseItem.setDepartment(course.getDepartment());
			responseItem.setEnrolledUsers(course.getEnrolledUsers());
			responseItem.setInstructor(course.getInstructor());
			responseItem.setMedias(course.getMedias());
			responseItem.setSubject(course.getSubject());
			
			coursesResponse.add(responseItem);
			
		}
		return new SuccessDataResult<List<Course>>(coursesResponse,"Kurslar Listelendi");
	}

	@Override
	public DataResult<List<Course>> getByUsers(int id) {
		List<Course> courses = courseRepository.getByEnrolledUsers_UserId(id);
		List<Course> coursesResponse = new ArrayList<Course>();
		
		for (Course course : courses) {
			Course responseItem = new Course();
			responseItem.setCourseId(course.getCourseId());
			responseItem.setCourseTitle(course.getCourseTitle());
			responseItem.setCourseDescription(course.getCourseDescription());
			responseItem.setDepartment(course.getDepartment());
			responseItem.setEnrolledUsers(course.getEnrolledUsers());
			responseItem.setInstructor(course.getInstructor());
			responseItem.setMedias(course.getMedias());
			responseItem.setSubject(course.getSubject());
			
			coursesResponse.add(responseItem);
			
		}
		return new SuccessDataResult<List<Course>>(coursesResponse,"Kurslar Listelendi");
	}

	@Override
	public DataResult<List<Course>> getByDepartment(int id) {
		List<Course> courses = courseRepository.getByDepartment_DeptId(id);
		List<Course> coursesResponse = new ArrayList<Course>();
		
		for (Course course : courses) {
			Course responseItem = new Course();
			responseItem.setCourseId(course.getCourseId());
			responseItem.setCourseTitle(course.getCourseTitle());
			responseItem.setCourseDescription(course.getCourseDescription());
			responseItem.setDepartment(course.getDepartment());
			responseItem.setEnrolledUsers(course.getEnrolledUsers());
			responseItem.setInstructor(course.getInstructor());
			responseItem.setMedias(course.getMedias());
			responseItem.setSubject(course.getSubject());
			
			coursesResponse.add(responseItem);
			
		}
		return new SuccessDataResult<List<Course>>(coursesResponse,"Kurslar Listelendi");
	}

	@Override
	public DataResult<List<Course>> getAllByPage(int pageNo, int pageSize) {
		
		Pageable pageable = Pageable.ofSize(pageSize);
		
		return new SuccessDataResult<List<Course>>
		(this.courseRepository.findAll(pageable).getContent(), "Kurslar Listelendi");
	}

	@Override
	public Result delete(Course course) {
		this.courseRepository.delete(course);
		return new SuccessResult("Kurs Silindi");
		
	}

	@Override
	public DataResult<Course> update(Course course) {
		int id = course.getCourseId();
		Course courseExist = courseRepository.findById(id).get();
		courseExist.setCourseTitle(course.getCourseTitle());
		courseExist.setCourseDescription(course.getCourseDescription());
		courseRepository.save(courseExist);
		
		return new SuccessDataResult<Course>(courseExist, "Kurs Güncellendi");
	}

	@Override
	public DataResult<Course> getByCourseId(int id) {
		Course courseFind = courseRepository.findById(id).get();
			

		return new SuccessDataResult<Course>(courseFind,"Kurslar Listelendi");
	}

	@Override
	public DataResult<Course> getByMediaId(int id) {
		Course course  = courseRepository.getByMedias_MediaId(id);
		Course courseResponse = new Course();
		
		
		courseResponse.setCourseId(course.getCourseId());
		courseResponse.setCourseTitle(course.getCourseTitle());
		courseResponse.setCourseDescription(course.getCourseDescription());
		courseResponse.setDepartment(course.getDepartment());
		courseResponse.setEnrolledUsers(course.getEnrolledUsers());
		courseResponse.setInstructor(course.getInstructor());
		courseResponse.setMedias(course.getMedias());
		courseResponse.setSubject(course.getSubject());
			
		
		return new SuccessDataResult<Course>(courseResponse,"Kurs Listelendi");
	}


}
