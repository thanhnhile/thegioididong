package fa.trainning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fa.trainning.dto.DataResponse;
import fa.trainning.dto.ProductsPromotionsDto;
import fa.trainning.service.impl.ProductsPromotionsServiceImpl;

@RestController
@RequestMapping("/productsPromotions")
public class ProductsPromotionsController {
	@Autowired
	private ProductsPromotionsServiceImpl productsPromotionsServiceImpl;
	
	@PostMapping
	public DataResponse addProductToStore(@RequestBody ProductsPromotionsDto productsPromotionsDto) {
		return new DataResponse(productsPromotionsServiceImpl.addProductToPromotion(productsPromotionsDto));
		
	}
}
