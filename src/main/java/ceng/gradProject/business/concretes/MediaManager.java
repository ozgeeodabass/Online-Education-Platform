package ceng.gradProject.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ceng.gradProject.business.abstracts.MediaService;
import ceng.gradProject.core.utilities.results.DataResult;
import ceng.gradProject.core.utilities.results.Result;
import ceng.gradProject.core.utilities.results.SuccessDataResult;
import ceng.gradProject.core.utilities.results.SuccessResult;
import ceng.gradProject.dataAccess.abstracts.MediaRepository;
import ceng.gradProject.entities.concretes.Media;

@Service
public class MediaManager implements MediaService {
	
	private MediaRepository mediaRepository;
	

	public MediaManager(MediaRepository mediaRepository) {
		super();
		this.mediaRepository = mediaRepository;
	}

	

	@Override
	public DataResult<List<Media>> getAll() {
		List<Media> medias = mediaRepository.findAll();
		List<Media> mediasResponse = new ArrayList<Media>();
		
		for (Media media : medias) {
			Media responseItem = new Media();
			responseItem.setMediaId(media.getMediaId());
			responseItem.setTitle(media.getTitle());
			responseItem.setFilePath(media.getFilePath());
			responseItem.setCourse(media.getCourse());
			
			mediasResponse.add(responseItem);
			
		}
		return new SuccessDataResult<List<Media>>(mediasResponse,"Medyalar Listelendi");
	}

	@Override
	public Result add(Media media) {
		media.setTitle(media.getTitle());
		media.setFilePath(media.getFilePath());
		media.setMediaId(media.getMediaId());
		media.setCourse(media.getCourse());
		
		this.mediaRepository.save(media);
		return new SuccessResult("Medya Eklendi");
	}

	@Override
	public Result delete(Media media) {
		this.mediaRepository.delete(media);
		return new SuccessResult("Medya Silindi");
	}

	@Override
	public DataResult<List<Media>> getByCourseId(int id) {
		List<Media> medias = mediaRepository.getByCourse_CourseId(id);
		List<Media> mediasResponse = new ArrayList<Media>();
		
		for (Media media : medias) {
			Media responseItem = new Media();
			responseItem.setMediaId(media.getMediaId());
			responseItem.setTitle(media.getTitle());
			responseItem.setFilePath(media.getFilePath());
			responseItem.setCourse(media.getCourse());
			
			mediasResponse.add(responseItem);
			
		}
		return new SuccessDataResult<List<Media>>(mediasResponse,"Medyalar Listelendi");
	}

	@Override
	public DataResult<Media> update(Media media) {
		int id = media.getMediaId();
		Media mediaExist = mediaRepository.findById(id).get();
		mediaExist.setTitle(media.getTitle());
		mediaExist.setFilePath(media.getFilePath());
		mediaRepository.save(mediaExist);
		
		return new SuccessDataResult<Media>(mediaExist, "Medya Güncellendi");
	}

	@Override
	public DataResult<List<Media>> getAllByTitleContainsIgnoreCase(String title) {
		List<Media> medias = mediaRepository.getAllByTitleContainsIgnoreCase(title);
		List<Media> mediasResponse = new ArrayList<Media>();
		
		for (Media media : medias) {
			Media responseItem = new Media();
			responseItem.setMediaId(media.getMediaId());
			responseItem.setTitle(media.getTitle());
			responseItem.setFilePath(media.getFilePath());
			responseItem.setCourse(media.getCourse());
			
			mediasResponse.add(responseItem);
			
		}
		return new SuccessDataResult<List<Media>>(mediasResponse,"Medyalar Listelendi");
	}



}
