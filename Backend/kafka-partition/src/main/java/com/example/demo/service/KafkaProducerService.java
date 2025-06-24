package com.example.demo.service;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final String TOPIC = "multi_partition_topic";
    private static final int NUM_PARTITIONS = 3;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessageToPartition(String message) {
        int partition = Math.abs(message.hashCode()) % NUM_PARTITIONS;

        ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC, partition, null, message);

        kafkaTemplate.send(record)
            .thenAccept(result -> {
                RecordMetadata metadata = result.getRecordMetadata();
                System.out.printf(" Sent to partition %d with offset %d: %s%n",
                        metadata.partition(), metadata.offset(), message);
            })
            .exceptionally(ex -> {
                System.err.println(" Error sending message: " + ex.getMessage());
                return null;
            });
    }
}
