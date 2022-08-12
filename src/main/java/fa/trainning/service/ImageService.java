package fa.trainning.service;

import java.util.List;

import fa.trainning.dto.ImageDto;

public interface ImageService {
	List<ImageDto> getAllImage();

	List<ImageDto> getAllImagePagnation(int offSet, int pageSize);

	ImageDto getImage(Integer id);

	void addImage(ImageDto imageDto);

	void deleteImage(Integer id);

	ImageDto updateImage(Integer id, ImageDto imageDto);
}
