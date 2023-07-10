package by.andd3dfx.common;

import org.junit.Test;

import static by.andd3dfx.common.InfectionDistribution.weeksToInfectAllCities;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

public class InfectionDistributionTest {

    @Test
    public void testWeeksToInfectAllCitiesPositive() {
        assertThat(weeksToInfectAllCities(
                1,
                new int[][]{},
                new int[]{0}
        )).isEqualTo(0);

        assertThat(weeksToInfectAllCities(
                2,
                new int[][]{new int[]{0, 1}},
                new int[]{0}
        )).isEqualTo(1);

        assertThat(weeksToInfectAllCities(
                5,
                new int[][]{
                        new int[]{0, 2},
                        new int[]{1, 2},
                        new int[]{3, 4},
                },
                new int[]{0, 3}
        )).isEqualTo(2);

        assertThat(weeksToInfectAllCities(
                7,
                new int[][]{
                        new int[]{0, 2},
                        new int[]{1, 2},
                        new int[]{3, 4},
                        new int[]{6, 4},
                        new int[]{6, 5},
                        new int[]{1, 5},
                },
                new int[]{0}
        )).isEqualTo(6);
    }

    @Test
    public void testWeeksToInfectAllCitiesNegative() {
        assertThrows("Could not infect all cities!", IllegalArgumentException.class,
                () -> weeksToInfectAllCities(
                        1,
                        new int[][]{},
                        new int[]{}
                ));

        assertThrows("Could not infect all cities!", IllegalArgumentException.class,
                () -> weeksToInfectAllCities(
                        5,
                        new int[][]{
                                new int[]{0, 2},
                                new int[]{1, 4},
                        },
                        new int[]{0, 3}
                ));
    }
}
