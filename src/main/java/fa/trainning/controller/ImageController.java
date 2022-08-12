package fa.trainning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fa.trainning.dto.DataResponse;
import fa.trainning.dto.ImageDto;
import fa.trainning.service.impl.ImageServiceImpl;

@RestController
@RequestMapping("/images")
public class  ImageController {
	@Autowired
	private ImageServiceImpl imageImpl;

	@GetMapping()
	public DataResponse getAllImage() {
		return new DataResponse(imageImpl.getAllImage());
	}

	@GetMapping("/{offSet}/{pageSize}")
	public List<ImageDto> getAllImage(@PathVariable int offSet, @PathVariable int pageSize) {
		return imageImpl.getAllImagePagnation(offSet, pageSize);
	}

	@GetMapping("/{image_id}")
	public ImageDto getCategory(@PathVariable(value = "image_id") Integer image_id) {
		return imageImpl.getImage(image_id);
	}

	@PostMapping()
	public void addImage(@RequestBody ImageDto imageDto) {
		imageImpl.addImage(imageDto);
	}

	@DeleteMapping("/{image_id}")
	public void deleteImage(@PathVariable(value = "image_id") Integer image_id) {
		imageImpl.deleteImage(image_id);
	}

	@PutMapping("/{image_id}")
	public void updateImage(@PathVariable(value = "image_id") Integer image_id, @RequestBody ImageDto imageDto) {
		imageImpl.updateImage(image_id, imageDto);
	}
}
