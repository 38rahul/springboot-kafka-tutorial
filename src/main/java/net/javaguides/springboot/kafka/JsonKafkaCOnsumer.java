package net.javaguides.springboot.kafka;

import net.javaguides.springboot.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaCOnsumer {


    @Value("${spring.kafka.topic-json.name}")
    private String topicJsonName;

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaCOnsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic-json.name}",groupId = "${spring.kafka.consumer.group-id}")
    public void  consume(User user){
        LOGGER.info(String.format("Json message recieved -> %s", user.toString()));



    }
}
