package ceng.gradProject.business.abstracts;

import ceng.gradProject.core.utilities.results.Result;
import ceng.gradProject.entities.concretes.Course;
import ceng.gradProject.entities.concretes.Form;

public interface FormService {
	
	Result add(Form form);

}
