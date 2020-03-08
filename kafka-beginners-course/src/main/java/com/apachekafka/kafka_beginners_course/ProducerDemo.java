package com.apachekafka.kafka_beginners_course;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class ProducerDemo {
	public static void main(String[] args) {
		//System.out.println("hello world");
		String bootstarpService="localhost:9092";
		
		//create producer properties
		Properties prop=new Properties();
		/*prop.setProperty("bootstrap.server",bootstarpService);
		prop.setProperty("key.serializer",StringSerializer.class.getName());
		prop.setProperty("value.serializer",StringSerializer.class.getName());*/
		
		prop.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstarpService);
		prop.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
		prop.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
		
		//create the producer key and value be String
		KafkaProducer<String, String> producer=new KafkaProducer<String, String>(prop);
		ProducerRecord<String, String>record=new ProducerRecord<String, String>("first_topic","Hello World");
		//send data asynchronous
		producer.send(record);
		
		//flush data
		producer.flush();
		//flush and close producer
		producer.close();
		
	}
}
