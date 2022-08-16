package fa.trainning.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.trainning.dto.ProductsPromotionsDto;
import fa.trainning.repository.ProductRepository;
import fa.trainning.repository.ProductsPromotionsRepository;
import fa.trainning.repository.PromotionRepository;
import fa.trainning.service.ProductsPromotionsService;

@Service
public class ProductsPromotionsServiceImpl implements ProductsPromotionsService {
	@Autowired
	private ProductsPromotionsRepository repo;

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private PromotionRepository promotionRepo;

	@Override
	public Object addProductToPromotion(ProductsPromotionsDto productsPromotionsDto) {
		Integer productId = productsPromotionsDto.getProduct();
		Integer promotionId = productsPromotionsDto.getPromotion();
		if (productRepo.findById(productId).isPresent() && promotionRepo.findById(promotionId).isPresent()) {
			repo.insertIntoProductsPromotions(productId, promotionId);
			return productsPromotionsDto;
		}
		return null;
	}

}
