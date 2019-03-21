package com.javainuse.main;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import com.javainuse.SimpleRouteBuilder;

public class MainApp {

    public static void main(String[] args) {
        SimpleRouteBuilder routeBuilder = new SimpleRouteBuilder();
        CamelContext ctx = new DefaultCamelContext();
        
        //configure jms component        
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");
        //added component is called jms below. it is connection is mentioned at simpleroutebuilder class.
        ctx.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
        
        try {
            ctx.addRoutes(routeBuilder);
            ctx.start();
            Thread.sleep(5 * 60 * 1000);
            ctx.stop();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}