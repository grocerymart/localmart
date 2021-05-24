package local.core.mart.services;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import local.core.mart.entities.Product;
import local.core.mart.repos.ProductRepo;

@Service
public class ProductsService {
	@Autowired
	ProductRepo pRepo;
	
	public Product addProduct(Product product) {
		product = pRepo.save(product);
		return product;
	}
	
	public Product getProduct(String id) {
		Optional<Product> opt = pRepo.findById(id);
		if(opt.isEmpty()) {
			return new Product();
		}
		else {
			return opt.get();
		}
	}
	
	public List<Product> getProductsList() {
		List<Product> products= new LinkedList<Product>();
		pRepo.findAll().forEach(products::add );
		return products;
		
	}
	

}
