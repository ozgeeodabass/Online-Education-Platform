package ceng.gradProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ceng.gradProject.entities.concretes.Media;

public interface MediaRepository extends JpaRepository<Media,Integer>{
	
	List<Media> getAllByTitleContainsIgnoreCase(String title);
	
	List<Media> getByCourse_CourseId(int id);
	
	
	
}
