package springkafkabasics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springkafkabasics.model.Employee;
import springkafkabasics.producer.KafkaProducer;

@SpringBootApplication
public class SpringKafkaSampleApp implements CommandLineRunner
{
	private static Logger logger = LoggerFactory.getLogger(SpringKafkaSampleApp.class.getName());
	
	@Autowired
	KafkaProducer kafkaProducer;

		    public static void main(String[] args) {
		    	logger.info("STARTING THE APPLICATION");
		    	SpringApplication.run(SpringKafkaSampleApp.class, args);
		        logger.info("APPLICATION FINISHED");
		    }

			@Override
			public void run(String... args) throws Exception {
				Employee employee1 = new Employee("Emp1", "Dept1", "100");
				Employee employee2 = new Employee("Emp2", "Dept2", "200");
				Employee employee3 = new Employee("Emp3", "Dept3", "300");
				kafkaProducer.send(employee1);
				kafkaProducer.send(employee2);
				kafkaProducer.send(employee3);
				//kafkaProducer.sendMessage("test");
				//kafkaProducer.sendMessageWithCallback("message for callback ");
				//kafkaProducer.sendCustomizedMessage("Custom message");
				
				
				
			}

}
