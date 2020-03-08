package findThirdLargest;

import java.util.Arrays;
import java.util.Comparator;

public class FindThirdLargestElement {

	public static void main(String[] args) {
		int[] element= {2,1,5,9,8,10,10,7,11,12,13};
		Arrays.sort(element);
		//program for findin second and third largest elemnt
		int thirdLargest=element.length-3;
		System.out.println(element[thirdLargest]);
		int secondLargest=element.length-2;
		System.out.println(element[secondLargest]);
		int fourthlargest=element.length-4;
		System.out.println(element[fourthlargest]);
		
	}
	

}

