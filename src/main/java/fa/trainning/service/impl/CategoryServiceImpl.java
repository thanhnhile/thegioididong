package fa.trainning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.trainning.entity.Category;
import fa.trainning.repository.CategoryRepository;
import fa.trainning.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryRepository categoryRepo;

	@Override
	public List<Category> getAllCategorys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category getCategory(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
