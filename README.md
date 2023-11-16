# Инструкция по запуску

Следуйте этим шагам, чтобы успешно запустить приложение.

## Предварительные требования

Убедитесь, что у вас установлены следующие компоненты:

- Java Development Kit (JDK) 11+
- Apache Maven
- Docker
- Prometheus
- Grafana
- K6

## Шаги по запуску

1. **Склонируйте репозиторий**
   ```bash
   git clone https://github.com/k0xzy/loadtest_k6_kafka
   cd loadtest_k6_kafka

2. **Сборка проекта**
    ```bash
      mvn package

3. **Запустите приложение (port->:8080)**
    ```bash
    java -jar target/test_task_k6-0.0.1-SNAPSHOT.jar

4. **Запустите Docker из папки проекта**
    ```bash
   docker-compose up -d

5. Настройте Prometheus, используя файл конфигурации `prometheus.yml`

6. Настройте Grafana, импортируя файл дашборда с метриками JVM `dashboard_4701_rev10.json`


7. **Запустите скрипт из папки проекта**
    ```bash
    k6 run load_test.js
