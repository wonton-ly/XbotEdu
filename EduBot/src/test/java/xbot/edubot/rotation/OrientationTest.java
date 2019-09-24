package xbot.edubot.rotation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import xbot.edubot.BaseDriveTest;
import xbot.edubot.subsystems.drive.commands.DriveToOrientationCommand;

public class OrientationTest extends BaseDriveTest {

    @Test 
    public void test() {

        double results = DriveToOrientationCommand.getDistance(4, -27);

        assertEquals(-31, results, 0.001);
    }

    @Test
    public void test2() {

        double results = DriveToOrientationCommand.getDistance(-27, 4);

        assertEquals(31, results, 0.001);
    }

    @Test
    public void test3() {

        double results = DriveToOrientationCommand.getDistance(149, -164);

        assertEquals(47, results, 0.001);
    }
    @Test
    public void test4() {

        double results = DriveToOrientationCommand.getDistance(-164, 149);

        assertEquals(47, results, 0.001);
    }
    @Test
    public void test5() {

        double results = DriveToOrientationCommand.getDistance(0, 90);

        assertEquals(90, results, 0.001);
    }

}