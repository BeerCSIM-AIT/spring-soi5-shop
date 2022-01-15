package nvc.bcit.soi5shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nvc.bcit.soi5shop.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
}
