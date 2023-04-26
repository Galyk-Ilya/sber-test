
1. Для работы приложения необходимо в resources/application.yaml заполнить поля для подключения к БД:
jdbcUrl, username, password;
2. Создать таблицу с помощью SQL запроса:
CREATE TABLE LOG (
MESSAGE     VARCHAR2(1000),
TYPE        VARCHAR2(50),
"LEVEL"     VARCHAR2(10),
TIME        TIMESTAMP
);
3. Логи приложения пишутся в файл sber-test.log, расположенный в корне проекта
4. Healthcheck доступен по адресу localhost:80/actuator/health;
5. Get и Post запросы доступны по адресу localhost:80/core-api/logs.