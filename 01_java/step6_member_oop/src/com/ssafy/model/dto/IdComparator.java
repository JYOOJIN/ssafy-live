package com.ssafy.model.dto;

import java.util.Comparator;

public class IdComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Member && o2 instanceof Member) {
			Member m1 = (Member)o1;
			Member m2 = (Member)o2;
			return m1.getEntryDate().compareTo(m2.getEntryDate());
		}
		else return 0;
	}

}
