package com.example.SpringBootKafkaPartitions.services;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service

public class KafkaPartitionsConsumer {

    @KafkaListener(
            topicPartitions = @TopicPartition(topic = "multi-partition-topic", partitions = {"0"}),
            groupId = "my-group"
                )
    public void consumeMessageFromPartition0(ConsumerRecord<String, String> record) {
        System.out.println("Consumed message from partition 0: " + record.value());
    }


    @KafkaListener(
            topicPartitions = @TopicPartition(topic = "multi-partition-topic", partitions = {"1"}),
            groupId = "my-group"
    )
    public void consumeMessageFromPartition1(ConsumerRecord<String, String> record) {
        System.out.println("Consumed message from partition 1: " + record.value());
    }

    @KafkaListener(
            topicPartitions = @TopicPartition(topic = "multi-partition-topic", partitions = {"2"}),
            groupId = "my-group"
    )
    public void consumeMessageFromPartition2(ConsumerRecord<String, String> record) {
        System.out.println("Consumed message from partition 2: " + record.value());
    }


}
