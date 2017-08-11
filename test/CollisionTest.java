import static org.junit.Assert.*;

import org.junit.Test;

import com.javanut.dmt.game1.entities.Player;
import com.javanut.dmt.game1.physics.Collision;
import com.javanut.dmt.game1.solids.Block;

public class CollisionTest {
	
	@Test
	public void testCollisionRight() {
		
		Player p = new Player();
		Block b = new Block(256,224,1);
		
		Collision myCollision = new Collision(p,b);
		
		assertTrue(myCollision.isRightCollision());				
		assertTrue(myCollision.isLeftCollision());	
		assertTrue(myCollision.isTopCollision());	
		assertTrue(myCollision.isBottomCollision());	
	}

}
