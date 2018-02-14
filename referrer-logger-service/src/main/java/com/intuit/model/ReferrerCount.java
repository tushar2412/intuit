package com.intuit.model;

public class ReferrerCount
{	
	private String domain;
	private Long   count;

	public ReferrerCount(String domain, Long count) {
		this.domain = domain;
		this.count  = count;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}
	
	
}
