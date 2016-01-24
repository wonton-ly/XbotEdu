package xbot.edubot.rotation;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.junit.Ignore;

import xbot.common.math.XYPair;
import xbot.edubot.rotation.BaseOrientationEngineTest.AsyncRotationIntervalJob;
import xbot.edubot.rotation.BaseOrientationEngineTest.RotationEnvironmentState;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;

public class RotationTestVisualizer {
    private JFrame frame;
    private RotationVisualizationPanel vizPanel;
    BaseOrientationEngineTest currentTestEnvironment;
    RotationEnvironmentState envState = new RotationEnvironmentState();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RotationTestVisualizer window = new RotationTestVisualizer();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public RotationTestVisualizer() {
        initialize();
    }
    
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        vizPanel = new RotationVisualizationPanel();
        vizPanel.updateState(envState);
        
        frame.getContentPane().add(vizPanel);
        

        setRotationTest(OrientationTest.ROTATE_TO_ORIENTATION);
    }
    
    private void setRotationTest(OrientationTest test) {
        switch(test) {
            case GO_LEFT_90_FROM_0:
            case GO_LEFT_90_FROM_150:
            case GO_LEFT_90_FROM_NEG_150:
            case GO_LEFT_90_FROM_NEG_90:
                currentTestEnvironment = new TurnLeft90DegreesCommandTest();
                break;
            case ROTATE_TO_ORIENTATION:
                currentTestEnvironment = new GoToOrientationTest();
                break;
        }
        
        currentTestEnvironment.setUp();
        
        currentTestEnvironment.setAsAsync((BaseOrientationEngineTest.RotationEnvironmentState envState) -> {
            this.envState = envState;
            vizPanel.updateState(envState);
            vizPanel.repaint();
        });
        
        ((SelectableOrientationTest) currentTestEnvironment).invokeOrientationTest(test);
        
    }

    public static enum OrientationTest {
        GO_LEFT_90_FROM_0,
        GO_LEFT_90_FROM_NEG_90,
        GO_LEFT_90_FROM_NEG_150,
        GO_LEFT_90_FROM_150,
        ROTATE_TO_ORIENTATION
    }
    
    public static interface SelectableOrientationTest {
        void invokeOrientationTest(OrientationTest test);
    }
}
