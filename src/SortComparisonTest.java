import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.File;
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
		Insertion sort has the biggest difference between best and worst case performance when analysing the input
		size of 1000, with a difference of 475,534 nanoseconds. The best case for insertion sort is an already sorted array whereas worst case is when elements
		in the array are in reversed order. 
	
	c. Which algorithm has the best/worst scalability, i.e., the difference in performance time
	based on the input size? Please consider only input files with random order for this answer.
		Mergesort Recursive has the best scalability due to the fact that when input size increases there isnt a massive
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
    public static void main(String[] args)
    {
    }
}

