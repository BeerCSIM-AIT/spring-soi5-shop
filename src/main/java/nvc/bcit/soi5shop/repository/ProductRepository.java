package nvc.bcit.soi5shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nvc.bcit.soi5shop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    

}
