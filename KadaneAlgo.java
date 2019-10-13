public class KadaneAlgo {


	public static void main(String args[])
	{
		int arr[]={-2,-1,-3,-4,-1,-2,-1,-5,-4};
		//int arr[]={-2,1,-3,4,-1,2,1,-5,4};
		//int arr[]={6,-9,-10,-8};
		//int sum= new Algo().maxSubArray(arr);
		//int sum= new Algo().maxSubArrayReturn(arr);
	

		Algo A = new Algo();
		/*A.kadane(arr);
		System.out.println("\nMax Sum is: "+A.maxSoFar);
		for(int i=A.beg ; i<=A.end ;i++)
			System.out.println(arr[i]+" ");
		*/
		A.maxSubArrayReturn(arr);
		System.out.println("\nMax Sum is: "+A.maxSoFar);
		for(int i=A.beg ; i<=A.end ;i++)
			System.out.println(arr[i]+" ");
		
	}

}

class Algo {

    int maxSoFar;
    int maxEndingHere;
    int beg,end,newBeg;

public int maxSubArray(int[] nums) {

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


public void maxSubArrayReturn(int[] nums) {

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
	
/*	for(int i=beg ; i<=end ;i++)
		System.out.println(nums[i]+" ");

    return maxSoFar;
*/
  }

public void kadane(int arr[]) {


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