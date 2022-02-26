# UCS_GetContacts
Получение контактной информации из Universal Contact Server Genesys. Используется PSDK Genesys

# Getting Started
## Требования для корректной работы примера
* Пример собирался на Java 1.8_271
* Использование PSDK Genesys (указаны в помнике(8.5.3))
* Для текущей PSDK используется Netty 3.9.4.Final
* Существует доступ до сервиса Universal Contact Server

## Сборка
1. Скачиваем репозиторий
2. Подготавливаем psdk зависимости
3. Собираем командой `mvn clean install`
4. Сборка прилетает в проект в **../target**

## Запуск
1. Переходим в директорию собранного приложения - **../target**
2. Настраиваем файл **applications.properties** согласно вашей архитектуре
3. Простой режим `$JAVA_HOME/bin/java -jar target/GetContacts-1.0-SNAPSHOT.jar andrei.genesysexamples.get_contact.GetContactApplication`
4. Либо в режиме дебага `$JAVA_HOME/bin/java -jar target/GetContacts-1.0-SNAPSHOT.jar andrei.genesysexamples.get_contact.GetContactApplication -Dlogging.level.root=DEBUG`

## Ссылки на документацию
Для более подробного изучения, просьба воспользоваться ссылками:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.3/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.3/maven-plugin/reference/html/#build-image)
* [Genesys PSDK](https://docs.genesys.com/Documentation/PSDK#t-1)

# Контакты
Можно связаться написав в/на:
1. Telegram - https://t.me/anbezrukikh
2. email: andreiiko2@rambler.ru