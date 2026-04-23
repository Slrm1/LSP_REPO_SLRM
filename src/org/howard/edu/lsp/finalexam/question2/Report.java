package org.howard.edu.lsp.finalexam.question2;

/**
 * Abstract report with a fixed workflow (Template Method). Subclasses fill in
 * data loading and formatting steps.
 *
 * @author Selorm Kalitsi
 */
public abstract class Report {

    /**
     * Template method: runs the required workflow in order.
     */
    public final void generateReport() {
        loadData();
        formatHeader();
        formatBody();
        formatFooter();
    }

    /** Load report-specific values used by the body (and header/footer if needed). */
    protected abstract void loadData();

    /** Print the report-specific header section. */
    protected abstract void formatHeader();

    /** Print the report-specific body section. */
    protected abstract void formatBody();

    /** Print the report-specific footer section. */
    protected abstract void formatFooter();
}
