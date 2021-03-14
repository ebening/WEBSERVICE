package com.uadec.core.cm;

import java.util.ArrayList;
import java.util.List;

public class ChildCm {
	private String name;
	private Object value;

	public ChildCm(String name, Object value) {
		super();
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
	public static List<ChildCm> getChilds(String name, Object... values){
		List<ChildCm> childs = new ArrayList<ChildCm>();
		ChildCm ccm;
		for(Object value : values){
			ccm = new ChildCm(name, value);
			childs.add(ccm);
		}
		return childs;
	}
}