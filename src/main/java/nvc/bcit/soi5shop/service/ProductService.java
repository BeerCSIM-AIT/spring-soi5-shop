package nvc.bcit.soi5shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import nvc.bcit.soi5shop.model.Product;
import nvc.bcit.soi5shop.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll(Sort.by("id").ascending());
    }

    public List<Product> findByName(String name){
        return productRepository.findByNameContaining(name);
    }

    public List<Product> findByPriceLimit(double price){
        return productRepository.findByPriceLessThanEqual(price);
    }

    public Product getOne(Integer id){
        return productRepository.getById(id);
    }

    public Product save (Product product){
        return productRepository.save(product);
    }

    public void delete (Product product){
        productRepository.delete(product);
    }
}
