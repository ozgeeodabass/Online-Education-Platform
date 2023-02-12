package ceng.gradProject.business.abstracts;

import java.util.List;

import ceng.gradProject.core.utilities.results.DataResult;
import ceng.gradProject.core.utilities.results.Result;
import ceng.gradProject.entities.concretes.Course;
import ceng.gradProject.entities.concretes.Instructor;

public interface InstructorService {

	DataResult<Instructor> getByName(String fName, String lName);
	DataResult<List<Instructor>> getAll();
	Result add(Instructor instr);
	Result delete(Instructor instr);
	DataResult<List<Instructor>> getByDepartment(int id);
	DataResult<Instructor> update(Instructor instr);
	DataResult<Instructor> getByInstrId(int id);
	DataResult<List<Course>> getAllCoursesByInstrId(int id);
	DataResult<String> getAboutInstr(int id);
}
