package ceng.gradProject.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;
import ceng.gradProject.entities.concretes.Department;

public interface DepartmentRepository  extends JpaRepository<Department, Integer>  {

	Department getByDeptNameIgnoreCase(String name);
	
}
