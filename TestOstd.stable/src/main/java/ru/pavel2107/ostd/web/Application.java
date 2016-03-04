package ru.pavel2107.ostd.web;

import org.apache.activemq.broker.BrokerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import ru.pavel2107.ostd.utils.LoggerWrapper;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by pavel2107 on 02.03.16.
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    LoggerWrapper LOG = LoggerWrapper.get( Application.class);


    private static BrokerService brokerService = null;

    private static void startBroker(){
        brokerService = new BrokerService();
        try {
            System.out.println( "starting broker");
            brokerService.setPersistent(false);
            brokerService.setBrokerName("broker");
            brokerService.addConnector("tcp://localhost:61617");
            brokerService.start();
            System.out.println( "started broker");
        }
        catch (Exception e ){
            try {
                System.out.println( "stopping broker");
                brokerService.stop();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }

    }

    private static boolean isStandalone = true;

    public static boolean isStandalone(){
        return isStandalone;
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        LOG.debug( "Started in WEB environment");
        isStandalone = false;
        startBroker();
        return application.sources( Application.class);
    }
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
        System.out.println( "Started standalone");
        isStandalone = true;
    }

}