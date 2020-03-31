import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

public class CompetitionTests {
	
	@Test
    public void testDijkstraConstructor() 
	{
		CompetitionDijkstra map;
		String fileName = "tinyEWD.txt";
		int sA = 50;
		int sB = 70;
		int sC = 60;
		map = new CompetitionDijkstra(fileName,sA,sB,sC);
		assertEquals(38,map.timeRequiredforCompetition());
    }
	@Test
    public void testFWConstructor() 
	{
       
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
    	
    }
}
