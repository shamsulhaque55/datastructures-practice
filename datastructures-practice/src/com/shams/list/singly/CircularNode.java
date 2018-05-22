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
		//CircularNode<?> otherValue = (CircularNode<?>) obj;
		boolean result = obj.equals(this.value);
		return result;
	}
	
	

}
