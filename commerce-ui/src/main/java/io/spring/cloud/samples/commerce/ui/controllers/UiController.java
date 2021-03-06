package io.spring.cloud.samples.commerce.ui.controllers;

import io.spring.cloud.samples.commerce.ui.services.fortunes.CommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.spring.cloud.samples.commerce.ui.services.fortunes.Item;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class UiController {

    @Autowired
    CommerceService service;

     @RequestMapping("/item/{id}")
  public List<Item> itemsByid(@PathVariable("id") String id) {
        return service.itemsById(id);}
   
    
    @RequestMapping("/items")
    public List<Item> itemCommerce() {
        
        return service.itemCommerce();
    }
    
    @RequestMapping("/category/{cat}")
  public Iterable<Item> itemsByCategory(@PathVariable("cat") String category) {
        return service.itemsCategory(category);
    }
    
//  @RequestMapping("/prices")
//    public Map priceCommerce() {
//        
//        return service.priceCommerce();
//    }
//    
//   @RequestMapping("/price/{item}")
//    public Map priceitemCommerce(@PathVariable("item") String itemdId) {
//        
//        return service.priceitemCommerce(itemdId);
//    }
  
//    @RequestMapping("/test")
//    public String test() {
//        return "Testing";
//    }
    
}
