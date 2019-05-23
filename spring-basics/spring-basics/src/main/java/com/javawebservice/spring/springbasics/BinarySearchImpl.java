package src.main.java.com.javawebservice.spring.springbasics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {
	
public void setSortalgo(SortAlgorithm sortalgo) {
		this.sortalgo = sortalgo;
	}

@Autowired
private SortAlgorithm sortalgo;

public int binarySearch(int[] numbers, int numberToSearchFor) {
	
	int [] sortedNumbers = sortalgo.sortAl(numbers);
	return 0;
}
}
