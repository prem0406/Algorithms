class MaxSumMatrix{
public static void main(String args[]){

  int matrix[][] = {
    {   6, -5,  -7,  4, -4 },
    {  -9,  3,  -6,  5,  2 },
    { -10,  4,   7, -6,  3 },
    {  -8,  9,  -3,  3, -7 }
  };
  
  Rectangle maxSumRectangle = new MaxSumMatrix().maxSum(matrix);
  
  System.out.println("Rectangle Sum: " + maxSumRectangle.interiorSum);

  System.out.println("Left Index: " + maxSumRectangle.leftBorderIndex);
  System.out.println("Right Index: " + maxSumRectangle.rightBorderIndex);
  System.out.println("Top Index: " + maxSumRectangle.topBorderIndex);
  System.out.println("Bottom Index: " + maxSumRectangle.bottomBorderIndex);
	System.out.println("Resultant Matrix : ");
	for(int rows = maxSumRectangle.topBorderIndex; rows <= maxSumRectangle.bottomBorderIndex; rows++){
		for(int cols = maxSumRectangle.leftBorderIndex; cols <= maxSumRectangle.rightBorderIndex; cols++)
			System.out.print(matrix[rows][cols]+"  ");
		System.out.println();
	}
}

public Rectangle maxSum(int matrix[][]) {


  int rows = matrix.length;
  int cols = matrix[0].length;

  int runningRowSums[] = new int[rows];


  Rectangle maxRectangle = new Rectangle();


  for (int left = 0; left < cols; left++) {


    for (int i = 0; i < rows; i++) {
        runningRowSums[i] = 0;
    }


    for (int right = left; right < cols; right++) {

   
      for (int i = 0; i < rows; i++) {
        runningRowSums[i] += matrix[i][right];
      }

      /*
        Perform Kadane's algorithm on the running sum array
        so that we can determine the best top and bottom
        bound to choose for the rectangle.
      */
	Kadane kadaneResult = new Kadane();
	kadaneResult.calculateMaxSum(runningRowSums);

      if (kadaneResult.maxSoFar > maxRectangle.interiorSum) {

        maxRectangle.interiorSum = kadaneResult.maxSoFar;
        maxRectangle.leftBorderIndex = left;
        maxRectangle.rightBorderIndex = right;

        maxRectangle.topBorderIndex = kadaneResult.beg;
        maxRectangle.bottomBorderIndex = kadaneResult.end;
      }

    }

  }

  return maxRectangle;
}



}



class Rectangle {

  int interiorSum;

  int leftBorderIndex;
  int rightBorderIndex;
  int topBorderIndex;
  int bottomBorderIndex;

}