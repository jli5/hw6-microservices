package io.spring.cloud.samples.commerce.ui.services.fortunes;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import static com.rabbitmq.tools.jsonrpc.JsonRpcServer.response;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import static org.apache.commons.lang3.Range.is;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;


@Service
@EnableConfigurationProperties(CommerceProperties.class)
public class CommerceService {

    @Autowired
    CommerceProperties commerceProperties;

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallbackFortune")
    public List<Item> itemCommerce() {
        
        Item[] temp=restTemplate.getForObject("http://item/items",Item[].class);
        
        Map<String, String> tempprice=restTemplate.getForObject("http://price/prices", Map.class);     
        for(int i=0;i<temp.length;i++){
           Long itemid=temp[i].id;
           String price=tempprice.get(itemid.toString());
           temp[i].setPrice(price);
           
        }
             
   
        return Arrays.asList(temp);
    }
    
////     @HystrixCommand(fallbackMethod = "fallbackPrice")
//    public Map priceCommerce() {
//             
//         Map<String, String> tempprice=restTemplate.getForObject("http://price/prices", Map.class);
//        
//        return tempprice;
//    }
//    
//
//   
////     @HystrixCommand(fallbackMethod = "fallbackPriceItem")
//    
//    public Map priceitemCommerce(String itemdId) {
//    Map<String, String> temppriceitem=restTemplate.getForObject("http://price/price"+itemdId, Map.class);
//    return temppriceitem;
//  }
//    
    
    
     @HystrixCommand(fallbackMethod = "fallbackCategory")
  public List<Item> itemsCategory(String category) {
    Item[] temp=restTemplate.getForObject("http://item/category/"+category,Item[].class);
    
     Map<String, String> tempprice=restTemplate.getForObject("http://price/prices", Map.class);     
        for(int i=0;i<temp.length;i++){
           Long itemid=temp[i].id;
           String price=tempprice.get(itemid.toString());
           temp[i].setPrice(price);
           
        }
    
    return Arrays.asList(temp);
  }
  
  
       @HystrixCommand(fallbackMethod = "fallbackId")
  public List<Item> itemsById(String id) {
    Item[] temp=restTemplate.getForObject("http://item/item/"+id,Item[].class);
    
     Map<String, String> tempprice=restTemplate.getForObject("http://price/prices", Map.class);     
        for(int i=0;i<temp.length;i++){
           Long itemid=temp[i].id;
           String price=tempprice.get(itemid.toString());
           temp[i].setPrice(price);
           
        }
    return Arrays.asList(temp);
  }
  
  
  /* @HystrixCommand(fallbackMethod = "fallbackid")
  public List<Long> itemsByid(Long id) {
      Item item = null;
      List<Long> iteml=new ArrayList<Long>();
      List<Item> temList=itemCommerce();
     
      for(int i=0; i < temList.size();i++)
      {
         item=temList.get(i);
         
         iteml.add(item.id);
//      if(temList.get(i).id.equals(id)){
//         
//          item.add(temList.get(i));
//      }
      }
      
      return iteml;
  }*/

    public List<Item> fallbackFortune() {
       return new ArrayList();
       
    }
    
    
  public List<Item> fallbackId(String i) {
       return new ArrayList();
       
    }
    
     public List<Item> fallbackCategory(String cat) {
       return new ArrayList();
       
    }
}
