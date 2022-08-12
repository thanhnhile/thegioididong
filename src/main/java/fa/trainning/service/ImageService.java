package fa.trainning.service;

import java.util.List;

import fa.trainning.dto.ImageDto;

public interface ImageService {
	Object getAllImage();

	Object getAllImagePagnation(int offSet, int pageSize);

	Object getImage(Integer id);

	Object addImage(ImageDto imageDto);

	void deleteImage(Integer id);

	Object updateImage(Integer id, ImageDto imageDto);
}
