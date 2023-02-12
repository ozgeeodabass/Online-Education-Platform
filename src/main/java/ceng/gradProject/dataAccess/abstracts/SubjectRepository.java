package ceng.gradProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ceng.gradProject.entities.concretes.Subject;


public interface SubjectRepository extends JpaRepository<Subject,Integer> {
	
	List<Subject> getBySubjectNameIgnoreCase(String name);
}
