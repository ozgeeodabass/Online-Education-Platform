package ceng.gradProject.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ceng.gradProject.business.abstracts.UserService;
import ceng.gradProject.core.utilities.results.DataResult;
import ceng.gradProject.core.utilities.results.ErrorResult;
import ceng.gradProject.core.utilities.results.Result;
import ceng.gradProject.core.utilities.results.SuccessDataResult;
import ceng.gradProject.core.utilities.results.SuccessResult;
import ceng.gradProject.dataAccess.abstracts.CourseRepository;
import ceng.gradProject.dataAccess.abstracts.UserRepository;
import ceng.gradProject.entities.concretes.Course;
import ceng.gradProject.entities.concretes.Subject;
import ceng.gradProject.entities.concretes.User;

@Service
public class UserManager implements UserService {
	
	private UserRepository userRepository;
	private CourseRepository courseRepository;

	public UserManager(UserRepository userRepository, CourseRepository courseRepository) {
		super();
		this.userRepository = userRepository;
		this.courseRepository = courseRepository;
	}

	@Override
	public DataResult<User> getByName(String name) {
		User user = userRepository.getByUserNameIgnoreCase(name);
		User userResponse = new User();
	
		userResponse.setUserId(user.getUserId());
		userResponse.setUserName(user.getUserName());
		userResponse.setDepartment(user.getDepartment());
		userResponse.setEnrolledCourses(user.getEnrolledCourses());
		userResponse.setPassword(user.getPassword());
		
			

		return new SuccessDataResult<User>(userResponse,"Kullanıcılar Listelendi");
	}

	@Override
	public DataResult<List<User>> getAll() {
		List<User> users = userRepository.findAll();
		List<User> usersResponse = new ArrayList<User>();
		
		for (User user : users) {
			User responseItem = new User();
			responseItem.setUserId(user.getUserId());
			responseItem.setUserName(user.getUserName());
			responseItem.setDepartment(user.getDepartment());
			responseItem.setEnrolledCourses(user.getEnrolledCourses());
			responseItem.setPassword(user.getPassword());
			
			usersResponse.add(responseItem);
			
		}
		return new SuccessDataResult<List<User>>(usersResponse,"Kullanıcılar Listelendi");
	}

	@Override
	public Result add(User user) {
		User usert = new User();
		usert.setUserName(user.getUserName());
		usert.setPassword(user.getPassword());
		usert.setDepartment(user.getDepartment());
		this.userRepository.save(usert);
		return new SuccessResult("Kullanıcı Eklendi");
		
	}

	@Override
	public Result delete(User user) {
		this.userRepository.delete(user);
		return new SuccessResult("Kullanıcı Silindi");
	}

	@Override
	public DataResult<List<User>> getByDepartment(int id) {
		List<User> users = userRepository.getByDepartment_DeptId(id);
		List<User> usersResponse = new ArrayList<User>();
		
		for (User user : users) {
			User responseItem = new User();
			responseItem.setUserId(user.getUserId());
			responseItem.setUserName(user.getUserName());
			responseItem.setDepartment(user.getDepartment());
			responseItem.setEnrolledCourses(user.getEnrolledCourses());
			responseItem.setPassword(user.getPassword());
			
			usersResponse.add(responseItem);
			
		}
		return new SuccessDataResult<List<User>>(usersResponse,"Kullanıcılar Listelendi");
	}

	@Override
	public DataResult<User> update(User user) {
		int id = user.getUserId();
		User userExist = userRepository.findById(id).get();
		userExist.setUserName(user.getUserName());
		userExist.setDepartment(user.getDepartment());
		userRepository.save(userExist);
		
		return new SuccessDataResult<User>(userExist, "Kullanıcı Güncellendi");
		}

	@Override
	public DataResult<User> getByUserId(int id) {
		User userFind= userRepository.findById(id).get();
		
		return new SuccessDataResult<User>(userFind, "Kullanıcı Listelendi");
	}

	@Override
	public DataResult<List<Course>> getAllEnrolledCoursesByUserId(int id) {
		List<Course> courses = new ArrayList<Course>();
		User user = userRepository.findById(id).get();
		
		courses=user.getEnrolledCourses();
		
		return new SuccessDataResult<List<Course>>(courses, "Kullanıcının Kursları Listelendi");
		
		
	}

	@Override
	public DataResult<List<Course>> addToEnrolledCourses(int userId, int courseId) {
		User user = userRepository.findById(userId).get();
		List<Course> userCourses = user.getEnrolledCourses();
		Course courseAdded = courseRepository.findById(courseId).get();
		userCourses.add(courseAdded);
		user.getEnrolledCourses().add(courseAdded);
		userRepository.save(user);
		
		
		return new SuccessDataResult<List<Course>>(user.getEnrolledCourses(), "Kurs Kaydı Gerçekleştirildi");
	}

	@Override
	public Result login(String name, String password) {
		User user = userRepository.getByUserNameIgnoreCase(name);
		if(user.getUserName()==name&&user.getPassword()==(password)) {
			return new SuccessResult("Login olundu");
		}else {
			return new ErrorResult("Bilgilerinizi Kontrol Edin");
		}
		
	}
		
	}


