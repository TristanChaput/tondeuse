package org.example;

public class Tondeuse {

    private Coordinates coordinates;

    public Tondeuse(Coordinates newCoordinates) {
        coordinates = newCoordinates;
    }

    public String showPosition() {
        return coordinates.toString();
    }

    public void move(String givenInstruction) {
        Instruction instruction = Instruction.valueOf(givenInstruction);

        switch (instruction) {
            case A -> {
                switch (coordinates.getDirection()) {
                    case N -> addToY();
                    case E -> addToX();
                    case W -> minusToX();
                    case S -> minusToY();
                }
            }
            case D -> {
                switch (coordinates.getDirection()) {
                    case N -> moveToEast();
                    case E -> moveToSouth();
                    case W -> moveToNorth();
                    case S -> moveToWest();
                }
            }
            case G -> {
                switch (coordinates.getDirection()) {
                    case N -> moveToWest();
                    case E -> moveToNorth();
                    case W -> moveToSouth();
                    case S -> moveToEast();
                }
            }
        }
    }

    private void moveToEast() {
        coordinates.setDirection(Direction.E);
    }

    private void moveToSouth() {
        coordinates.setDirection(Direction.S);
    }

    private void moveToNorth() {
        coordinates.setDirection(Direction.N);
    }

    private void moveToWest() {
        coordinates.setDirection(Direction.W);
    }

    private void addToX() {
        coordinates.setX(coordinates.getX() + 1);
    }

    private void minusToX() {
        coordinates.setX(coordinates.getX() - 1);
    }

    private void addToY() {
        coordinates.setY(coordinates.getY() + 1);
    }

    private void minusToY() {
        coordinates.setY(coordinates.getY() - 1);
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
}
