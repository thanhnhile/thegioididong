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
import fa.trainning.dto.PagingDto;
import fa.trainning.dto.StoreDto;
import fa.trainning.service.impl.StoreServiceImpl;

@RestController
@RequestMapping("/stores")
public class StoreController {
	@Autowired
	private StoreServiceImpl storeImpl;

	@GetMapping()
	public List<StoreDto> getAllStore() {
		return storeImpl.getAllStore();
	}

	@GetMapping("/{offset}/{pageSize}")
	public PagingDto getAllStore(@PathVariable(value = "offset") int offSet,
			@PathVariable(value = "pageSize") int pageSize) {
		return storeImpl.getAllStorePagnation(offSet, pageSize);
	}

	@GetMapping("/{store_id}")
	public StoreDto getStore(@PathVariable(value = "store_id") Integer store_id) {
		return storeImpl.getStore(store_id);
	}

	@PostMapping()
	public DataResponse addStore(@RequestBody StoreDto storeDto) {
		return new DataResponse(storeImpl.addStore(storeDto));
	}

	@DeleteMapping("/{store_id}")
	public void deleteStore(@PathVariable(value = "store_id") Integer store_id) {
		storeImpl.deleteStore(store_id);
	}

	@PutMapping("/{store_id}")
	public void updateStore(@PathVariable(value = "store_id") Integer store_id, @RequestBody StoreDto storeDto) {
		storeImpl.updateStore(store_id, storeDto);
	}

	@PutMapping("/property/{store_id}")
	public void updatePropertyStore(@PathVariable(value = "store_id") Integer store_id,
			@RequestBody StoreDto storeDto) {
		storeImpl.updatePropertyStore(store_id, storeDto);
	}
}
