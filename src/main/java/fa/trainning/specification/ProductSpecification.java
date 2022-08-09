package fa.trainning.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import fa.trainning.dto.SearchCriteria;
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
		String strToSearch = searchCriteria.getValue().toString().toLowerCase();
		switch (SearchOperation.getSimpleOperation(searchCriteria.getOperation())) {
		case CONTAINS:
            return cb.like(cb.lower(root
                     .get(searchCriteria.getFilterKey())), 
                     "%" + strToSearch + "%");
		case EQUAL:
			return cb.equal(cb.lower(root.get(searchCriteria.getFilterKey())), strToSearch);
		case GREATER_THAN:
			return cb.greaterThan(root.get(searchCriteria.getFilterKey()), strToSearch);
		case GREATER_THAN_EQUAL:
			return cb.greaterThanOrEqualTo(root.get(searchCriteria.getFilterKey()), strToSearch);
		case LESS_THAN:
			return cb.lessThan(root.get(searchCriteria.getFilterKey()), strToSearch);
		case LESS_THAN_EQUAL:
			return cb.lessThanOrEqualTo(root.get(searchCriteria.getFilterKey()), strToSearch);
//		case NOT_EQUAL:
//			break;
//		case NOT_NULL:
//			break;
//		case NUL:
//			break;
		default:
			break;

		}
		throw new RuntimeException("Operation not supported yet");
	}

}
