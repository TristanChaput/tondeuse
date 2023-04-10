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
        Tondeuse tondeuse = new Tondeuse(x, y, direction);

        String actual = tondeuse.showPosition();

        assertThat(actual).isEqualTo(expected);
    }
}
