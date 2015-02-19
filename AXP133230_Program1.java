/**
 * 
 * @author Arvind Krishna Parthasarathy - axp133230
 *
 */

public class AXP133230_Program1 {
	int count = 0;
	
	/*
	 * This function takes in 4 arguments, array A, the index at which the insertion should happen
	 * now, the number of objects to be selected, and verbose for output mode.
	 */
	public void permKofN(int[] A,  int index, int k, int v) {
			if(k == 0) visit(A, v);
			else{
				for(int thisNumber = 1; thisNumber<=A.length; thisNumber++){
					int flag = 0;
					/*
					 * This for loop checks if the number to be inserted is already in the output
					 * permutation. If its present already, we don't do anything and continue.
					 */
					for(int input = 0; input<index; input++)
					{
						if(A[input]==thisNumber){
							flag = 1;
							break;
						}
					}
					if(flag == 1) continue;
					A[index] = thisNumber;
					permKofN(A, index+1, k-1, v);
					A[index] = 0;
					}
				}
	}
	
	/*
	 * Combination function takes as input 5 arguments, array A, length of A as n, current index
	 * pointer l, number of objects to select, and verbose v for output mode.
	 */
	public void combKofN(int[] A, int n, int l, int i, int v) {
		if(i == 0) visit(A, v);
		else if(i>n-l) return;
		else{
				if(A[l] == 0){
					A[l] = l+1;
					combKofN(A, n, l+1, i-1, v);
					A[l] = 0;
					combKofN(A, n, l+1, i, v);
				}
				
				
			}
	}
	
	/*
	 * If verbose is 0 or 1, we just print the number of permutations or combinations, else
	 * we print out all permutations and combinations with the time taken to run the function.
	 */
	void visit(int[] A, int v){
		if (v > 1 ) {
		      for(int i = 0; i < A.length; i++) {
			 if(A[i]>0)System.out.print(A[i] + " ");
		      }
		      System.out.println();
		}
	    count = count+1;
	}
	
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int k = Integer.parseInt(args[1]);
		int v = Integer.parseInt(args[2]);
		int[] A = new int[n];
		AXP133230_Program1 obj = new AXP133230_Program1();
		for (int i = 0; i < n; i++){
			A[i] = 0;
		}
		if(v == 0 || v == 2){
		long start = System.currentTimeMillis();
		obj.permKofN(A, 0, k, v);
		long end = System.currentTimeMillis();
		System.out.println(obj.count+" "+(end-start));
		}
		if(v == 1 || v == 3){
			long start = System.currentTimeMillis();
			obj.combKofN(A, n, 0, k, v);
			long end = System.currentTimeMillis();
			System.out.println(obj.count+" "+(end-start));
		}
	}
}
