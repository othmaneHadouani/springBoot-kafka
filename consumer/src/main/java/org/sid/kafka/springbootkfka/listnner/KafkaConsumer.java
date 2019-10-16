package org.sid.kafka.springbootkfka.listnner;

import org.sid.kafka.springbootkfka.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer{

    @KafkaListener(topics = "testkafk",groupId = "group_id")
    public void consume(String message){
        System.out.println(message);
    }

   /* @KafkaListener(topics = "testkafk",groupId = "group_json",containerFactory = "userkafkaListenerContainerFactory")
    public void consumeJson(User user){
        System.out.println(user.toString());
    }*/

}
