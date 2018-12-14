package com.pimwi.marvel.service.response;

import java.io.Serializable;
import java.util.List;

public class CharactersResponse implements Serializable {

	private int code;
	
	private String status;
	
	private Data data;
	
	
	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
