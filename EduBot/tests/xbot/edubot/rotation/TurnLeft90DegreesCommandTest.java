package xbot.edubot.rotation;

import org.junit.Test;

public class TurnLeft90DegreesCommandTest extends BaseOrientationEngineTest {
	@Test
	public void goLeft90FromStart()
	{
		setUpTestEnvironmentFor90(0);
		runTestEnv();
	}
	
	@Test
	public void goLeft90FromNeg90()
	{
		setUpTestEnvironmentFor90(-90);
		runTestEnv();
	}
	
	@Test
	public void goLeft90FromNeg150()
	{
		setUpTestEnvironmentFor90(-150);
		runTestEnv();
	}
	
	@Test
	public void goLeft90From150()
	{
		setUpTestEnvironmentFor90(150);
		runTestEnv();
	}
}
