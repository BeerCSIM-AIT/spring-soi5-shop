package nvc.bcit.soi5shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import nvc.bcit.soi5shop.model.Product;
import nvc.bcit.soi5shop.service.ProductService;


@Controller
public class MainController {
    @Autowired
    private ProductService productService;
    @GetMapping("/")
    public String index () {
        return "index";
    }
    
    @GetMapping("/product")
    public ModelAndView product () {
        
        List<Product> products = productService.findAll();
        return new ModelAndView("product","products", products);
    }
}
