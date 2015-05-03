package org.inru.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {
	
	public static void filter() {
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		
		//java
		List<Integer> filteredList = new ArrayList<Integer>();
		for (Integer i : list) {
			if (i<3) {
				filteredList.add(i);
			}
		}
		System.out.println(filteredList);

		
		//java8
		List<Integer> collect = list.stream().filter(i -> i<3).collect(Collectors.toList());
		System.out.println(collect);
		
	}
	
	public static void main(String[] args) {
		filter();
	}

}
