package org.howard.edu.lsp.midterm.crccards;

/**
 * Represents a task with an ID, description, and status.
 *
 * @author Selor
 */
public class Task {
    private static final String OPEN = "OPEN";
    private static final String IN_PROGRESS = "IN_PROGRESS";
    private static final String COMPLETE = "COMPLETE";
    private static final String UNKNOWN = "UNKNOWN";

    private final String taskId;
    private final String description;
    private String status;

    /**
     * Constructs a task with default status OPEN.
     *
     * @param taskId task identifier
     * @param description task description
     */
    public Task(String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
        this.status = OPEN;
    }

    /**
     * Returns the task ID.
     *
     * @return task ID
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * Returns the task description.
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the task status.
     *
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Updates task status. Valid values are OPEN, IN_PROGRESS, COMPLETE.
     * Any other value sets status to UNKNOWN.
     *
     * @param status new status value
     */
    public void setStatus(String status) {
        if (OPEN.equals(status) || IN_PROGRESS.equals(status) || COMPLETE.equals(status)) {
            this.status = status;
        } else {
            this.status = UNKNOWN;
        }
    }

    /**
     * Returns formatted task details.
     *
     * @return taskId description [status]
     */
    @Override
    public String toString() {
        return taskId + " " + description + " [" + status + "]";
    }
}

