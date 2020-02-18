import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
		 recursiveQuick(a,0,(a.length-1));
		 return a;
		 }
	 }
	 public static void recursiveQuick(double a[], int low, int high)
	 {
		 int pivotPosition = partition(a,low,high);
		 if(low < (pivotPosition -1))
		 {
			recursiveQuick(a, low , (pivotPosition-1)); 
		 }
		 if(high > pivotPosition)
		 {
		 recursiveQuick(a, pivotPosition, high);
		 }
	 }
	 private static int partition(double a[], int low, int high)
	 {
		 double pivotElement = a[low];

		 while(low <= high)
		 {
			 while(a[low] < pivotElement)
			 {
				 low++;
			 }
			 while(a[high] > pivotElement)
			 {
				 high--;
			 }
			 if(low <= high) 
			 {
				 double temporary = a[low];
				 a[low] = a[high];
				 a[high] = temporary;
				 
				 low++;
				 high--;
			 } 
		 }
		 return low;
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
    	int middle = low + (high - low)/2;
    	sort(a,tempArray,low,middle);
    	sort(a,tempArray,(middle+1),high);
    	merge(a,tempArray,low,middle,high);
    }
    private static void merge(double[]a, double[] tempArray, int low, int middle, int high)
    {
    	for(int k = low; k <= high; k++)
    	{
    		tempArray[k] = a[k];
    	}
    	int i = low;
    	int j = middle+1;
    	
    	for(int k = low; k <= high; k++)
    	{
    		if(i > middle)
    		{
    			a[k]= tempArray[j++];
    		}
    		else if(j > high)
    		{
    			a[k] = tempArray[i++];
    		}
    		else if(tempArray[j] < tempArray[i])
    		{
    			a[k] = tempArray[j++];
    		}
    		else
    		{
    			a[k] = tempArray[i++];
    		}
    	}
    }
    	
    public static void main(String[] args) throws FileNotFoundException {

    	   double[] i_10 = new double[10];
           double[] i_100 = new double[100];
           double[] i_1000 = new double[1000];
           double[] i_1000D = new double[1000];
           double[] i_1000NO = new double[1000];
           double[] i_1000R = new double[1000];
           double[] i_1000S = new double[1000];
           
           double[] s_10 = new double[10];
           double[] s_100 = new double[100];
           double[] s_1000 = new double[1000];
           double[] s_1000D = new double[1000];
           double[] s_1000NO = new double[1000];
           double[] s_1000R = new double[1000];
           double[] s_1000S = new double[1000];
           
           double[] q_10 = new double[10];
           double[] q_100 = new double[100];
           double[] q_1000 = new double[1000];
           double[] q_1000D = new double[1000];
           double[] q_1000NO = new double[1000];
           double[] q_1000R = new double[1000];
           double[] q_1000S = new double[1000];
           
           double[] mi_10 = new double[10];
           double[] mi_100 = new double[100];
           double[] mi_1000 = new double[1000];
           double[] mi_1000D = new double[1000];
           double[] mi_1000NO = new double[1000];
           double[] mi_1000R = new double[1000];
           double[] mi_1000S = new double[1000];
           
           double[] mr_10 = new double[10];
           double[] mr_100 = new double[100];
           double[] mr_1000 = new double[1000];
           double[] mr_1000D = new double[1000];
           double[] mr_1000NO = new double[1000];
           double[] mr_1000R = new double[1000];
           double[] mr_1000S = new double[1000];
           
           
    	 File fileNumbers10 = new File("C:\\Users\\User\\Downloads\\assignment input data files\\numbers10.txt");
         Scanner fileReader = new Scanner(fileNumbers10);
         int i = 0;
         while (fileReader.hasNextDouble())
         {
         	i_10[i] = fileReader.nextDouble();
         	s_10[i] = fileReader.nextDouble();
         	q_10[i] = fileReader.nextDouble();
         	mi_10[i] = fileReader.nextDouble();
         	mr_10[i] = fileReader.nextDouble();
         	i++;
         }
         fileReader.close();
         
         File fileNumbers100 = new File("C:\\Users\\User\\Downloads\\assignment input data files\\numbers100.txt");
         fileReader = new Scanner(fileNumbers100);
         int j = 0;
         while (fileReader.hasNextDouble())
         {
         	i_100[j] = fileReader.nextDouble();
         	s_100[j] = fileReader.nextDouble();
         	q_100[j] = fileReader.nextDouble();
         	mi_100[j] = fileReader.nextDouble();
         	mr_100[j] = fileReader.nextDouble();
         	j++;
         }
         fileReader.close();
         
         File fileNumbers1000 = new File("C:\\Users\\User\\Downloads\\assignment input data files\\numbers1000.txt");
         fileReader = new Scanner(fileNumbers1000);
         int k = 0;
         while (fileReader.hasNextDouble())
         {
         	i_1000[k] = fileReader.nextDouble();
         	s_1000[k] = fileReader.nextDouble();
         	q_1000[k] = fileReader.nextDouble();
         	mi_1000[k] = fileReader.nextDouble();
         	mr_1000[k] = fileReader.nextDouble();
         	k++;
         }
         fileReader.close();
         
         File fileNumbers1000Duplicates = new File("C:\\Users\\User\\Downloads\\assignment input data files\\numbers1000Duplicates.txt");
         fileReader = new Scanner(fileNumbers1000Duplicates);
         int a = 0;
         while (fileReader.hasNextDouble())
         {
         	i_1000D[a] = fileReader.nextDouble();
         	s_1000D[a] = fileReader.nextDouble();
         	q_1000D[a] = fileReader.nextDouble();
         	mi_1000D[a] = fileReader.nextDouble();
         	mr_1000D[a] = fileReader.nextDouble();
         	a++;
         }
         fileReader.close();
         
         File fileNumbers1000NearlyOrdered = new File("C:\\Users\\User\\Downloads\\assignment input data files\\numbersNearlyOrdered1000.txt");
         fileReader = new Scanner(fileNumbers1000NearlyOrdered);
         int b = 0;
         while (fileReader.hasNextDouble())
         {
         	i_1000NO[b] = fileReader.nextDouble();
         	s_1000NO[b] = fileReader.nextDouble();
         	q_1000NO[b] = fileReader.nextDouble();
         	mi_1000NO[b] = fileReader.nextDouble();
         	mr_1000NO[b] = fileReader.nextDouble();
         	b++;
         }
         fileReader.close();
         
         File fileNumbers1000Reverse = new File("C:\\Users\\User\\Downloads\\assignment input data files\\numbersReverse1000.txt");
         fileReader = new Scanner(fileNumbers1000Reverse);
         int c = 0;
         while (fileReader.hasNextDouble())
         {
         	i_1000R[c] = fileReader.nextDouble();
         	s_1000R[c] = fileReader.nextDouble();
         	q_1000R[c] = fileReader.nextDouble();
         	mi_1000R[c] = fileReader.nextDouble();
         	mr_1000R[c] = fileReader.nextDouble();
         	c++;
         }
         fileReader.close();
         
         File fileNumbers1000Sorted = new File("C:\\Users\\User\\Downloads\\assignment input data files\\numbersSorted1000.txt");
         fileReader = new Scanner(fileNumbers1000Sorted);
         int d = 0;
         while (fileReader.hasNextDouble())
         {
         	i_1000S[d] = fileReader.nextDouble();
         	s_1000S[d] = fileReader.nextDouble();
         	q_1000S[d] = fileReader.nextDouble();
         	mi_1000S[d] = fileReader.nextDouble();
         	mr_1000S[d] = fileReader.nextDouble();
         	d++;
         }
         fileReader.close();
         
    }

 }//end class
