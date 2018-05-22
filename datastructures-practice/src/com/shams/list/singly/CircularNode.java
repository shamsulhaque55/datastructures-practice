package com.shams.list.singly;

public class CircularNode <T> {
	
	public CircularNode<?> next = null;
	public T value;
	
	public CircularNode(T value) {
		this.value = value;
	}
	
	public CircularNode() {}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if(obj instanceof Integer) {
			Integer otherValue = (Integer) obj;
			result =  otherValue.equals(this.value);
		}
		if(obj instanceof String) {
			String otherValue = (String) obj;
			result =  otherValue.equals(this.value);
		}
		
		if(obj instanceof Float) {
			Float otherValue = (Float) obj;
			result =  otherValue.equals(this.value);
		}
		if(obj instanceof Double) {
			Double otherValue = (Double) obj;
			result =  otherValue.equals(this.value);
		} else {
			result = obj.equals(this.value);
		}
		return result;
	}
	
	

}
