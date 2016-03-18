package ru.pavel2107.ostd.web;

/**
 * Created by pavel2107 on 02.03.16.
 */
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by admin on 28.02.2016.
 */


@Configuration
@ImportResource( {
        "classpath:src/main/resources/spring-app.xml",
        "classpath:spring/spring-db.xml",
        "classpath:spring/spring-jms-producer.xml"})
public class MyApplicationContext {
}