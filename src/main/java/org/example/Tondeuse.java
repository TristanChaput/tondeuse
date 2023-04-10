package org.example;

public class Tondeuse {

    private int x;
    private int y;
    private String direction;

    public Tondeuse(int x, int y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public String showPosition() {
        return String.format("%d %d %s", x, y, direction);
    }
}
