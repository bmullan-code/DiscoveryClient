package com.example.DiscoveryClient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AppStartupRunner implements ApplicationRunner {
	
	private static void dumpVars(Map<String, ?> m) {
		  List<String> keys = new ArrayList<String>(m.keySet());
		  Collections.sort(keys);
		  for (String k : keys) {
		    System.out.println(k + " : " + m.get(k));
	  }
	}

 
    public static int counter;
	@Autowired private DiscoveryClient discoveryClient;
	@Autowired RestTemplate restTemplate;
	
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Application started with option names : {}" + 
          args.getOptionNames());
        System.out.println("Increment counter");
        counter++;
        
//        System.out.println("===== ENV VARIABLES =====");
//	    dumpVars(System.getenv());
        
		ServiceInstance instance = this.discoveryClient.getInstances("intermediate").get(0);
		List<ServiceInstance> instances = this.discoveryClient.getInstances("intermediate");
		System.out.println("Instances:");
		
		System.out.println("Instance:"+instance.getUri());
	    String obj = restTemplate.getForObject(instance.getUri()+"/api", String.class);
	    System.out.println("obj:"+obj);


    }
}