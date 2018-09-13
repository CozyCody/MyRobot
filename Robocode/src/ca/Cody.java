package ca;


import robocode.*;

import java.awt.*;


public class Cody extends AdvancedRobot {
boolean movingForward;
    /**
     * PaintingRobot's run method - Seesaw
     */
    public void run() {

        setAdjustGunForRobotTurn(false);
        setAdjustRadarForGunTurn(false);
        setAdjustRadarForRobotTurn(false);

        while (true) {


            setTurnRadarRightRadians(Double.POSITIVE_INFINITY);

            // Targeting code here


        }
    }
    public void onHitWall(HitWallEvent e) {
        // Bounce off!
        reverseDirection();
    }

    public void reverseDirection() {

    }
    /**
     * Fire when we see a robot
     */
    public void onScannedRobot(ScannedRobotEvent e) {
        // demonstrate feature of debugging properties on RobotDialog
        setTurnRadarLeftRadians(getRadarTurnRemainingRadians());

        // Targeting code here?
        // getX(), getY()

        fire(2);
    }

    /**
     * We were hit!  Turn perpendicular to the bullet,
     * so our seesaw might avoid a future shot.
     * In addition, draw orange circles where we were hit.
     */
    public void onHitByBullet(HitByBulletEvent e) {
        // demonstrate feature of debugging properties on RobotDialog
        setDebugProperty("lastHitBy", e.getName() + " with power of bullet " + e.getPower() + " at time " + getTime());

        // show how to remove debugging property
        setDebugProperty("lastScannedRobot", null);

        // gebugging by painting to battle view
        Graphics2D g = getGraphics();

        g.setColor(Color.orange);
        g.drawOval((int) (getX() - 55), (int) (getY() - 55), 110, 110);
        g.drawOval((int) (getX() - 56), (int) (getY() - 56), 112, 112);
        g.drawOval((int) (getX() - 59), (int) (getY() - 59), 118, 118);
        g.drawOval((int) (getX() - 60), (int) (getY() - 60), 120, 120);


        turnLeft(90 - e.getBearing());
    }

    /**
     * Paint a red circle around our PaintingRobot
     */
    public void onPaint(Graphics2D g) {
        g.setColor(Color.red);
        g.drawOval((int) (getX() - 50), (int) (getY() - 50), 100, 100);
        g.setColor(new Color(0, 0xFF, 0, 30));
        g.fillOval((int) (getX() - 60), (int) (getY() - 60), 120, 120);
    }
}

