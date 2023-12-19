package com.producerwork.Producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import com.producerwork.Producer.dto.Customer;
import com.producerwork.Producer.service.KafkaMessagePublisher;

@RestController
@RequestMapping("/producer-app")
public class EventController 
{
	  @Autowired
	    private KafkaMessagePublisher publisher;

	    @GetMapping("/publish/{message}")
	    public ResponseEntity<?> publishMessage(@PathVariable String message) 
	    {
	        try
	        {
	            for (int i = 0; i <= 1000; i++) 
	            {
	                publisher.sendMessageToTopic(message + " : " + i);
	            }
	            return ResponseEntity.ok("message sent successfully");
	        }
	        catch (Exception ex) 
	        {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .build();
	        }
	    }
}
