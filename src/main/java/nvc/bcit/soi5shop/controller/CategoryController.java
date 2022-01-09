package nvc.bcit.soi5shop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import nvc.bcit.soi5shop.model.Category;
import nvc.bcit.soi5shop.repository.CategoryRepository;

@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/category")
    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Optional<Category> findCategoryById(int id){
        return categoryRepository.findById(id);
    }
}
