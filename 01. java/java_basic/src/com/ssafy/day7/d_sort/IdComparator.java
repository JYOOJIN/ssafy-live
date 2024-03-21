package com.ssafy.day7.d_sort;

import java.util.Comparator;

public class IdComparator implements Comparator<String>{
	public int compare(String o1, String o2) {
		int len1 = o1.length();
		int len2 = o2.length();
		
		return Integer.compare(len1, len2);
	}
}
