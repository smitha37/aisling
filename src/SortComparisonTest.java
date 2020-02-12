import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author
 *  @version HT 2020
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
    
    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args)
    {
        //TODO: implement this method
    }

}
