/*
Given an array of positive integers of size n. Find the maximum sum of 
triplet( a[i] + a[j] + a[k] ) such that 0 <= i < j < k < n and a[i] < a[j] < a[k].

TIME COMPLEXITY = O(N^2)
*/

import java.util.*;

class MaxSumTriplet{
	int first, mid, last, ans;
	public static void main(String[] args){
		int arr[] = { 2, 5, 3, 1, 4, 9 };
		ResultClass R = new MaxSumTriplet().getMaxTripletWithIndex(arr);
		System.out.println("Sum of Max Triplet : "+R.ans);
		System.out.println("First : "+R.first+" Second: "+R.mid+" Third: "+R.last);
	}
	
	public int getMaxTriplet(int[] arr){
		int n = arr.length;
		int ans = 0;
		int max1=0, max2=0;
		for(int i = 1; i < n-1; i++){
			
			
			for(int j = 0; j < i; j++)
				if(arr[j] < arr[i])
					max1 = Math.max( max1, arr[j]);
				
			for(int j = i+1 ; j < n; j++)
				if(arr[j] > arr[i])
					max2 = Math.max( max2, arr[j]);
			ans = Math.max( ans, max1 + max2 + arr[i]);
		}
		
		return ans;
	}
	
		public ResultClass getMaxTripletWithIndex(int[] arr){
		int n = arr.length;
	
		int max1=0, max2=0;
		int tempFirst =0, tempMid = 0, tempLast = 0;
		for(int i = 1; i < n-1; i++){
			
			tempMid = i;
			for(int j = 0; j < i; j++)
				if(arr[j] < arr[i])
					if(arr[j] > max1)
					{
						max1 = arr[j];
						tempFirst = j;
					}
					
				
			for(int j = i+1 ; j < n; j++)
				if(arr[j] > arr[i])
					if(arr[j] > max2)
					{
						max2 = arr[j];
						tempLast = j;
					}

			if(ans < (max1 + max2 + arr[i]) )
			{
				ans = max1 + max2 + arr[i];
				first = tempFirst;
				mid = tempMid;
				last = tempLast;
			}
			
		}
		
		return new ResultClass(ans,first,mid,last);
	}
	
}

class ResultClass{
	int ans,first,mid,last;
	ResultClass(int ans, int first, int mid, int last){
		this.ans = ans;
		this.first = first;
		this.mid = mid;
		this.last = last;
	}
}