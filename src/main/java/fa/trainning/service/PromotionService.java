package fa.trainning.service;

import fa.trainning.dto.PromotionDto;

public interface PromotionService {
	Object getAllPromotion();

	Object getPromotion(Integer id);

	Object addPromotion(PromotionDto promotionDto);

	void deletePromotion(Integer id);

	Object updatePromotion(Integer id, PromotionDto promotionDto);
	
	Object getPromotionByProductId(Integer productId);
}
