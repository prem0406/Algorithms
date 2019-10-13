/*
*Objective: to find subarray which has maximum sum.
 use Kadane.calculateMaxSum(int[]) (means create and object the call this 
 method because this is not a static method) by passing an array. Kadane.maxSorFar
*Kadane.beg  is the begining index
*Kadane.end  is the ending index of sub array
*/
class Kadane {

    int maxSoFar;
    int maxEndingHere;
    int beg,end,newBeg;

public int getOnlyMaxSum(int[] nums) {

    maxSoFar = nums[0];
    maxEndingHere = nums[0];



    for (int i = 1; i < nums.length; i++){


      maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);

      maxSoFar = Math.max(maxSoFar, maxEndingHere);  
    }

    return maxSoFar;
  }

/*
maxSubArrayReturn() is form of Kadane Algorithm but it found most efficient.
As it is also aplicable for Arrays comprises of only negative numbers
*/


public void calculateMaxSum(int[] nums) {

 	maxSoFar = nums[0];
    	maxEndingHere = nums[0];
    	beg=0;end=0;newBeg=0;



    for (int i = 1; i < nums.length; i++){

	if( (maxEndingHere+nums[i]) > nums[i] )
	{
		maxEndingHere+= nums[i];
	}
	else
	{
		maxEndingHere = nums[i];
		newBeg=i;
	}
	
	if( maxSoFar > maxEndingHere )
	{
	}	
	else
	{
		maxSoFar= maxEndingHere;
		end=i;
		beg= newBeg;
	} 
    }
	

  }

/*
the below algorithms is taken from "Back to Back SWE" youtube channel
however it is not suitable for arrays contains all negative numbers
*/

public void kadaneBacktoBackSWE(int arr[]) {


  maxSoFar = 0;				
  maxEndingHere = 0;

  beg = -1;
  end = -1;
  newBeg = 0;



  for (int i = 0; i < arr.length; i++) {


    maxEndingHere += arr[i];


    if (maxEndingHere < 0) {
      maxEndingHere = 0;
      newBeg = i + 1;
    }


    if (maxEndingHere > maxSoFar) {
      beg = newBeg;
      end = i;
     maxSoFar = maxEndingHere ;
    }

  }


}
}