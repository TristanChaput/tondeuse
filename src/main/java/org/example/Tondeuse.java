package org.example;

import java.util.List;
import java.util.Objects;

public class Tondeuse {

    private Coordinates coordinates;

    private Coordinates limits;

    public Tondeuse(Coordinates newCoordinates, Coordinates newLimits) {
        coordinates = newCoordinates;
        limits = newLimits;
    }

    public String run(String instructions){
        for(char instruction : instructions.toCharArray()){
            move(String.valueOf(instruction));
        }
        return showPosition();
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
        int newX = coordinates.getX() + 1;
        setX(newX);
    }

    private void minusToX() {
        int newX = coordinates.getX() - 1;
        setX(newX);
    }

    private void addToY() {
        int newY = coordinates.getY() + 1;
        setY(newY);
    }

    private void minusToY() {
        int newY = coordinates.getY() - 1;
        setY(newY);
    }

    private void setX(int newX) {
        if(isInsideTheLimits(newX, limits.getX())){
            coordinates.setX(newX);
        }
    }

    private void setY(int newY) {
        if(isInsideTheLimits(newY, limits.getY())){
            coordinates.setY(newY);
        }
    }

    private boolean isInsideTheLimits(int newValue, int limits) {
        return limits >= newValue && newValue >= 0;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tondeuse tondeuse = (Tondeuse) o;

        return Objects.equals(coordinates, tondeuse.coordinates);
    }

    @Override
    public int hashCode() {
        return coordinates != null ? coordinates.hashCode() : 0;
    }
}
