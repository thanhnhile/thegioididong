package fa.trainning.specification;

import java.util.ArrayList;
import java.util.List;


import org.springframework.data.jpa.domain.Specification;

import fa.trainning.dto.SearchCriteria;
import fa.trainning.entity.Product;
import fa.trainning.enums.SearchOperation;

public class ProductSpecificationBuilder {
	private List<SearchCriteria> params;

	public ProductSpecificationBuilder() {
		super();
		this.params = new ArrayList<SearchCriteria>();
	}

	public final ProductSpecificationBuilder with(String key, String operation, Object value) {
		params.add(new SearchCriteria(key, value, operation));
		return this;
	}

	public final ProductSpecificationBuilder with(SearchCriteria searchCriteria) {
		params.add(searchCriteria);
		return this;
	}
	public Specification<Product> build(){
        if(params.size() == 0){
            return null;
        }
        SearchCriteria searchCriteria = params.get(0);
        Specification<Product> result;
        String strToSearch = searchCriteria.getValue().toString();
        System.out.println(strToSearch);
        if(strToSearch.contains(",")) {
        	System.out.println("========================TWO VALUES");
			String [] searchValues = strToSearch.split(",");
			result = Specification.where(new ProductSpecification(
					new SearchCriteria(
					searchCriteria.getFilterKey(),
					searchValues[0],
					searchCriteria.getOperation())));
			int i=1;
			while(i<searchValues.length) {
				result = result.or(new ProductSpecification(new SearchCriteria(
						searchCriteria.getFilterKey(), 
						searchValues[i],
						searchCriteria.getOperation())));
				i++;
			}
		}
        else {
        	result = new ProductSpecification(params.get(0));
        }

        for (int idx = 1; idx < params.size(); idx++){
            SearchCriteria criteria = params.get(idx);
            result =  SearchOperation.getDataOption(criteria
                     .getDataOption()) == SearchOperation.ALL
                     ? Specification.where(result).and(new    
                       ProductSpecification(criteria))
                     : Specification.where(result).or(
                       new ProductSpecification(criteria));
        }
        return result;
    }

}
