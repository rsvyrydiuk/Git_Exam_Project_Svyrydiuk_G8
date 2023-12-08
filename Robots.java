package org.exam;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.toBinaryString;


public class Robots {
    private final String name;
    private int health;
    private final ArrayList<String> buttons;  // = randomButton();

    public Robots(String name) {
        this.name = name;
        this.health = 100;
        this.buttons = randomButton();
    }


    private ArrayList<String> defaultButtons() {
        ArrayList<String> buttons = new ArrayList<>();
        buttons.add("Q");
        buttons.add("W");
        buttons.add("E");
        buttons.add("A");
        buttons.add("S");
        buttons.add("D");
        buttons.add("Z");
        buttons.add("X");
        buttons.add("C");
        return buttons;
    }


    private @NotNull ArrayList<String> randomButton() {
        ArrayList<String> shotButtons = defaultButtons();
        ArrayList<String> list1 = defaultButtons();
        for (int i = 0; i < 5; i++) {
            list1.remove((int) (Math.random() * list1.size()));
            System.out.println(list1);
        }
        shotButtons.removeAll(list1);
        return shotButtons;
    }


    public String readLetterFromConsole() throws IOException {
        System.out.println("Your step: pres key" + defaultButtons());
        BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));
        String letter = reader.readLine();
        return letter;
    }

    public void fight(@NotNull String enteredLetter) throws IOException {

        if (enteredLetter.equalsIgnoreCase("P")) {
            System.out.println("You exit the game");
            System.exit(0);
        } else if (buttons.contains(enteredLetter.toUpperCase())) {
            int newHealth = health - 20;
            buttons.remove(enteredLetter.toUpperCase());
            System.out.println("Babah!!! You hit the robot");
            setHealth(newHealth);
        } else if (getAllButtons().contains(enteredLetter.toUpperCase()) && !enteredLetter.contains(enteredLetter.toUpperCase())) {
            System.out.println("You missed");
        } else if (!getAllButtons().contains(enteredLetter.toUpperCase())) {
            System.out.println("You entered inactive button or entered double button");
            (enteredLetter) = readLetterFromConsole();
            fight(enteredLetter);
        }
    }


    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public ArrayList<String> getButtons() {
        return buttons;
    }

    public ArrayList<String> getAllButtons() {
        return defaultButtons();
    }

    public void setHealth(int health) {
        this.health = health;
    }


    public static String setName(String enteredName, String robotName) throws IOException {
        System.out.println("Enter name of " + enteredName);
        BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));
        String name = reader.readLine();
        if (name.equals(robotName)) {
            System.out.println("Name is already taken. Re enter name of robot");
            setName(enteredName, robotName);
        }
        if (name.isEmpty()) {
            System.out.println("Name is empty. Re enter name of robot");
            setName(enteredName, robotName);
        }
        return name;
    }


    //method for create robots

    public static ArrayList<Robots> robotsCreate() throws IOException {
        ArrayList<Robots> robots = new ArrayList<>();
        System.out.println("Welcome to the game!");
        System.out.println("Enter number of players: ");
        BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));

        try {
            int numberOfPlayers = parseInt(reader.readLine());
            if (numberOfPlayers < 2) {
                System.out.println("You entered less than 2 players. Re enter number of players");
                robotsCreate();
            }
            for (int i = 0; i < numberOfPlayers; i++) {
                System.out.println("Enter name of robot " + (i + 1) + ": ");
                String nameRobot = reader.readLine();
                Robots robot = new Robots(nameRobot);
                System.out.println("Robot " + robot.getName() + " was created");
                robots.add(robot);
            }
        } catch (NumberFormatException e) {
            System.out.println("You entered not a number");
            robotsCreate();
        }
        return robots;
    }
}
