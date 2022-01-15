package nvc.bcit.soi5shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import nvc.bcit.soi5shop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    
    public List<Product> findByNameContaining(String name);
    public List<Product> findByPriceLessThanEqual(double price);
}
