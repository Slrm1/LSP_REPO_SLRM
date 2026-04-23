package org.howard.edu.lsp.finalexam.question3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * JUnit 5 tests for {@link GradeCalculator}.
 *
 * @author Selorm Kalitsi
 */
class GradeCalculatorTest {

    private final GradeCalculator calculator = new GradeCalculator();

    @Test
    void average_threeValidScores_returnsArithmeticMean() {
        assertEquals(80.0, calculator.average(70, 80, 90), 1e-9);
    }

    @Test
    void letterGrade_averageInSeventies_returnsC() {
        assertEquals("C", calculator.letterGrade(75.0));
    }

    @Test
    void isPassing_averageAbove60_returnsTrue() {
        assertTrue(calculator.isPassing(61.0));
    }

    @Test
    void letterGrade_boundaryExactly90_returnsA() {
        assertEquals("A", calculator.letterGrade(90.0));
    }

    @Test
    void isPassing_boundaryExactly60_returnsTrue() {
        assertTrue(calculator.isPassing(60.0));
    }

    @Test
    void average_negativeScore_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> calculator.average(-1, 50, 50));
    }

    @Test
    void average_scoreAbove100_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> calculator.average(50, 50, 101));
    }
}
