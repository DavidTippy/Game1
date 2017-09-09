import static org.junit.Assert.*;
import org.junit.Test;
import com.javanut.dmt.game1.mapping.MapGenerator;

public class MapGeneratorTest {
	
	@Test
	public void testFindDirection() {
		
		int[][] path = new int[8][8];
		
		path[5][7] = 1;
		
		MapGenerator mg = new MapGenerator();
		
												// right and bottom
		//assertTrue(mg.findDirection(path, 0, 0, 0, 1) == 0b1010);		
	
		
	}

}
