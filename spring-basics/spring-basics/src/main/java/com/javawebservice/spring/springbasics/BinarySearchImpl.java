package com.javawebservice.spring.springbasics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {
	
@Autowired
private SortAlgorithm sortalgo;

public BinarySearchImpl(SortAlgorithm sortalgo) {
	super();
	this.sortalgo = sortalgo;
}

public int binarySearch(int[] numbers, int numberToSearchFor) {
	
	int [] sortedNumbers = sortalgo.sortAl(numbers);
	return 0;
}
}
