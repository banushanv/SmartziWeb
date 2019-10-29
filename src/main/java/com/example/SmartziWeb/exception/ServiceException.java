package com.example.SmartziWeb.exception;

import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class ServiceException extends RuntimeException {

	private Integer errorCode;
	private String errorMessage;
	private HttpStatus status;

	public ServiceException(Integer errorCode, String errorMessage, HttpStatus status) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.status = status;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
