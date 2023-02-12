package ceng.gradProject.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ceng.gradProject.business.abstracts.InstructorService;
import ceng.gradProject.core.utilities.results.DataResult;
import ceng.gradProject.core.utilities.results.Result;
import ceng.gradProject.core.utilities.results.SuccessDataResult;
import ceng.gradProject.core.utilities.results.SuccessResult;
import ceng.gradProject.dataAccess.abstracts.InstructorRepository;
import ceng.gradProject.entities.concretes.Course;
import ceng.gradProject.entities.concretes.Instructor;

@Service
public class InstructorManager implements InstructorService {
	
	private InstructorRepository instructorRepository;

	public InstructorManager(InstructorRepository instructorRepository) {
		super();
		this.instructorRepository = instructorRepository;
	}

	@Override
	public DataResult<Instructor> getByName(String fName, String lName) {
		Instructor instr = instructorRepository.getByName(fName, lName);
		Instructor instrResponse = new Instructor();
	
		instrResponse.setInstrId(instr.getInstrId());
		instrResponse.setInstrFirstName(instr.getInstrFirstName());
		instrResponse.setInstrLastName(instr.getInstrLastName());
		instrResponse.setCourses(instr.getCourses());
		instrResponse.setDepartment(instr.getDepartment());
		instrResponse.setPassword(instr.getPassword());
			

		return new SuccessDataResult<Instructor>(instrResponse,"Eğitmen Listelendi");
	}

	@Override
	public DataResult<List<Instructor>> getAll() {
		List<Instructor> intrs = instructorRepository.findAll();
		List<Instructor> intrsResponse = new ArrayList<Instructor>();
		
		for (Instructor instr : intrs) {
			Instructor responseItem = new Instructor();

			responseItem.setInstrId(instr.getInstrId());
			responseItem.setInstrFirstName(instr.getInstrFirstName());
			responseItem.setInstrLastName(instr.getInstrLastName());
			responseItem.setCourses(instr.getCourses());
			responseItem.setDepartment(instr.getDepartment());
			responseItem.setPassword(instr.getPassword());
			
			
			intrsResponse.add(responseItem);
			
		}
		return new SuccessDataResult<List<Instructor>>(intrsResponse,"Eğitmenler Listelendi");
	}

	@Override
	public Result add(Instructor instr) {
		instr.setInstrFirstName(instr.getInstrFirstName());
		instr.setInstrLastName(instr.getInstrLastName());
		
		this.instructorRepository.save(instr);
		return new SuccessResult("Eğitmen Eklendi");
	}

	@Override
	public Result delete(Instructor instr) {
		this.instructorRepository.delete(instr);
		return new SuccessResult("Eğitmen Silindi");
	}

	@Override
	public DataResult<List<Instructor>> getByDepartment(int id) {
		List<Instructor> intrs = instructorRepository.getByDepartment_DeptId(id);
		List<Instructor> intrsResponse = new ArrayList<Instructor>();
		
		for (Instructor instr : intrs) {
			Instructor responseItem = new Instructor();
			responseItem.setInstrId(instr.getInstrId());
			responseItem.setInstrFirstName(instr.getInstrFirstName());
			responseItem.setInstrLastName(instr.getInstrLastName());
			responseItem.setCourses(instr.getCourses());
			responseItem.setDepartment(instr.getDepartment());
			responseItem.setPassword(instr.getPassword());
			
			intrsResponse.add(responseItem);
			
		}
		return new SuccessDataResult<List<Instructor>>(intrsResponse,"Eğitmenler Listelendi");
	}

	@Override
	public DataResult<Instructor> update(Instructor instr) {
		int id = instr.getInstrId();
		Instructor instrExist = instructorRepository.findById(id).get();
		instrExist.setInstrFirstName(instr.getInstrFirstName());
		instrExist.setInstrLastName(instr.getInstrLastName());
		instrExist.setDepartment(instr.getDepartment());
		instructorRepository.save(instrExist);
		
		return new SuccessDataResult<Instructor>(instrExist, "Eğitmen Güncellendi");
	}

	@Override
	public DataResult<Instructor> getByInstrId(int id) {
		Instructor instrFind = instructorRepository.findById(id).get();
		
		return new SuccessDataResult<Instructor>(instrFind, "Eğitmen Listelendi");
		
	}

	@Override
	public DataResult<List<Course>> getAllCoursesByInstrId(int id) {
		List<Course> courses = new ArrayList<Course>();
		Instructor instr = instructorRepository.findById(id).get();
		
		courses=instr.getCourses();
		
		return new SuccessDataResult<List<Course>>(courses, "Eğitmenin Kursları Listelendi");
	}

	@Override
	public DataResult<String> getAboutInstr(int id) {
		Instructor instr = instructorRepository.getById(id);
		String aboutInstr = instr.getAboutInstr();
		
		return new SuccessDataResult<String>(aboutInstr, "Eğitmen Bilgisi listelendi");
	}

}