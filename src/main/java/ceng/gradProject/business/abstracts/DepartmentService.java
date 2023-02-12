package ceng.gradProject.business.abstracts;


import java.util.List;

import ceng.gradProject.core.utilities.results.DataResult;
import ceng.gradProject.core.utilities.results.Result;
import ceng.gradProject.entities.concretes.Department;

public interface DepartmentService {

	DataResult<Department> getByDeptName(String name);
	DataResult<List<Department>> getAll();
	Result add(Department department);
	Result delete(Department department);
	DataResult<Department> getByDeptId(int id);
	DataResult<Department> update(Department department);
	
}
