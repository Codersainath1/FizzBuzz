package com.FizzBuzz.Project.Bean;

import org.springframework.stereotype.Component;

@Component
public class RequestParamiter {


	private long int1;
	
	private long int2;
	
	private long limit;
	
	private String str1;
	
	private String str2;
	
	private long count;
	
	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public RequestParamiter()
	{
		
	}

	public long getInt1() {
		return int1;
	}

	public void setInt1(long int1) {
		this.int1 = int1;
	}

	public long getInt2() {
		return int2;
	}

	public void setInt2(long int2) {
		this.int2 = int2;
	}

	public long getLimit() {
		return limit;
	}

	public void setLimit(long limit) {
		this.limit = limit;
	}

	public String getStr1() {
		return str1;
	}

	public void setStr1(String str1) {
		this.str1 = str1;
	}

	public String getStr2() {
		return str2;
	}

	public void setStr2(String str2) {
		this.str2 = str2;
	}

	public RequestParamiter(long int1, long int2, long limit, String str1, String str2) {
		super();
		this.int1 = int1;
		this.int2 = int2;
		this.limit = limit;
		this.str1 = str1;
		this.str2 = str2;
	}

	
	
}
