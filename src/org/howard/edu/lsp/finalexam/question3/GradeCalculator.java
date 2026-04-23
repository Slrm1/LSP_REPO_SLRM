package org.howard.edu.lsp.finalexam.question3;

/**
 * Computes simple averages and letter grades with score validation.
 *
 * @author Selorm Kalitsi
 */
public class GradeCalculator {

    /**
     * Average of three validated scores in {@code [0, 100]}.
     *
     * @param score1 first score
     * @param score2 second score
     * @param score3 third score
     * @return arithmetic mean
     */
    public double average(int score1, int score2, int score3) {
        validateScore(score1);
        validateScore(score2);
        validateScore(score3);
        return (score1 + score2 + score3) / 3.0;
    }

    /**
     * Letter grade from a numeric average.
     *
     * @param average course average
     * @return A–F letter
     */
    public String letterGrade(double average) {
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    /**
     * @param average course average
     * @return true if average is at least passing (60)
     */
    public boolean isPassing(double average) {
        return average >= 60;
    }

    private void validateScore(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score must be between 0 and 100");
        }
    }
}
