package com.app.dto;

import java.util.List;

public class AppResponseList<T> {

	public AppResponseList(List<T> list) {
		super();
		this.list = list;
	}

	private List<T> list;

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
