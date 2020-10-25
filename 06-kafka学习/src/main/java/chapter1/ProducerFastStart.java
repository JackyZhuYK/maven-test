package chapter1;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class ProducerFastStart {
    public static final String brokerList = "localhost:9092,localhost:9093,localhost:9095";
    public static final String topic = "topic-demo";

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("bootstrap.servers", brokerList);
        //配置生产者客户端参数并创建KafkaProducer实例
        KafkaProducer<String, String> producer =
                new KafkaProducer<>(properties);
        //构建所需要发送的消息
        ProducerRecord<String, String> record =
                new ProducerRecord<>(topic, "hello, Kafka!");
        //发送消息
        try {
            producer.send(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //关闭生产者客户端示例
        producer.close();
    }
}
