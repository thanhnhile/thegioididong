package fa.trainning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fa.trainning.dto.ManufacturerDTO;
import fa.trainning.service.impl.ManufacturerImpl;

@RestController
public class ManufacturerAPI {
	@Autowired
	private ManufacturerImpl manufacturerImpl;

	@GetMapping(value = "/allmanufacturer")
	public List<ManufacturerDTO> getAllProducts() {
		return manufacturerImpl.getAllManufacturers();
	}

	@GetMapping(value = "/manufacturer/{id}")
	public ManufacturerDTO getManufacturer(@PathVariable Integer id) {
		return manufacturerImpl.getManufacturer(id);
	}

	@PostMapping(value = "/manufacturer")
	public ManufacturerDTO addManufacturer(@RequestBody ManufacturerDTO model) {
		return manufacturerImpl.addManufacturer(model);
	}
}
