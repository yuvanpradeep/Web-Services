package com.javawebservice.spring.springbasics;

public class BinarySearchImpl {
private SortAlgorithm sortalgo;

public BinarySearchImpl(SortAlgorithm sortalgo) {
	super();
	this.sortalgo = sortalgo;
}

public int binarySearch(int[] numbers, int numberToSearchFor) {
	
	int [] sortednumbers = sortalgo.sortAl(numbers);
	return 0;
}
}
