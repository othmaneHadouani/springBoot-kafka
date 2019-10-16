package org.sid.kafka.springbootkafka.web;


import org.sid.kafka.springbootkafka.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class UserResource {

    @Autowired
    KafkaTemplate<String,User> kafkaTemplate;
    private static final String TOPIC="testkafk";


    @GetMapping(value = "/publish/{name}")
    public String post(@PathVariable("name") final String name){

        kafkaTemplate.send(TOPIC,new User(name,name,20));

        return "published Successfully";
    }
}
