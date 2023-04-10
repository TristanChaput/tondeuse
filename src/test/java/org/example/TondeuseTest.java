package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class TondeuseTest {

    @ParameterizedTest
    @CsvSource({
            "0, 0, N, 0 0 N",
            "1, 2, E, 1 2 E",
            "2, 1, W, 2 1 W",
            "3, 3, S, 3 3 S"
    })
    void test_show_position_x_y_direction(int x, int y, String direction, String expected){
        Coordinates coordinates = new Coordinates(x, y, direction);
        Tondeuse tondeuse = new Tondeuse(coordinates, null);

        String actual = tondeuse.showPosition();

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0, N, 0, 1, N",
            "1, 2, E, 2, 2, E",
            "2, 1, W, 1, 1, W",
            "3, 3, S, 3, 2, S"
    })
    void test_move_forward(int x, int y, String direction, int expectedX, int expectedY, Direction expectedDirection){
        Coordinates coordinates = new Coordinates(x, y, direction);
        Coordinates limits = new Coordinates(5, 5);
        Tondeuse tondeuse = new Tondeuse(coordinates, limits);

        tondeuse.move("A");

        assertThat(tondeuse.getCoordinates().getX()).isEqualTo(expectedX);
        assertThat(tondeuse.getCoordinates().getY()).isEqualTo(expectedY);
        assertThat(tondeuse.getCoordinates().getDirection()).isEqualTo(expectedDirection);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0, N, 0, 0, E",
            "1, 2, E, 1, 2, S",
            "2, 1, W, 2, 1, N",
            "3, 3, S, 3, 3, W"
    })
    void test_move_to_right(int x, int y, String direction, int expectedX, int expectedY, Direction expectedDirection){
        Coordinates coordinates = new Coordinates(x, y, direction);
        Tondeuse tondeuse = new Tondeuse(coordinates, null);

        tondeuse.move("D");

        assertThat(tondeuse.getCoordinates().getX()).isEqualTo(expectedX);
        assertThat(tondeuse.getCoordinates().getY()).isEqualTo(expectedY);
        assertThat(tondeuse.getCoordinates().getDirection()).isEqualTo(expectedDirection);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0, N, 0, 0, W",
            "1, 2, E, 1, 2, N",
            "2, 1, W, 2, 1, S",
            "3, 3, S, 3, 3, E"
    })
    void test_move_to_left(int x, int y, String direction, int expectedX, int expectedY, Direction expectedDirection){
        Coordinates coordinates = new Coordinates(x, y, direction);
        Tondeuse tondeuse = new Tondeuse(coordinates, null);

        tondeuse.move("G");

        assertThat(tondeuse.getCoordinates().getX()).isEqualTo(expectedX);
        assertThat(tondeuse.getCoordinates().getY()).isEqualTo(expectedY);
        assertThat(tondeuse.getCoordinates().getDirection()).isEqualTo(expectedDirection);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0, N, 0, 0, N",
            "1, 2, E, 1, 2, E",
            "2, 1, W, 2, 1, W",
            "3, 3, S, 3, 3, S"
    })
    void test_move_forward_but_out_of_limits(int x, int y, String direction, int expectedX, int expectedY, Direction expectedDirection){
        Coordinates coordinates = new Coordinates(x, y, direction);
        Coordinates limits = new Coordinates(0, 0);
        Tondeuse tondeuse = new Tondeuse(coordinates, limits);

        tondeuse.move("A");

        assertThat(tondeuse.getCoordinates().getX()).isEqualTo(expectedX);
        assertThat(tondeuse.getCoordinates().getY()).isEqualTo(expectedY);
        assertThat(tondeuse.getCoordinates().getDirection()).isEqualTo(expectedDirection);
    }
}
