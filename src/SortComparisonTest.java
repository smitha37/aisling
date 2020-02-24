import static org.junit.Assert.*;

import java.io.File;
//import static org.junit.jupiter.api.Assertions.assertNull;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author
 *  @version HT 2020
 *  
 *  Average Running Time in Nanoseconds
 *  								Insertion		Selection		Quick		Merge Iterative		Merge Recursive
 *  						
 *  10 numbers						8,066			10,033			18,466			105,500				16,200	
 *  100 numbers						240,666			145,233			39,100			89,066				68,066
 *  1000 numbers					4,844,200		4,855,566		364,833			246,666				332,466
 *  1000 number duplicate			1,768,233		3,812,400		134,766			234,066				137,133
 *  1000 numbers nearly ordered		2,374,566		2,495,866		94,766			198,133				74,166
 *  1000 numbers reversed			1,340,100		2,752,300		228,866			117,900				63,633
 *  1000 numbers sorted				864,566			2,361,666		56,100			110,033				95,400
 *  
 *  a. Which of the sorting algorithms does the order of input have an impact on? Why?
		Insertion sort is impacted by the order of input. Insertion sorts worst case is when the elements in the array are
		sorted in reverse order. Although this change is only slightly seen in our test, it is clear that the order of
		input has an effect on insertion sort.
		
	b. Which algorithm has the biggest difference between the best and worst performance, based
	on the type of input, for the input of size 1000? Why?
		Insertion sort has the biggest difference between best and worst case performance when analysing the input size of 1000, 
		with a difference of 475,534 nanoseconds. The best case for insertion sort is an already sorted array whereas worst case 
		is when elements in the array are in reversed order. 
	
	c. Which algorithm has the best/worst scalability, i.e., the difference in performance time
	based on the input size? Please consider only input files with random order for this answer.
		Mergesort Recursive has the best scalability due to the fact that when input size increases there isn't a massive
		increase in performance time. However, compared to selection sort where when input size increases there is an
		extremely large increase in performance time. Therefore, selection sort seems to have the worst scalability.
	
	d. Did you observe any difference between iterative and recursive implementations of merge
	sort?
		Mergesort Recursive was much quicker than mergesort iterative in most cases as it uses recursive methods rather
		than iterating through arrays.
	
	e. Which algorithm is the fastest for each of the 7 input files?
		Mergesort Recursive was the algorithm which was the fastest for all 7 input files when considered together. 
		 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
	private static final double DELTA = 1e-15;
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
    }


    // TODO: add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.
    @Test
    public void testInsertionSortisEmpty()
    {
    	double[] a = null;
    	assertNull(SortComparison.insertionSort(a));	
    }
    @Test
    public void testInsertionSort()
    {
    	double a[] = {0.3 , 1.0 , 0.1 , 4.0 , 2.0};
    	double aSorted[] = {0.1,0.3,1.0,2.0,4.0};
    	double aNegative[] = {-0.6, -0.2, -2.0, -1.5, -3.0, 1.4};
    	double aNegativeSorted[] = {-3.0, -2.0, -1.5, -0.6, -0.2, 1.4};
    	double aSingle[] = {0.23};
    	double aSingleSorted[] = {0.23};
    	double b[] = SortComparison.insertionSort(a);
    	double bNegative[] = SortComparison.insertionSort(aNegative);
    	double bSingle[] = SortComparison.insertionSort(aSingle);
    	assertArrayEquals(b,aSorted, DELTA);
    	assertArrayEquals(bNegative,aNegativeSorted,DELTA);
    	assertArrayEquals(bSingle,aSingleSorted,DELTA);
    }
    @Test
    public void testSelectionSortisEmpty()
    {
    	double[] a = null;
    	assertNull(SortComparison.selectionSort(a));	
    }
    @Test
    public void testSelectionSort()
    {
    	double a[] = {0.3 , 1.0 , 0.1 , 4.0 , 2.0};
    	double aSorted[] = {0.1,0.3,1.0,2.0,4.0};
    	double aNegative[] = {-0.6, -0.2, -2.0, -1.5, -3.0, 1.4};
    	double aNegativeSorted[] = {-3.0, -2.0, -1.5, -0.6, -0.2, 1.4};
    	double aSingle[] = {0.23};
    	double aSingleSorted[] = {0.23};
    	double b[] = SortComparison.selectionSort(a);
    	double bNegative[] = SortComparison.selectionSort(aNegative);
    	double bSingle[] = SortComparison.selectionSort(aSingle);
    	assertArrayEquals(b,aSorted, DELTA);
    	assertArrayEquals(bNegative,aNegativeSorted,DELTA);
    	assertArrayEquals(bSingle,aSingleSorted,DELTA);
    }
    @Test
    public void testQuickSortisEmpty()
    {
    	double[] a = null;
    	assertNull(SortComparison.quickSort(a));	
    }
    @Test
    public void testQuickSort()
    {
    	double a[] = {0.3 , 1.0 , 0.1 , 4.0 , 2.0};
    	double aSorted[] = {0.1,0.3,1.0,2.0,4.0};
    	double aNegative[] = {-0.6, -0.2, -2.0, -1.5, -3.0, 1.4};
    	double aNegativeSorted[] = {-3.0, -2.0, -1.5, -0.6, -0.2, 1.4};
    	double aSingle[] = {0.23};
    	double aSingleSorted[] = {0.23};
    	double b[] = SortComparison.quickSort(a);
    	double bNegative[] = SortComparison.quickSort(aNegative);
    	double bSingle[] = SortComparison.quickSort(aSingle);
    	assertArrayEquals(b,aSorted, DELTA);
    	assertArrayEquals(bNegative,aNegativeSorted,DELTA);
    	assertArrayEquals(bSingle,aSingleSorted,DELTA);
    }
    @Test
    public void testMergeSortIterativeisEmpty()
    {
    	double[] a = null;
    	assertNull(SortComparison.mergeSortIterative(a));	
    }
    @Test
    public void testMergeIterativeSort()
    {
    	double a[] = {0.3 , 1.0 , 0.1 , 4.0 , 2.0};
    	double aSorted[] = {0.1,0.3,1.0,2.0,4.0};
    	double aNegative[] = {-0.6, -0.2, -2.0, -1.5, -3.0, 1.4};
    	double aNegativeSorted[] = {-3.0, -2.0, -1.5, -0.6, -0.2, 1.4};
    	double aSingle[] = {0.23};
    	double aSingleSorted[] = {0.23};
    	double b[] = SortComparison.mergeSortIterative(a);
    	double bNegative[] = SortComparison.mergeSortIterative(aNegative);
    	double bSingle[] = SortComparison.mergeSortIterative(aSingle);
    	assertArrayEquals(b,aSorted, DELTA);
    	assertArrayEquals(bNegative,aNegativeSorted,DELTA);
    	assertArrayEquals(bSingle,aSingleSorted,DELTA);
    }
    @Test
    public void testMergeSortRecursiveisEmpty()
    {
    	double[] a = null;
    	assertNull(SortComparison.mergeSortRecursive(a));	
    }
    @Test
    public void testMergeSortRecursive()
    {
    	double a[] = {0.3 , 1.0 , 0.1 , 4.0 , 2.0};
    	double aSorted[] = {0.1,0.3,1.0,2.0,4.0};
    	double aNegative[] = {-0.6, -0.2, -2.0, -1.5, -3.0, 1.4};
    	double aNegativeSorted[] = {-3.0, -2.0, -1.5, -0.6, -0.2, 1.4};
    	double aSingle[] = {0.23};
    	double aSingleSorted[] = {0.23};
    	double b[] = SortComparison.mergeSortRecursive(a);
    	double bNegative[] = SortComparison.mergeSortRecursive(aNegative);
    	double bSingle[] = SortComparison.mergeSortRecursive(aSingle);
    	assertArrayEquals(b,aSorted, DELTA);
    	assertArrayEquals(bNegative,aNegativeSorted,DELTA);
    	assertArrayEquals(bSingle,aSingleSorted,DELTA);
    }
    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     * @throws FileNotFoundException 
     *
     */
    public static void main(String[] args) throws FileNotFoundException
    {
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
         
         
  	 File fileNumbers10 = new File("numbers10.txt");
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
       
       File fileNumbers100 = new File("numbers100.txt");
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
       
       File fileNumbers1000 = new File("numbers1000.txt");
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
       
       File fileNumbers1000Duplicates = new File("numbers1000Duplicates.txt");
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
       
       File fileNumbers1000NearlyOrdered = new File("numbersNearlyOrdered1000.txt");
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
       
       File fileNumbers1000Reverse = new File("numbersReverse1000.txt");
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
       
       File fileNumbers1000Sorted = new File("numbersSorted1000.txt");
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
       
       double start = 0;
       double end = 0;
       double difference = 0;
       
       System.out.print("Array Size 10 For Insertion Sort: ");
       start = System.nanoTime();
       SortComparison.insertionSort(i_10);
       end = System.nanoTime();
       difference = end - start;
       System.out.print(difference);
       
       System.out.print("\nArray Size 10 For Selection Sort: ");
       start = System.nanoTime();
       SortComparison.selectionSort(s_10);
       end = System.nanoTime();
       difference = end - start;
       System.out.println(difference);
       
       System.out.print("Array Size 10 For Quick Sort: ");
       start = System.nanoTime();
       SortComparison.quickSort(q_10);
       end = System.nanoTime();
       difference = end - start;
       System.out.println(difference);
       
       System.out.print("Array Size 10 For Merge Sort Iterative: ");
       start = System.nanoTime();
       SortComparison.mergeSortIterative(mi_10);
       end = System.nanoTime();
       difference = end - start;
       System.out.println(difference);
       
       System.out.print("Array Size 10 For Merge Sort Recursive: ");
       start = System.nanoTime();
       SortComparison.mergeSortRecursive(mr_10);
       end = System.nanoTime();
       difference = end - start;
       System.out.println(difference);
       
       System.out.print("\nArray Size 100 For Insertion Sort: ");
       start = System.nanoTime();
       SortComparison.insertionSort(i_100);
       end = System.nanoTime();
       difference = end - start;
       System.out.println(difference);
       
       System.out.print("Array Size 100 For Selection Sort: ");
       start = System.nanoTime();
       SortComparison.selectionSort(s_100);
       end = System.nanoTime();
       difference = end - start;
       System.out.println(difference);
       
       System.out.print("Array Size 100 For Quick Sort: ");
       start = System.nanoTime();
       SortComparison.quickSort(q_100);
       end = System.nanoTime();
       difference = end - start;
       System.out.println(difference);
       
       System.out.print("Array Size 100 For Merge Sort Iterative: ");
       start = System.nanoTime();
       SortComparison.mergeSortIterative(mi_100);
       end = System.nanoTime();
       difference = end - start;
       System.out.println(difference);
       
       System.out.print("Array Size 100 For Merge Sort Recursive: ");
       start = System.nanoTime();
       SortComparison.mergeSortRecursive(mr_100);
       end = System.nanoTime();
       difference = end - start;
       System.out.println(difference);
       
       System.out.print("\nArray Size 1000 For Insertion Sort: ");
       start = System.nanoTime();
       SortComparison.insertionSort(i_1000);
       end = System.nanoTime();
       difference = end - start;
       System.out.println(difference);
       
       System.out.print("Array Size 1000 For Selection Sort: ");
       start = System.nanoTime();
       SortComparison.selectionSort(s_1000);
       end = System.nanoTime();
       difference = end - start;
       System.out.println(difference);
       
       System.out.print("Array Size 1000 For Quick Sort: ");
       start = System.nanoTime();
       SortComparison.quickSort(q_1000);
       end = System.nanoTime();
       difference = end - start;
       System.out.println(difference);
       
       System.out.print("Array Size 1000 For Merge Sort Iterative: ");
       start = System.nanoTime();
       SortComparison.mergeSortIterative(mi_1000);
       end = System.nanoTime();
       difference = end - start;
       System.out.println(difference);
       
       System.out.print("Array Size 1000 For Merge Sort Recursive: ");
       start = System.nanoTime();
       SortComparison.mergeSortRecursive(mr_1000);
       end = System.nanoTime();
       difference = end - start;
       System.out.println(difference);
       
       System.out.print("\nArray Size 1000 With Duplicates For Insertion Sort: ");
       start = System.nanoTime();
       SortComparison.insertionSort(i_1000D);
       end = System.nanoTime();
       difference = end - start;
       System.out.println(difference);
       
       System.out.print("Array Size 1000 With Duplicates For Selection Sort: ");
       start = System.nanoTime();
       SortComparison.selectionSort(s_1000D);
       end = System.nanoTime();
       difference = end - start;
       System.out.println(difference);
       
       System.out.print("Array Size 1000 With Duplicates For Quick Sort: ");
       start = System.nanoTime();
       SortComparison.quickSort(q_1000D);
       end = System.nanoTime();
       difference = end - start;
       System.out.println(difference);
       
       System.out.print("Array Size 1000 With Duplicates For Merge Sort Iterative: ");
       start = System.nanoTime();
       SortComparison.mergeSortIterative(mi_1000D);
       end = System.nanoTime();
       difference = end - start;
       System.out.println(difference);
       
       System.out.print("Array Size 1000 With Duplicates For Merge Sort Recursive: ");
       start = System.nanoTime();
       SortComparison.mergeSortRecursive(mr_1000D);
       end = System.nanoTime();
       difference = end - start;
       System.out.println(difference);
       
       System.out.print("\nArray Size 1000 With Nearly Ordered Elements For Insertion Sort: ");
       start = System.nanoTime();
       SortComparison.insertionSort(i_1000NO);
       end = System.nanoTime();
       difference = end - start;
       System.out.println(difference);
       
       System.out.print("Array Size 1000 With Nearly Ordered Elements For Selection Sort: ");
       start = System.nanoTime();
       SortComparison.selectionSort(s_1000NO);
       end = System.nanoTime();
       difference = end - start;
       System.out.println(difference);
       
       System.out.print("Array Size 1000 With Nearly Ordered Elements For Quick Sort: ");
       start = System.nanoTime();
       SortComparison.quickSort(q_1000NO);
       end = System.nanoTime();
       difference = end - start;
       System.out.println(difference);
       
       System.out.print("Array Size 1000 With Nearly Ordered Elements For Merge Sort Iterative: ");
       start = System.nanoTime();
       SortComparison.mergeSortIterative(mi_1000NO);
       end = System.nanoTime();
       difference = end - start;
       System.out.println(difference);
       
       System.out.print("Array Size 1000 With Nearly Ordered Elements For Merge Sort Recursive: ");
       start = System.nanoTime();
       SortComparison.mergeSortRecursive(mr_1000NO);
       end = System.nanoTime();
       difference = end - start;
       System.out.println(difference);
       
       System.out.print("\nArray Size 1000 With Reverse Elements For Insertion Sort: ");
       start = System.nanoTime();
       SortComparison.insertionSort(i_1000R);
       end = System.nanoTime();
       difference = end - start;
       System.out.println(difference);
       
       System.out.print("Array Size 1000 With Reverse Elements For Selection Sort: ");
       start = System.nanoTime();
       SortComparison.selectionSort(s_1000R);
       end = System.nanoTime();
       difference = end - start;
       System.out.println(difference);
       
       System.out.print("Array Size 1000 With Reverse Elements For Quick Sort: ");
       start = System.nanoTime();
       SortComparison.quickSort(q_1000R);
       end = System.nanoTime();
       difference = end - start;
       System.out.println(difference);
       
       System.out.print("Array Size 1000 With Reverse Elements For Merge Sort Iterative: ");
       start = System.nanoTime();
       SortComparison.mergeSortIterative(mi_1000R);
       end = System.nanoTime();
       difference = end - start;
       System.out.println(difference);
       
       System.out.print("Array Size 1000 With Reverse Elements For Merge Sort Recursive: ");
       start = System.nanoTime();
       SortComparison.mergeSortRecursive(mr_1000R);
       end = System.nanoTime();
       difference = end - start;
       System.out.println(difference);
       
       System.out.print("\nArray Size 1000 With Sorted Elements For Insertion Sort: ");
       start = System.nanoTime();
       SortComparison.insertionSort(i_1000S);
       end = System.nanoTime();
       difference = end - start;
       System.out.println(difference);
       
       System.out.print("Array Size 1000 With Sorted Elements For Selection Sort: ");
       start = System.nanoTime();
       SortComparison.selectionSort(s_1000S);
       end = System.nanoTime();
       difference = end - start;
       System.out.println(difference);
       
       System.out.print("Array Size 1000 With Sorted Elements For Quick Sort: ");
       start = System.nanoTime();
       SortComparison.quickSort(q_1000S);
       end = System.nanoTime();
       difference = end - start;
       System.out.println(difference);
       
       System.out.print("Array Size 1000 With Sorted Elements For Merge Sort Iterative: ");
       start = System.nanoTime();
       SortComparison.mergeSortIterative(mi_1000S);
       end = System.nanoTime();
       difference = end - start;
       System.out.println(difference);
       
       System.out.print("Array Size 1000 With Sorted Elements For Merge Sort Recursive: ");
       start = System.nanoTime();
       SortComparison.mergeSortRecursive(mr_1000S);
       end = System.nanoTime();
       difference = end - start;
       System.out.println(difference);
    }
}

