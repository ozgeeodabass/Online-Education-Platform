package ceng.gradProject.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ceng.gradProject.business.abstracts.DepartmentService;
import ceng.gradProject.core.utilities.results.DataResult;
import ceng.gradProject.core.utilities.results.Result;
import ceng.gradProject.core.utilities.results.SuccessDataResult;
import ceng.gradProject.core.utilities.results.SuccessResult;
import ceng.gradProject.dataAccess.abstracts.DepartmentRepository;
import ceng.gradProject.entities.concretes.Department;

@Service
public class DepartmentManager implements DepartmentService {
	
	private DepartmentRepository departmentRepository;
	
	
	public DepartmentManager(DepartmentRepository departmentRepository) {
		super();
		this.departmentRepository = departmentRepository;
	}

	@Override
	public DataResult<Department> getByDeptName(String name) {
		Department dept = departmentRepository.getByDeptNameIgnoreCase(name);
		Department deptResponse = new Department();
	
			deptResponse.setDeptId(dept.getDeptId());
			deptResponse.setDeptName(dept.getDeptName());
			deptResponse.setInstructors(dept.getInstructors());
			deptResponse.setCourses(dept.getCourses());
			deptResponse.setUsers(dept.getUsers());
			

		return new SuccessDataResult<Department>(deptResponse,"Departmanlar Listelendi");
	}

	@Override
	public DataResult<List<Department>> getAll() {

		List<Department> departments = departmentRepository.findAll();
		List<Department> departmentsResponse = new ArrayList<Department>();
		
		for (Department dept : departments) {
			Department responseItem = new Department();
			responseItem.setDeptId(dept.getDeptId());
			responseItem.setDeptName(dept.getDeptName());
			responseItem.setInstructors(dept.getInstructors());
			responseItem.setCourses(dept.getCourses());
			responseItem.setUsers(dept.getUsers());
			
			departmentsResponse.add(responseItem);
			
		}
		return new SuccessDataResult<List<Department>>(departmentsResponse,"Departmanlar Listelendi");
	}

	@Override
	public Result add(Department department) {
		department.setDeptName(department.getDeptName());
		
		this.departmentRepository.save(department);
		return new SuccessResult("Departman Eklendi");
	}

	@Override
	public Result delete(Department department) {
		this.departmentRepository.delete(department);
		return new SuccessResult("Departman Silindi");
	}

	@Override
	public DataResult<Department> update(Department department) {
		int id = department.getDeptId();
		Department departmentExist = departmentRepository.findById(id).get();
		departmentExist.setDeptName(department.getDeptName());
		departmentRepository.save(departmentExist);
		
		return new SuccessDataResult<Department>(departmentExist, "Departman Güncellendi");
	}

	@Override
	public DataResult<Department> getByDeptId(int id) {
		Department deptFind = departmentRepository.findById(id).get();
		

		return new SuccessDataResult<Department>(deptFind,"Departman Listelendi");
	}
	}


