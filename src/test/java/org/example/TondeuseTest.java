package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TondeuseTest {

    @Test
    void test_show_position_0_0_N(){
        Tondeuse tondeuse = new Tondeuse(0, 0, "N");

        String actual = tondeuse.showPosition();

        assertThat(actual).isEqualTo("0 0 N");
    }

    @Test
    void test_show_position_1_1_S(){
        Tondeuse tondeuse = new Tondeuse(1, 1, "S");

        String actual = tondeuse.showPosition();

        assertThat(actual).isEqualTo("1 1 S");
    }
}
