package fa.trainning.mapstruct;

import java.util.List;

import org.mapstruct.Mapper;

import fa.trainning.dto.PromotionDto;
import fa.trainning.entity.Promotion;

@Mapper(componentModel = "spring")
public interface PromotionMapper {
	// ----------------------------Entity To DTO---------------------------

	PromotionDto promotionToPromotionDto(Promotion promotion);

	List<PromotionDto> promotionsToPromotionDtos(List<Promotion> promotions);

	// ---------------------------DTO To Entity----------------------

	// Promotion
	Promotion promotionDtoToPromotion(PromotionDto promotionDto);
}
