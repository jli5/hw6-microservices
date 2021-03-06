/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.spring.cloud.samples.commerce.ui.services.fortunes;

/**
 *
 * @author jingli
 */
public class Item {
   
    public Long id;
    public String name;
    public String description;
    public String category;
    public String price;
    
      public Item() {
    }

    public Item(Long id, String name,String description,String category) {
        this.id = id;
        this.name = name;
        this.description=description;
        this.category=category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price= price;
    }

}
