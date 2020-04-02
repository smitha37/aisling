import java.io.File;
import java.util.Scanner;

/*
 * A Contest to Meet (ACM) is a reality TV contest that sets three contestants at three random
 * city intersections. In order to win, the three contestants need all to meet at any intersection
 * of the city as fast as possible.
 * It should be clear that the contestants may arrive at the intersections at different times, in
 * which case, the first to arrive can wait until the others arrive.
 * From an estimated walking speed for each one of the three contestants, ACM wants to determine the
 * minimum time that a live TV broadcast should last to cover their journey regardless of the contestants’
 * initial positions and the intersection they finally meet. You are hired to help ACM answer this question.
 * You may assume the following:
 *     Each contestant walks at a given estimated speed.
 *     The city is a collection of intersections in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 *
 * This class implements the competition using Floyd-Warshall algorithm
 */

public class CompetitionFloydWarshall {
	public String fileName;
	public int speedA;
	public int speedB;
	public int speedC;
	public double distanceTo[][];
	public int edgeTo[][];
	public int edgeCount;

    /**
     * @param filename: A filename containing the details of the city road network
     * @param sA, sB, sC: speeds for 3 contestants
     */
    CompetitionFloydWarshall (String filename, int sA, int sB, int sC)
    {
       	this.speedA = sA;
    	this.speedB = sB;
    	this.speedC = sC;
    	
    	try
    	{
    	File inputFile = new File(filename);
    	Scanner inputScanner = new Scanner(inputFile);
    	int i = 0;
    	
    	while(inputScanner.hasNextLine())
    	{
    		String [] line = inputScanner.nextLine().trim().split("\\s+");
    		
    		if(i == 0)
    		{
    			distanceTo = new double[Integer.parseInt(line[i])][Integer.parseInt(line[i])];
    			edgeTo = new int[Integer.parseInt(line[i])][Integer.parseInt(line[i])];
    			for(int a = 0; a < distanceTo.length; a++)
    			{
    				for(int b = 0; b < distanceTo[a].length; b++)
    				{
    					distanceTo[a][b] = Integer.MAX_VALUE;
    					if(a == b)
    					{
    						distanceTo[a][b] = 0;
    					}
    				}
    			}	
    		}
    		else if (i == 1)
    		{
    			edgeCount = Integer.parseInt(line[i - 1]);
    		}
    		else
    		{
    			distanceTo[Integer.parseInt(line[0])][Integer.parseInt(line[1])] = Double.parseDouble(line[2]);
    			edgeTo[Integer.parseInt(line[0])][Integer.parseInt(line[1])] = Integer.parseInt(line[0]);
    		}
    		i++;
    	}
    	inputScanner.close();
    	}
    	catch(Exception x)
    	{
    		distanceTo = new double[0][0];
    		edgeTo = new int[0][0];
    		return;
    	}
    	//Floyd Warshall Shortest Path
    	for(int k = 0; k < distanceTo.length; k++)
    	{
    		for(int i = 0; i < distanceTo.length; i++ )
    		{
    			for(int j = 0; j < distanceTo.length; j++)
    			{
    				if(distanceTo[i][k] + distanceTo[k][j] < distanceTo[i][j])
    				{
    					distanceTo[i][j] = distanceTo[i][k] + distanceTo[k][j];
    					edgeTo[i][j] = k;
    				}
    			}
    		}
    	}
    }

    
    /**
     * @return int: minimum minutes that will pass before the three contestants can meet
     */
    public int timeRequiredforCompetition()
    {
    	if ((speedA > 100 || speedA < 50) || (speedB > 100 || speedB < 50) || (speedC > 100 || speedC < 50))
    	{
		return -1;
    	}
    	int minimumSpeed = Math.min(speedC, Math.min(speedA, speedB));
    	double maximumDistance = 0.0;
    	
    	for(int i = 0; i < distanceTo.length; i++)
    	{
    		for(int j = 0; j < distanceTo[i].length; j++)
    		{
    			if(distanceTo[i][j] == Integer.MAX_VALUE)
    			{
    				return -1;
    			}
    			else if(distanceTo[i][j] > maximumDistance)
    			{
    				maximumDistance = distanceTo[i][j];
    			}
    		}
    	}
    	int maximumTime = (int)Math.ceil((maximumDistance * 1000)/minimumSpeed);
    	if(minimumSpeed <= 0 || maximumDistance == 0)
    	{
    		return -1;
    	}
        return maximumTime;
    }
}
