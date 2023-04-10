package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TondeuseManager {

    private Coordinates limits;

    private List<Tondeuse> tondeuses = new ArrayList<>();

    public TondeuseManager(File file){
        try {
            Scanner scanner = new Scanner(file);

            this.limits = getLimitsFromFirstLine(scanner);

            while (scanner.hasNextLine()) {
                Coordinates coordinates = getInitialPosition(scanner);

                String instructions = scanner.nextLine();

                tondeuses.add(new Tondeuse(coordinates, limits));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void run() {
    }

    private Coordinates getLimitsFromFirstLine(Scanner scanner) {
        String firstLine = scanner.nextLine();
        String[] limits = firstLine.split(" ");
        int x = Integer.parseInt(limits[0]);
        int y = Integer.parseInt(limits[1]);
        return new Coordinates(x, y);
    }

    private static Coordinates getInitialPosition(Scanner scanner) {
        String initialPosition = scanner.nextLine();
        String[] values = initialPosition.split(" ");
        int x = Integer.parseInt(values[0]);
        int y = Integer.parseInt(values[1]);
        String direction = values[2];
        return new Coordinates(x, y, direction);
    }

    public Coordinates getLimits() {
        return limits;
    }

    public List<Tondeuse> getTondeuses() {
        return tondeuses;
    }
}
