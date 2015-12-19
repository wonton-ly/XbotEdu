package xbot.edubot.rotation;

import org.junit.Test;

public class TurnLeft90DegreesCommandTest extends BaseOrientationEngineTest {
	@Test
	public void goLeft90FromStart()
	{
		run90ClassTest(0, 90);
	}
	
	@Test
	public void goLeft90FromNeg90()
	{
		run90ClassTest(-90, 0);
	}
	
	@Test
	public void goLeft90FromNeg150()
	{
		run90ClassTest(-150, -60);
	}
	
	@Test
	public void goLeft90From150()
	{
		run90ClassTest(150, -120);
	}
}
