package com.app.response;

public class AppResponse<T> {

	public AppResponse(T data) {
		this.data = data;
	}

	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
