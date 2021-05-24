package local.core.mart.repos;

import org.springframework.data.repository.CrudRepository;

import local.core.mart.entities.Product;

public interface ProductRepo extends CrudRepository<Product, String>  {

}
