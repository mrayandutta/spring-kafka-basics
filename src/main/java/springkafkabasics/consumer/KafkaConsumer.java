package springkafkabasics.consumer;

import java.text.SimpleDateFormat;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * The Kafka multiple consumer configuration involves following classes:
 * DefaultKafkaConsumerFactory : is used to create new Consumer instances where all consumer share common configuration 
 * properties mentioned in this bean.
 * ConcurrentKafkaListenerContainerFactory : is used to build ConcurrentMessageListenerContainer. 
 * This factory is primarily for building containers for @KafkaListener annotated methods.
 * ConsumerConfig : holds the consumer configuration keys.
 * KafkaListener : marks a method to be the target of a Kafka message listener on the specified topics
 * 
 *
 */
@Component
public class KafkaConsumer {
	
	SimpleDateFormat sdf ;
	
	//@KafkaListener(topics = "${target.topic}", groupId="${spring.kafka.consumer.group-id}")
	@KafkaListener(topics = "${target.topic}", groupId="${spring.kafka.consumer.group-id}",containerFactory="kafkaListenerContainerFactory")
	//@KafkaListener(topics = "${target.topic}", groupId="${spring.kafka.consumer.group-id}",containerFactory="secondaryKafkaListenerContainerFactory")
    public void consume(String message) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!  Consumed message with consumerFactory: " + message);
    }
	
	@KafkaListener(topics = "${target.topic}", groupId="${spring.kafka.consumer.group-id}",containerFactory="secondaryKafkaListenerContainerFactory")
    public void consumeSecondary(String message) {
        System.out.println("*****  Consumed message with secondary consumerFactory: " + message);
    }

}
