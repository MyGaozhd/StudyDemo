package com.gaozhd.studydemo.utils;

import java.util.LinkedList;

/**
 * Java编码规范
 * 
 * @author zhd
 * 
 */
public class GaoFormatter {

	private final LinkedList fStack;

	public GaoFormatter() {
		
		fStack = new LinkedList();
		
	}

	public int pop() {
		
		return ((Integer) fStack.removeFirst()).intValue();
		
	}

	public void push(int elem) {
		
		fStack.addFirst(new Integer(elem));
		
	}

	public boolean isEmpty() {
		
		if (fStack.isEmpty() == true)
		{
			return true;
		} 
		else
		{
			return false;
		}
	}
}
