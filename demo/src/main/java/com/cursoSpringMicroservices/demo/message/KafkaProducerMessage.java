package com.cursoSpringMicroservices.demo.message;

import com.cursoSpringMicroservices.demo.dto.CarPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerMessage {

    @Autowired
    private KafkaTemplate<String, CarPostDTO> kafkaTemplate; //KafkaTemplate é uma classe do próprio Kafka que faz o envio
    // de mensagens pra dentro dos topicos

    private final String KAFKA_TOPIC = "car-post-topic";

    public void sendMessage(CarPostDTO carPostDTO){//Esse é o método que envia mensagens pra dentro do topico do Kafka
        kafkaTemplate.send(KAFKA_TOPIC, carPostDTO); //Vai enviar um carPostDTO pra dentro do topico KAFKA_TOPIC(car-post-topic)
    }
}
