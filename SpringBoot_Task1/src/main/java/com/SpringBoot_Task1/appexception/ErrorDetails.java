package com.SpringBoot_Task1.appexception;

import java.time.LocalDateTime;
import java.util.Date;

public class ErrorDetails {

	 private LocalDateTime timestamp;
	    private String message;
	    private String details;

	    public ErrorDetails(LocalDateTime timestamp, String message, String details) {
	        super();
	        this.timestamp = timestamp;
	        this.message = message;
	        this.details = details;
	    }

	    public LocalDateTime getTimestamp() {
	        return timestamp;
	    }

	    public String getMessage() {
	        return message;
	    }

	    public String getDetails() {
	        return details;
	    }
	}

