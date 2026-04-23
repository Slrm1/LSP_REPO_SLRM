package org.howard.edu.lsp.finalexam.question2;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates polymorphism over {@link Report}: same call, different concrete types.
 *
 * @author Selorm Kalitsi
 */
public final class ReportDriver {

    private ReportDriver() {
    }

    /**
     * Entry point: builds a heterogeneous list of reports and generates each one.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        List<Report> reports = new ArrayList<>();
        reports.add(new StudentReport());
        reports.add(new CourseReport());

        for (Report report : reports) {
            report.generateReport();
        }
    }
}
