package com.sample.sodamachine.request;

import java.io.Serializable;
import java.util.List;

public class SodaMachineRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 320072409517238975L;



	private Integer selectedProductId;

	private List<Integer> actionTypeList;



	public Integer getSelectedProductId() {
		return selectedProductId;
	}

	public void setSelectedProductId(Integer selectedProductId) {
		this.selectedProductId = selectedProductId;
	}

	public List<Integer> getActionTypeList() {
		return actionTypeList;
	}

	public void setActionTypeList(List<Integer> actionTypeList) {
		this.actionTypeList = actionTypeList;
	}

	

	




}
