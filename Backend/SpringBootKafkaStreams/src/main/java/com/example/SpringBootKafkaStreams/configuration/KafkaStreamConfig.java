package com.example.SpringBootKafkaStreams.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@EnableKafkaStreams
public class KafkaStreamConfig {
    @Bean
    public KStream<String,String> StreamConfig(StreamsBuilder builder) {
        KStream<String, String> stream = builder.stream("input-topic");
        stream
                .filter((key, value) -> value != null && value.toLowerCase().contains("error"))
                .to("error-topic");
        // This is just an example bean. You can replace it with your actual Kafka Streams configuration.
        return stream;
    }
    //This is for creating the input and output topics for Kafka Streams
    @Bean
    public NewTopic inputTopic() {
        return TopicBuilder.name("input-topic")
                .partitions(1)
                .replicas(1)
                .build();
    }
    //This is for creating the input and output topics for Kafka Streams
    @Bean
    public NewTopic outputTopic() {
        return TopicBuilder.name("error-topic")
                .partitions(1)
                .replicas(1)
                .build();
    }

}
