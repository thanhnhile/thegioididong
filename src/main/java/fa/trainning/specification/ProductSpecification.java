package fa.trainning.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import fa.trainning.dto.SearchCriteria;
import fa.trainning.entity.Category;
import fa.trainning.entity.Manufacturer;
import fa.trainning.entity.Product;
import fa.trainning.enums.SearchOperation;

public class ProductSpecification implements Specification<Product> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private final SearchCriteria searchCriteria;

	public ProductSpecification(SearchCriteria searchCriteria) {
		super();
		this.searchCriteria = searchCriteria;
	}

	@Override
	public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		String strToSearch = searchCriteria.getValue().toString();
		System.out.println(strToSearch);
		switch (SearchOperation.getSimpleOperation(searchCriteria.getOperation())) {
		case CONTAINS:
            return cb.like(cb.lower(root
                     .get(searchCriteria.getFilterKey())).as(String.class), 
                     "%" + strToSearch + "%");
		case EQUAL:
			if(searchCriteria.getFilterKey().equals("category")) {
				return cb.equal(cb.lower(categoryJoin(root).get(searchCriteria.getFilterKey())).as(String.class), strToSearch);
			}else if(searchCriteria.getFilterKey().equals("manufacturer")){
				return cb.equal(cb.lower(manufacturerJoin(root).get(searchCriteria.getFilterKey())).as(String.class), strToSearch);
			}
			
			else return cb.equal(cb.lower(root.get(searchCriteria.getFilterKey())),strToSearch);
		case GREATER_THAN:
			return cb.greaterThan(root.get(searchCriteria.getFilterKey()), strToSearch);
		case GREATER_THAN_EQUAL:
			return cb.greaterThanOrEqualTo(root.get(searchCriteria.getFilterKey()),strToSearch);
		case LESS_THAN:
			return cb.lessThan(root.get(searchCriteria.getFilterKey()), strToSearch);
		case LESS_THAN_EQUAL:
			return cb.lessThanOrEqualTo(root.get(searchCriteria.getFilterKey()), strToSearch);
		default:
			break;

		}
		throw new RuntimeException("Operation not supported yet");
	}
	private Join<Product, Category> categoryJoin(Root<Product> root){
		return root.join("category");
	}
	
	private Join<Product, Manufacturer> manufacturerJoin(Root<Product> root){
		return root.join("manufacturer");
	}

}
