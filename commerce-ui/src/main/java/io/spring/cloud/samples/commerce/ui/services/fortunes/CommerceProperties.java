package io.spring.cloud.samples.commerce.ui.services.fortunes;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author sgupta
 * @since 2/28/16.
 */
@ConfigurationProperties(prefix = "commerce")
@RefreshScope
public class CommerceProperties {

  private static final Random RANDOM = new Random();

  List<String> messages = new ArrayList<>();

  public List<String> getMessages() {
    return messages;
  }

  public void setMessages(List<String> messages) {
    this.messages = messages;
  }

  public void addMessage(String message) {
    this.messages.add(message);
  }

  /*public Item getRandomCommerceFromProperty() {
    if(messages == null || messages.size() == 0) {
      return new Item(new Long("111"),"test","test","test");
    }
    else {
      //int index = RANDOM.nextInt(messages.size());
     // return new Fortune((long) index, messages.get(index));
    return new Item(new Long("222"),"test2","test2","test2");
    }
  }*/
}
