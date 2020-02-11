// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author
 *  @version HT 2020
 */

 class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
	 static double [] insertionSort (double a[])
	 {
		 double temporaryElement = 0;

		 for(int firstElement = 1; firstElement < a.length; firstElement++)
		 {
			 for(int lastElement = firstElement; lastElement > 0; lastElement--)
			 {
				 if(a[lastElement] < a[lastElement-1])
				 {
					 temporaryElement = a[lastElement];
					 a[lastElement] = a[lastElement-1];
					 a[lastElement-1] = temporaryElement;
				 }
			 }
		 }
		 return a;
	 }
	    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
	 static double [] selectionSort (double a[])
	 {
		 double numberOfElements = a.length;

		 for(int firstElement = 0; firstElement < (numberOfElements-1); firstElement++)
		 {
			 int min = firstElement;
			 for(int findMin = min + 1; findMin < numberOfElements; findMin++)
			 {
				 if(a[findMin] < a[min])
				 {
					 min = findMin;
				 }
			 }
			 double temporary = a[min];
			 a[min] = a[firstElement];
			 a[firstElement] = temporary;
		 }
		 return a;

	 }

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
	 static double [] quickSort ( double a[])
	 {
		 recursiveQuick(a,0,a.length-1);
		 return a;
	 }
	 public static void recursiveQuick(double a[], int low, int high)
	 {
		 if(high <= low)
		 {
			 return;
		 }
		 int pivotPosition = partition(a,low,high);
		 recursiveQuick(a,low, (pivotPosition-1));
		 recursiveQuick(a, (pivotPosition+1), high);
	 }
	 private static int partition(double a[], int low, int high)
	 {
		 int index1 = low;
		 int index2 = high + 1;
		 double pivotElement = a[low];

		 while(true)
		 {
			 while((a[++index1] > (pivotElement)))
			 {
				 if(index1 == high) break;
			 }
			 while((pivotElement < (a[--index2])))
			 {
				 if(index2 == low) break;
			 }
			 if(index1 >= index2) break;

			 double temporary = a[index1];
			 a[index1] = a[index2];
			 a[index2] = temporary;
		 }
		 a[low] = a[index2];
		 a[index2] = pivotElement;
		 return index2;
	 }

    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSortIterative (double a[]) {

		 //todo: implement the sort
	
    }//end mergesortIterative
    
    
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[]) {
    	

    	//todo: implement the sort
	
   }//end mergeSortRecursive
    	
    


   


    public static void main(String[] args) {

        //todo: do experiments as per assignment instructions
    }

 }//end class
