package com.sdl.web.domain;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

public class TranslationLog {

	private Date timestamp;

	private TranslationRequest request;

	public TranslationLog(Date timestamp, TranslationRequest request) {
	    this.timestamp = timestamp;
	    this.request = request;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public TranslationRequest getRequest() {
		return request;
	}

	public void setRequest(TranslationRequest request) {
		this.request = request;
	}
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
