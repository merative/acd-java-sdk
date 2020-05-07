package com.ibm.watson.health.iml.v1.model;

public class SearchBody {
	private Query query;
	private ReturnsModel returns;

	public SearchBody(Query queryObject, ReturnsModel returnsModel) {
		this.query = queryObject;
		this.returns = returnsModel;
	}

}
