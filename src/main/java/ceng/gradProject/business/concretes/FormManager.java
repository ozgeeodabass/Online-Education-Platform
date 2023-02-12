package ceng.gradProject.business.concretes;

import org.springframework.stereotype.Service;

import ceng.gradProject.business.abstracts.FormService;
import ceng.gradProject.core.utilities.results.Result;
import ceng.gradProject.core.utilities.results.SuccessResult;
import ceng.gradProject.dataAccess.abstracts.FormRepository;
import ceng.gradProject.entities.concretes.Form;
import ceng.gradProject.entities.concretes.Subject;

@Service
public class FormManager implements FormService {
	
	private FormRepository formRepository;
	
	

	public FormManager(FormRepository formRepository) {
		super();
		this.formRepository = formRepository;
	}



	@Override
	public Result add(Form form) {
		Form formAdded = new Form();
		formAdded.setName(form.getName());
		formAdded.setAbout(form.getAbout());
		formAdded.setEmail(form.getEmail());
		formAdded.setPhone(form.getPhone());
		formAdded.setLast_name(form.getLast_name());
		this.formRepository.save(formAdded);
		
		return new SuccessResult("Form Kaydedildi");
	}

}
