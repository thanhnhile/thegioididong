package fa.trainning.mapstruct;

import java.util.List;

import org.mapstruct.Mapper;

import fa.trainning.dto.ImageDto;
import fa.trainning.entity.Image;

@Mapper(componentModel = "spring")
public interface ImageMapper {
	// ----------------------------Entity To DTO---------------------------
	ImageDto imageToImageDto(Image image);

	List<ImageDto> imagesToImageDtos(List<Image> images);

	
	// ---------------------------DTO To Entity----------------------
	Image imageDtoToImage(ImageDto imageDto);

}
