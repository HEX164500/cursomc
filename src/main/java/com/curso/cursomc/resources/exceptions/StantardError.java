package com.curso.cursomc.resources.exceptions;

import java.io.Serializable;

public class StantardError implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer status;
	private String message;
	private long timeStamp;
	
	public StantardError(Integer status, String message, long timeStamp) {
		super();
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	
}
