# Kafka với Spring Boot

Dự án này minh họa cách sử dụng Kafka với Spring Boot, bao gồm cấu hình Kafka Cluster và tích hợp Spring Boot để gửi/nhận tin nhắn.

---

## 1. Cấu hình Kafka Cluster với Docker Compose

### Bước 1: Tạo file `docker-compose.yml`
File `docker-compose.yml` được sử dụng để khởi tạo một Kafka Cluster với 3 Zookeeper và 3 Kafka Broker. Nội dung file đã được cung cấp trong dự án.

### Bước 2: Chạy Kafka Cluster
Sử dụng lệnh sau để khởi động Kafka Cluster:
```bash
docker-compose up -d
```
Lệnh này sẽ khởi động các container Zookeeper và Kafka Broker.

![Khởi động Kafka Cluster](image-3.png)

### Bước 3: Kiểm tra trạng thái
Sử dụng lệnh sau để kiểm tra trạng thái các container:
```bash
docker ps
```
Hãy đảm bảo rằng tất cả các container đều đang chạy.

![Kiểm tra trạng thái container](image-4.png)

---

## 2. Tạo Spring Boot Application

### Bước 1: Tạo dự án Spring Boot
- Truy cập [Spring Initializr](https://start.spring.io/).
- Chọn các thông số:
  - **Project**: Maven
  - **Language**: Java
  - **Spring Boot Version**: 2.7.x hoặc mới hơn
  - **Dependencies**: Spring Web, Spring for Apache Kafka
- Nhấn **Generate** để tải về dự án.

### Bước 2: Cấu hình Kafka trong `application.yml`
Thêm cấu hình Kafka vào file `application.yml`:
```yaml
spring:
  kafka:
    bootstrap-servers: kafka1:9092,kafka2:9093,kafka3:9094
    consumer:
      group-id: my-group
      auto-offset-reset: earliest
    producer:
      key-serializer: org.apache.kafka.common.serialization.StringSerializer
      value-serializer: org.apache.kafka.common.serialization.StringSerializer
    consumer:
      key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
      value-deserializer: org.apache.kafka.common.serialization.StringDeserializer
```

### Bước 3: Tạo Producer và Consumer
- **Producer**: Tạo một service để gửi tin nhắn đến Kafka.
- **Consumer**: Tạo một listener để nhận tin nhắn từ Kafka.

Ví dụ:
```java
// Producer
@Service
public class KafkaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }
}

// Consumer
@Component
public class KafkaConsumer {
    @KafkaListener(topics = "my-topic", groupId = "my-group")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}
```

---

## 3. Chạy và kiểm tra ứng dụng

### Bước 1: Chạy ứng dụng Spring Boot
Sử dụng lệnh sau để chạy ứng dụng:
```bash
mvn spring-boot:run
```

### Bước 2: Gửi tin nhắn đến Kafka
Sử dụng API hoặc giao diện người dùng để gửi tin nhắn đến Kafka thông qua Producer.

![Gửi tin nhắn đến Kafka - 1](image.png)
![Gửi tin nhắn đến Kafka - 2](image-1.png)

### Bước 3: Kiểm tra tin nhắn
Kiểm tra log của ứng dụng để xem Consumer đã nhận được tin nhắn hay chưa.

![Kiểm tra log ứng dụng](image-2.png)

---

## 4. Chạy 3 cluster trong Kafka
![alt text](image-5.png)

## 5. Tắt 1 máy Kafka đi
![alt text](image-6.png)

![image](https://github.com/user-attachments/assets/6737ff5d-c57c-4699-a40e-659a296fa9cb)
