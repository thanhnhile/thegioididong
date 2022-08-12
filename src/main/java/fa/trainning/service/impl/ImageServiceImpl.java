package fa.trainning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fa.trainning.dto.ImageDto;
import fa.trainning.entity.Image;
import fa.trainning.mapstruct.ImageMapper;
import fa.trainning.repository.ImageRepository;
import fa.trainning.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageRepository imageRepo;
	@Autowired
	private ImageMapper imageMapper;

	@Autowired
	public ImageServiceImpl(ImageMapper imageMapper, ImageRepository imageRepo) {
		this.imageMapper = imageMapper;
		this.imageRepo = imageRepo;
	}

	@Override
	public List<ImageDto> getAllImagePagnation(int offSet,int pageSize) {
		Page<Image> page=  imageRepo.findAll(PageRequest.of(offSet, pageSize));
		return imageMapper.imagesToImageDtos(page.getContent());
	}

	@Override
	public List<ImageDto> getAllImage() {
		return imageMapper.imagesToImageDtos(imageRepo.findAll());
	}
	
	@Override
	public ImageDto getImage(Integer id) {
		return imageMapper.imageToImageDto(imageRepo.findOneById(id));
	}

	@Override
	public void addImage(ImageDto imageDto) {
		imageRepo.save(imageMapper.imageDtoToImage(imageDto));
	}

	@Override
	public void deleteImage(Integer id) {
		imageRepo.delete(imageRepo.findOneById(id));
	}

	@Override
	public ImageDto updateImage(Integer id, ImageDto imageDto) {
		Image ImageNew = imageMapper.imageDtoToImage(imageDto);
		Image ImageOld = imageRepo.findOneById(id);
		ImageOld.setUrl(ImageNew.getUrl());
		imageRepo.save(ImageOld);
		return imageMapper.imageToImageDto(ImageOld);
	}

}
