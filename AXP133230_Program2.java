/**
 * Arvind Krishna Parthasarathy - axp133230
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 
 *Class for program 2, outputs distinct permutations in sorted order even if the input array does not contain distinct values.
 *
 */
public class AXP133230_Program2 {
	public int count = 0;
	/*
	 * The function takes as input 3 parameters, sorted array A, size of the array n, and 
	 * the verbose v for mode of output.
	 */
	public void findPermutations( int[] A, int n, int v){

		visit(A,v);
		while(true){
			int k = 0, l=0;
			for(int j = 1; j<A.length-1; j++){
				if(A[j]<A[j+1]){
					k = j;
				}
			}
			if (k == 0) break;
			for(int i = k ; i<A.length; i++){
				if(A[k]<A[i]){
					l = i;
				}
			}
			swap(A,k,l);
			int start = k+1;
			int end = n;
			while(start < end)
			{
				swap(A, start, end);
				start++;
				end--;
			}
			visit(A, v);
			
		}
	}
	
	/*
	 * Function visit takes two arguments, an array A, and the verbose v. It outputs all distinct
	 * permutations when v = 1, and just the number of permutations given by count, when v = 0.
	 */
	public void visit(int[] A, int v){
		 for(int i = 1; i < A.length; i++) {
			 if(v == 0)
			 System.out.print(A[i] + " ");
		 }
		 if(v == 0)
		 System.out.println();
		 count++;
	}
	
	/*
	 * The swap function takes 3 arguments, array A, and 2 index values and then swaps them.
	 */
	public void swap(int[] A, int left, int right)
	{
		int tmp = A[left];
		A[left] = A[right];
		A[right] = tmp;
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException{
	String line = "";
	int[] A = null;
	int n = 0;
	int v = 0;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int lineNumber = 1;
	while ((line = br.readLine()) != null && line.length() != 0) {
		String[] arglist = line.split("\\s+");
		if (lineNumber == 1) {
			if (arglist.length == 2) {
				n = Integer.parseInt(arglist[0]);
				v = Integer.parseInt(arglist[1]);
			}else{
				System.out.println("Invalid input");
				System.exit(0);
			}
			lineNumber++;
		} else {
			if (arglist.length == n) {
				A = new int[n + 1];
				for (int i = 1; i <= n; i++) {
					A[i] = Integer.parseInt(arglist[i-1]);
				}
				A[0] = -1;
				break;
			}else{
				System.out.println("invalid input.");
				System.exit(0);
			}
		}
	}
	AXP133230_Program2 obj = new AXP133230_Program2();
	System.out.println("OUTPUT:");
	long start = System.currentTimeMillis();
	Arrays.sort(A);
	obj.findPermutations(A, n, v);
	long end = System.currentTimeMillis();
	System.out.println(obj.count+" "+(end-start));
}
}
