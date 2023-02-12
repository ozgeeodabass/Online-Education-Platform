package ceng.gradProject.webApi.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ceng.gradProject.business.abstracts.MediaService;
import ceng.gradProject.core.utilities.results.DataResult;
import ceng.gradProject.core.utilities.results.Result;
import ceng.gradProject.entities.concretes.Media;

@RestController
@RequestMapping("/api/medias")
@CrossOrigin
public class MediasController {
	
	private MediaService mediaService;

	@Autowired
	public MediasController(MediaService mediaService) {
		super();
		this.mediaService = mediaService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Media>> getAll() {
		return this.mediaService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(Media media) {
		return this.mediaService.add(media);
	}
	
	@DeleteMapping("/delete")
	public Result delete(Media media) {
		return this.mediaService.delete(media);
	}
	
	@GetMapping("/getByCourse")
	public DataResult<List<Media>> getByCourseId(int id) {
		return this.mediaService.getByCourseId(id);
	}
	
	@PostMapping("/update")
	public DataResult<Media> update(Media media) {
		return this.mediaService.update(media);
	}
	
	@GetMapping("/getAllByTitleContains")
	public DataResult<List<Media>> getAllByTitleContainsIgnoreCase(String title) {
		return this.mediaService.getAllByTitleContainsIgnoreCase(title);
	}

	
}
