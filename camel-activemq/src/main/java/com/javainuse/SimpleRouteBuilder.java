package com.javainuse;

import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {
	//configure route for jms component
    @Override
    public void configure() throws Exception {
        from("file:C:/inputFolder").split().tokenize("\n").to("jms:queue:javainuse");
        /* splitter EIP pattern is implemented above to split the file. defined jms queue is called javainuse at activemq console 
         * jms 		 --> protocol
         * queue:javainuse 	 --> context path(a.k.a topic)
         * in this example javainuse topic will be created */
    }

}