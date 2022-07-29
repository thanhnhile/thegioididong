package fa.trainning.service;

import java.util.List;

import fa.trainning.entity.Category;

public interface CategoryService {
	List<Category> getAllCategorys();
	Category getCategory(Integer id);
}
