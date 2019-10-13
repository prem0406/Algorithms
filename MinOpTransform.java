/*
Minimum operation to transform CBFDAE to EFABCD. The only operation is allowed is to pick a letter to 
begining of the word(the leftmost position.). This operation is counted as one operation. You have to
find the minimum operation to transform former string to latter.
*/

import java.util.*;
class MinOpTransform{
	public static void main(String[] args){
		String A = "CBFDAE";
		String B = "EFABCD";
		int count = new MinOpTransform().minOps(A,B);
		System.out.println("Min ops to transform "+A+" to "+B+" : "+count);
	}
	
	public int minOps(String A, String B){
		if(A.length() != B.length())
			return -1;
		char[] arr1 = A.toCharArray();
		char[] arr2 = B.toCharArray();
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		if(!Arrays.equals(arr1,arr2))
			return -1;
		
		int i = A.length() - 1;
		int j = B.length() - 1;
		int res=0;
		
		while(i>=0){
			if(A.charAt(i) != B.charAt(j))
				res++;
			else
				j--;
			i--;
		}
		return res;
	}
}