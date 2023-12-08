package org.exam;


import java.io.IOException;
import java.util.ArrayList;

import static org.exam.PrintToConsole.*;


public class RobotsGame {
    public static void main(String[] args) throws IOException {

//game with 2 robots



        String nameRobot1;
        nameRobot1 = Robots.setName("Robot1", null);
        String nameRobot2 = Robots.setName("Robot2", nameRobot1);
        Robots robot1 = new Robots(nameRobot1);
        Robots robot2 = new Robots(nameRobot2);
        do {
            printHeader(robot1);
            robot1.fight(robot1.readLetterFromConsole());
            printHeader(robot2);
            robot2.fight(robot2.readLetterFromConsole());
            printResult(robot1);
            printResult(robot2);
            if (robot1.getHealth() <= 0) {
                System.out.println(robot1.getName() + " was killed");
                System.out.println(robot2.getName() + " wins!");
                printResult(robot2);
            } else if (robot2.getHealth() <= 0) {
                System.out.println(robot2.getName() + " was killed");
                System.out.println(robot1.getName() + " wins!");
                printResult(robot1);
            }
        } while (robot1.getHealth() > 0 && robot2.getHealth() > 0);


        //game with set number of robots
        ArrayList<Robots> robots = Robots.robotsCreate();
        do {
            int i;
            for (i = 0; i < robots.size(); i++) {
                printHeader(robots.get(i));
                robots.get(i).fight(robots.get(i).readLetterFromConsole());
                if (robots.get(i).getHealth() <= 0) {
                    System.out.println(robots.get(i).getName() + " was killed");
                    robots.remove(i);
                }
            }
            for (i = 0; i < robots.size(); i++) {
                printResult(robots.get(i));
            }
        } while (robots.size() > 1);
        System.out.println("The winner is " + robots.get(0).getName());
    }
}
