package com.example.demo.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    /**
     * Listen to partition 0 of the topic.
     */
    @KafkaListener(
        topicPartitions = @TopicPartition(topic = "multi_partition_topic", partitions = {"0"}), 
        groupId = "my-group"
    )
    public void consumeMessageFromPartition0(ConsumerRecord<String, String> record) {
        System.out.println("Consumed message from partition 0: " + record.value());
    }

    /**
     * Listen to partition 1 of the topic.
     */
    @KafkaListener(
        topicPartitions = @TopicPartition(topic = "multi_partition_topic", partitions = {"1"}), 
        groupId = "my-group"
    )
    public void consumeMessageFromPartition1(ConsumerRecord<String, String> record) {
        System.out.println("Consumed message from partition 1: " + record.value());
    }

    /**
     * Listen to partition 2 of the topic.
     */
    @KafkaListener(
        topicPartitions = @TopicPartition(topic = "multi_partition_topic", partitions = {"2"}), 
        groupId = "my-group"
    )
    public void consumeMessageFromPartition2(ConsumerRecord<String, String> record) {
        System.out.println("Consumed message from partition 2: " + record.value());
    }
}

