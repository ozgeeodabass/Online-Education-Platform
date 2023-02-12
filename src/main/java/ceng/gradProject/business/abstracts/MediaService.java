package ceng.gradProject.business.abstracts;

import java.util.List;

import ceng.gradProject.core.utilities.results.DataResult;
import ceng.gradProject.core.utilities.results.Result;
import ceng.gradProject.entities.concretes.Media;

public interface MediaService {

	DataResult<List<Media>> getAll();
	Result add(Media media);
	Result delete(Media media);
	DataResult<List<Media>> getByCourseId(int id);
	DataResult<Media> update(Media media);
	DataResult<List<Media>> getAllByTitleContainsIgnoreCase(String title);

}
