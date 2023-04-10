package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TondeuseManager {

    private Coordinates limits;

    public TondeuseManager(File file){
        try {
            Scanner scanner = new Scanner(file);

            this.limits = getLimitsFromFirstLine(scanner);

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();

                System.out.println(line);
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

    public Coordinates getLimits() {
        return limits;
    }
}
