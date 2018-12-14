package com.pimwi.marvel.service.response;

import java.util.List;

public class Data {

	private int total;
	
	private List<Characters> results;

	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<Characters> getResults() {
		return results;
	}

	public void setResults(List<Characters> results) {
		this.results = results;
	}

}
