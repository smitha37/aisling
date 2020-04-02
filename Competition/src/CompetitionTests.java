import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CompetitionTests {
	
	@Test
    public void testDijkstraConstructor() 
	{
		CompetitionDijkstra map;
		String fileName = "tinyEWD.txt";
		int sA = 50;
		int sB = 80;
		int sC = 60;
		map = new CompetitionDijkstra(fileName,sA,sB,sC);
		assertEquals(38,map.timeRequiredforCompetition());
    }
	@Test
    public void testFWConstructor() 
	{
       CompetitionFloydWarshall map;
       String fileName = "tinyEWD.txt";
       int sA = 50;
       int sB = 80;
       int sC = 60;
       map = new CompetitionFloydWarshall(fileName,sA,sB,sC);
       assertEquals(38,map.timeRequiredforCompetition());
    }
	@Test
	public void testDijkstraFilenameError()
	{
		CompetitionDijkstra map;
		String fileName = "numbers.txt";
		int sA = 50;
		int sB = 70;
		int sC = 60;
		map = new CompetitionDijkstra(fileName,sA,sB,sC);
	}
	@Test
	public void testFloydWarshallFilenameError()
	{
		CompetitionFloydWarshall map;
		String fileName = "numbers.txt";
		int sA = 50;
		int sB = 60;
		int sC = 80;
		map = new CompetitionFloydWarshall(fileName,sA,sB,sC);
	}
    @Test 
    public void testDijkstraForNegativeSpeed()
    {
    	CompetitionDijkstra map;
		String fileName = "tinyEWD.txt";
		int sA = 0;
		int sB = 70;
		int sC = 60;
		map = new CompetitionDijkstra(fileName,sA,sB,sC);
		assertEquals(-1,map.timeRequiredforCompetition());
		sA = -4;
		sB = -7;
		sC = -2;
		map = new CompetitionDijkstra(fileName,sA,sB,sC);
		assertEquals(-1,map.timeRequiredforCompetition());
    }
    @Test 
    public void testFloydWarshallForNegativeSpeed()
    {
    	CompetitionFloydWarshall map;
		String fileName = "tinyEWD.txt";
		int sA = 0;
		int sB = 70;
		int sC = 60;
		map = new CompetitionFloydWarshall(fileName,sA,sB,sC);
		assertEquals(-1,map.timeRequiredforCompetition());
		sA = -4;
		sB = -7;
		sC = -2;
		map = new CompetitionFloydWarshall(fileName,sA,sB,sC);
		assertEquals(-1,map.timeRequiredforCompetition());
    }
    @Test
    public void testSpeedARequirements()
    {
    	CompetitionDijkstra mapD;
    	CompetitionFloydWarshall mapFW;
    	String fileName = "tinyEWD.txt";
    	int sA = 40;
    	int sB = 60;
    	int sC = 80;
    	mapD = new CompetitionDijkstra(fileName,sA,sB,sC);
    	mapFW = new CompetitionFloydWarshall(fileName,sA,sB,sC);
    	assertEquals(-1,mapD.timeRequiredforCompetition());
    	assertEquals(-1,mapFW.timeRequiredforCompetition());
    	sA = 110;
    	mapD = new CompetitionDijkstra(fileName,sA,sB,sC);
    	mapFW = new CompetitionFloydWarshall(fileName,sA,sB,sC);
    	assertEquals(-1,mapD.timeRequiredforCompetition());
    	assertEquals(-1,mapFW.timeRequiredforCompetition());
    }
    @Test
    public void testSpeedBRequirements()
    {
    	CompetitionDijkstra mapD;
    	CompetitionFloydWarshall mapFW;
    	String fileName = "tinyEWD.txt";
    	int sA = 60;
    	int sB = 40;
    	int sC = 80;
    	mapD = new CompetitionDijkstra(fileName,sA,sB,sC);
    	mapFW = new CompetitionFloydWarshall(fileName,sA,sB,sC);
    	assertEquals(-1,mapD.timeRequiredforCompetition());
    	assertEquals(-1,mapFW.timeRequiredforCompetition());
    	sB = 110;
    	mapD = new CompetitionDijkstra(fileName,sA,sB,sC);
    	mapFW = new CompetitionFloydWarshall(fileName,sA,sB,sC);
    	assertEquals(-1,mapD.timeRequiredforCompetition());
    	assertEquals(-1,mapFW.timeRequiredforCompetition());
    }
    @Test
    public void testSpeedCRequirements()
    {
    	CompetitionDijkstra mapD;
    	CompetitionFloydWarshall mapFW;
    	String fileName = "tinyEWD.txt";
    	int sA = 60;
    	int sB = 50;
    	int sC = 40;
    	mapD = new CompetitionDijkstra(fileName,sA,sB,sC);
    	mapFW = new CompetitionFloydWarshall(fileName,sA,sB,sC);
    	assertEquals(-1,mapD.timeRequiredforCompetition());
    	assertEquals(-1,mapFW.timeRequiredforCompetition());
    	sC = 110;
    	mapD = new CompetitionDijkstra(fileName,sA,sB,sC);
    	mapFW = new CompetitionFloydWarshall(fileName,sA,sB,sC);
    	assertEquals(-1,mapD.timeRequiredforCompetition());
    	assertEquals(-1,mapFW.timeRequiredforCompetition());
    }
    @Test
    public void testInputA()
    {
    	CompetitionDijkstra mapD;
    	CompetitionFloydWarshall mapFW;
    	String fileName = "input-A.txt";
    	int sA = 50;
    	int sB = 60;
    	int sC = 80;
    	mapD = new CompetitionDijkstra(fileName,sA,sB,sC);
    	mapFW = new CompetitionFloydWarshall(fileName,sA,sB,sC);
    }
    @Test
    public void testInputB()
    {
    	CompetitionDijkstra mapD;
    	CompetitionFloydWarshall mapFW;
    	String fileName = "input-B.txt";
    	int sA = 50;
    	int sB = 60;
    	int sC = 80;
    	mapD = new CompetitionDijkstra(fileName,sA,sB,sC);
    	mapFW = new CompetitionFloydWarshall(fileName,sA,sB,sC);
    	assertEquals(10000, mapD.timeRequiredforCompetition());
    	assertEquals(10000,mapFW.timeRequiredforCompetition());
    }
    @Test
    public void testInputC()
    {
    	CompetitionDijkstra mapD;
    	CompetitionFloydWarshall mapFW;
    	String fileName = "input-C.txt";
    	int sA = 50;
    	int sB = 60;
    	int sC = 80;
    	mapD = new CompetitionDijkstra(fileName,sA,sB,sC);
    	mapFW = new CompetitionFloydWarshall(fileName,sA,sB,sC);
    }
    @Test
    public void testInputD()
    {
    	CompetitionDijkstra mapD;
    	CompetitionFloydWarshall mapFW;
    	String fileName = "input-D.txt";
    	int sA = 50;
    	int sB = 60;
    	int sC = 80;
    	mapD = new CompetitionDijkstra(fileName,sA,sB,sC);
    	mapFW = new CompetitionFloydWarshall(fileName,sA,sB,sC);
    }
    /*@Test failed to run on webcat as not enough space
    public void testInputE()
    {
    	CompetitionDijkstra mapD;
    	CompetitionFloydWarshall mapFW;
    	String fileName = "input-E.txt";
    	int sA = 50;
    	int sB = 60;
    	int sC = 80;
    	mapD = new CompetitionDijkstra(fileName,sA,sB,sC);
    	mapFW = new CompetitionFloydWarshall(fileName,sA,sB,sC);
    }*/
    @Test
    public void testInputF()
    {
    	CompetitionDijkstra mapD;
    	CompetitionFloydWarshall mapFW;
    	String fileName = "input-F.txt";
    	int sA = 50;
    	int sB = 60;
    	int sC = 80;
    	mapD = new CompetitionDijkstra(fileName,sA,sB,sC);
    	mapFW = new CompetitionFloydWarshall(fileName,sA,sB,sC);
    }
    @Test
    public void testInputG()
    {
    	CompetitionDijkstra mapD;
    	CompetitionFloydWarshall mapFW;
    	String fileName = "input-G.txt";
    	int sA = 50;
    	int sB = 60;
    	int sC = 80;
    	mapD = new CompetitionDijkstra(fileName,sA,sB,sC);
    	mapFW = new CompetitionFloydWarshall(fileName,sA,sB,sC);
    }
    /*@Test  failed as not enough Java Heap Space on my laptop
    public void testInputH()
    {
    	CompetitionDijkstra mapD;
    	CompetitionFloydWarshall mapFW;
    	String fileName = "input-H.txt";
    	int sA = 50;
    	int sB = 60;
    	int sC = 80;
    	mapD = new CompetitionDijkstra(fileName,sA,sB,sC);
    	mapFW = new CompetitionFloydWarshall(fileName,sA,sB,sC);
    }*/
    @Test
    public void testInputI()
    {
    	CompetitionDijkstra mapD;
    	CompetitionFloydWarshall mapFW;
    	String fileName = "input-I.txt";
    	int sA = 50;
    	int sB = 60;
    	int sC = 80;
    	mapD = new CompetitionDijkstra(fileName,sA,sB,sC);
    	mapFW = new CompetitionFloydWarshall(fileName,sA,sB,sC);
    }
    @Test
    public void testInputJ()
    {
    	CompetitionDijkstra mapD;
    	CompetitionFloydWarshall mapFW;
    	String fileName = "input-J.txt";
    	int sA = 50;
    	int sB = 60;
    	int sC = 80;
    	mapD = new CompetitionDijkstra(fileName,sA,sB,sC);
    	mapFW = new CompetitionFloydWarshall(fileName,sA,sB,sC);
    	assertEquals(-1,mapD.timeRequiredforCompetition());
    	assertEquals(-1,mapFW.timeRequiredforCompetition());
    }
    @Test
    public void testInputK()
    {
    	CompetitionDijkstra mapD;
    	CompetitionFloydWarshall mapFW;
    	String fileName = "input-K.txt";
    	int sA = 50;
    	int sB = 60;
    	int sC = 80;
    	mapD = new CompetitionDijkstra(fileName,sA,sB,sC);
    	mapFW = new CompetitionFloydWarshall(fileName,sA,sB,sC);
    }
    @Test
    public void testInputL()
    {
    	CompetitionDijkstra mapD;
    	CompetitionFloydWarshall mapFW;
    	String fileName = "input-L.txt";
    	int sA = 50;
    	int sB = 60;
    	int sC = 80;
    	mapD = new CompetitionDijkstra(fileName,sA,sB,sC);
    	mapFW = new CompetitionFloydWarshall(fileName,sA,sB,sC);
    }
    @Test
    public void testInputM()
    {
    	CompetitionDijkstra mapD;
    	CompetitionFloydWarshall mapFW;
    	String fileName = "input-M.txt";
    	int sA = 50;
    	int sB = 60;
    	int sC = 80;
    	mapD = new CompetitionDijkstra(fileName,sA,sB,sC);
    	mapFW = new CompetitionFloydWarshall(fileName,sA,sB,sC);
    }
    @Test
    public void testInputN()
    {
    	CompetitionDijkstra mapD;
    	CompetitionFloydWarshall mapFW;
    	String fileName = "input-N.txt";
    	int sA = 50;
    	int sB = 60;
    	int sC = 80;
    	mapD = new CompetitionDijkstra(fileName,sA,sB,sC);
    	mapFW = new CompetitionFloydWarshall(fileName,sA,sB,sC);
    }
}
