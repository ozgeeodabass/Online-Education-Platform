package ceng.gradProject.business.abstracts;

import java.util.List;
import ceng.gradProject.core.utilities.results.DataResult;
import ceng.gradProject.core.utilities.results.Result;
import ceng.gradProject.entities.concretes.Subject;

public interface SubjectService {
	
	DataResult<List<Subject>> getAll();
	//List<GetAllSubjectsResponse> getAll();
	
	Result add(Subject subject);
	Result delete(Subject subject);
	DataResult<Subject> getBySubjectId(int id);
	DataResult<Subject> update(Subject subject);
}
