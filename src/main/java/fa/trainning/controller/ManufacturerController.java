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

import fa.trainning.dto.ManufacturerDto;
import fa.trainning.service.impl.ManufacturerImpl;



@RestController
@RequestMapping("/manufacturer")
public class ManufacturerController {

	@Autowired
	private ManufacturerImpl manufacturerImpl;

	@GetMapping()
	public List<ManufacturerDto> getAllCategory() {
		return manufacturerImpl.getAllManufacturer();
	}

	@GetMapping("/{manufacturer_id}")
	public ManufacturerDto getCategory(@PathVariable(value = "manufacturer_id") Integer manufacturer_id) {
		return manufacturerImpl.getManufacturer(manufacturer_id);
	}

	@PostMapping()
	public void addCategory(@RequestBody ManufacturerDto manufacturerDto) {
		manufacturerImpl.addManufacturer(manufacturerDto);
	}

	@DeleteMapping("/{manufacturer_id}")
	public void deleteCategory(@PathVariable(value = "manufacturer_id") Integer manufacturer_id) {
		manufacturerImpl.deleteManufacturer(manufacturer_id);
	}

	@PutMapping("/{manufacturer_id}")
	public void updateCategory(@PathVariable(value = "manufacturer_id") Integer manufacturer_id, @RequestBody ManufacturerDto manufacturerDto ) {
		manufacturerImpl.updateManufacturer(manufacturer_id, manufacturerDto);
	}
}
