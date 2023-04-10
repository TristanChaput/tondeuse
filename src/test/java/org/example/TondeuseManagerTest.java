package org.example;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

public class TondeuseManagerTest {

    @Test
    void test_get_correct_limits_from_a_file(){
        File file = new File("src/main/resources/test.txt");

        TondeuseManager tondeuseManager = new TondeuseManager(file);

        assertThat(tondeuseManager.getLimits().getX()).isEqualTo(5);
        assertThat(tondeuseManager.getLimits().getY()).isEqualTo(5);
    }

    @Test
    void test_get_a_tondeuse_from_a_file(){
        File file = new File("src/main/resources/test.txt");

        TondeuseManager tondeuseManager = new TondeuseManager(file);

        Tondeuse expected = new Tondeuse(
                new Coordinates(1, 2, "N"),
                new Coordinates(5, 5));

        assertThat(tondeuseManager.getTondeuses().containsKey(expected)).isTrue();
    }
}
