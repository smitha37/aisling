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
		 if(a == null)
		 {
			 return null;
		 }
		 else
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
		 if(a == null)
		 {
			 return null;
		 }
		 else
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
		 if(a == null)
		 {
			 return null;
		 }
		 else
		 {
		 recursiveQuick(a,0,a.length-1);
		 return a;
		 }
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

    static double[] mergeSortIterative (double a[]) 
    {
    	if(a == null)
    	{
    		return null;
    	}
    	else
    	{
    	int length = a.length;
    	double[] tempArray = new double[length];
    	for(int size = 1; size < length; size = size+size)
    		for(int low = 0; low < length-size; low += size+size)
    			merge(a,tempArray,low,low+size-1,Math.min(low+size+size-1,length-1));
    	return a;
    	}
    }
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[]) 
    {
    	if(a == null)
    	{
    		return null;
    	}
    	else
    	{
    	double[] tempArray = new double[a.length];
    	sort(a,tempArray,0,a.length-1);
    	return a;
    	}
   }
    private static void sort(double[]a,double[] tempArray ,int low, int high)
    {
    	if(high <= low)
    	{
    		return;
    	}
    	int middle = low + (high - low) /2;
    	sort(a,tempArray,low,high);
    	sort(a,tempArray,middle+1,high);
    	merge(a,tempArray,low,middle,high);
    }
    private static void merge(double[]a, double[] tempArray, int low, int middle, int high)
    {
    	for(int i = low; i <= high; i++)
    	{
    		tempArray[i] = a[i];
    	}
    	int index = low;
    	int index2 = middle+1;
    	
    	for(int i = low; i <= high; i++)
    	{
    		if(index > middle)
    		{
    			a[i]= tempArray[index2++];
    		}
    		else if(index2 > high)
    		{
    			a[i] = tempArray[index];
    		}
    		else if(tempArray[index2] < tempArray[index])
    		{
    			a[i] = tempArray[index2++];
    		}
    		else
    		{
    			a[i] = tempArray[index++];
    		}
    	}
    }
    	
    public static void main(String[] args) {

        //todo: do experiments as per assignment instructions
    }

 }//end class
