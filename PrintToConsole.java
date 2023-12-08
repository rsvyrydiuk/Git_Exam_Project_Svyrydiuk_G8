package org.exam;

import java.util.ArrayList;

public class PrintToConsole {


    public static void printHeader(Robots robot) {
        System.out.println();
        System.out.println("For exit press P\n" +
                "A shot at the robot: " + robot.getName());
    }


    public static void printResult(Robots robot) {
        printFooter();
        System.out.println(robot.getName() + " , " + robot.getHealth());
        printFooter();
    }

    public static void printFooter() {
        System.out.println("-".repeat(10));
    }

}
