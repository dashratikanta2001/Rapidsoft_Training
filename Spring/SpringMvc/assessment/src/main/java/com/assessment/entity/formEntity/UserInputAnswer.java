package com.assessment.entity.formEntity;

import java.util.Map;


public class UserInputAnswer {
	
	
	private Map<Integer, Integer> selectedOptions;
	
	public Map<Integer, Integer> getSelectedOptions()
	{
		return selectedOptions;
	}
	
	public void setSelectedOptions(Map<Integer, Integer> selectedOptions)
	{
		this.selectedOptions = selectedOptions;
	}
}