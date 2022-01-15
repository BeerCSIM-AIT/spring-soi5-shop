package nvc.bcit.soi5shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import nvc.bcit.soi5shop.model.Category;
import nvc.bcit.soi5shop.model.Product;
import nvc.bcit.soi5shop.repository.CategoryRepository;
import nvc.bcit.soi5shop.service.ProductService;

import javax.validation.Valid;



@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryRepository categoryRepository;
    
    @GetMapping("/all")
    public List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable("id") Integer id){
        return productService.getOne(id);
    }

    @GetMapping("/new")
    public String newProduct(ModelMap modelMap){
        Product product = new Product();
        modelMap.addAttribute("product",product);
        return "newproduct";
    }

    @GetMapping(value="/name/{name}")
    public ModelAndView getProductsByName(@PathVariable("name") String name) {
        List<Product> products = productService.findByName(name);
        return new ModelAndView("product","products", products);
    }

    @GetMapping(value="/price/{price}")
    public ModelAndView getProductsByName(@PathVariable("price") double price) {
        List<Product> products = productService.findByPriceLimit(price);
        return new ModelAndView("product","products", products);
    }
    

    @PostMapping("/add")
    public String saveProduct(@Valid Product product, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            return "newproduct";
        } else{
            productService.save(product);
            return "redirect:/product";
        }
    }

    @GetMapping(value="/edit/{id}")
    public String editProduct(@PathVariable int id, ModelMap modelMap) {
        Product product = productService.getOne(id);
        modelMap.addAttribute("product", product);
        return "editproduct";
    }
    
    @PostMapping("/update")
    public String updateProduct(@Valid @ModelAttribute("product") Product p, BindingResult result ){
        if(result.hasErrors()){
            System.out.println("Error during update");
            return "editproduct";
        } else{
            Product product = productService.getOne(p.getId());
            product.setName(p.getName());
            product.setPrice(p.getPrice());
            product.setUnitInStock(p.getUnitInStock());
            product.setCategory(p.getCategory());
            productService.save(product);
            return "redirect:/product";
        }
    }

    @GetMapping(value="/delete/{id}")
    public ModelAndView deleteProduct(@PathVariable int id) {
        Product product = productService.getOne(id);
        productService.delete(product);
        return new ModelAndView("redirect:/product");
    }
    
    @ModelAttribute("categories")
    public List<Category> initializeCategories(){
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }
    
}
