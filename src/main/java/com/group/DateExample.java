package com.group;

import java.time.LocalDateTime;

public class DateExample {
	private LocalDateTime date;
	private String message;

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setMessage() {
		this.date = LocalDateTime.now();
		this.message = "現在時刻:" + date;
	}

}
