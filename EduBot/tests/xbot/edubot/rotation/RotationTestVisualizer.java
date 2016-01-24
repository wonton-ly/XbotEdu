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

        JPanel vizPanel = new JPanel() {
            private int centerX;
            private int centerY;
            private XYPair center;
            private double baseMagnitude;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D graphics = (Graphics2D) g;

                centerX = this.getWidth() / 2;
                centerY = this.getHeight() / 2;
                center = new XYPair(centerX, centerY);
                baseMagnitude = Math.min(centerX, centerY) * 0.8;

                graphics.setStroke(new BasicStroke(5));
                graphics.setColor(Color.BLUE);
                drawVector(graphics, XYPair.fromPolar(envState.targetOrientation, baseMagnitude));

                graphics.setColor(Color.BLACK);
                XYPair currentOrientationVector = XYPair.fromPolar(envState.currentOrientation, baseMagnitude);
                drawVector(graphics, currentOrientationVector);

                graphics.setColor(Color.CYAN);
                drawVector(graphics, XYPair.fromPolar(envState.currentOrientation + 90,
                        envState.currentRotationalPower * 0.5 * baseMagnitude), currentOrientationVector);
                
                graphics.setColor(Color.GRAY);
                drawVector(graphics, XYPair.fromPolar(envState.currentOrientation + 90,
                        envState.currentVelocity / 30 * baseMagnitude), currentOrientationVector.scale(0.5));
            }

            protected void drawVector(Graphics2D graphics, XYPair vector) {
                drawVector(graphics, vector, XYPair.ZERO);
            }

            protected void drawVector(Graphics2D graphics, XYPair vector, XYPair originPosition) {
                XYPair centeredOrigin = originPosition.clone().add(center);
                XYPair positionedVector = vector.clone().add(centeredOrigin);
                graphics.drawLine((int)centeredOrigin.x, (int)centeredOrigin.y, (int) positionedVector.x, (int) positionedVector.y);
            }
        };
        frame.getContentPane().add(vizPanel);

        currentTestEnvironment = new GoToOrientationTest();
        currentTestEnvironment.setUp();
        
        currentTestEnvironment.setAsAsync((BaseOrientationEngineTest.RotationEnvironmentState envState) -> {
            this.envState = envState;
            vizPanel.repaint();
        });

        ((GoToOrientationTest) currentTestEnvironment).testGoToOrientation();
    }
}
