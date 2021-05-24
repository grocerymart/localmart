package local.core.mart.controllers;

import java.io.IOException;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import local.core.mart.entities.Product;
import local.core.mart.services.ProductsService;

@RestController
@RequestMapping(value = "/app", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductsController {
	
	@Autowired
	ProductsService ps;

	
	 @RequestMapping(value = "/products", method = RequestMethod.GET)
	    List<Product> getProducts() throws IOException {
			return ps.getProductsList();
	    }
	 
	 @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	    Product getProducts(@PathParam(value = "id") String id) throws IOException {
			return ps.getProduct(id);
	    }
	 
	 @RequestMapping(value = "/products", method = RequestMethod.POST )
	    Product createProducts(@RequestBody Product product) throws IOException {
	     return ps.addProduct(product);
	     
	    }

}
