package org.howard.edu.lsp.midterm.crccards;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages tasks, including add, find, and filtering by status.
 *
 * @author Selor
 */
public class TaskManager {
    private final Map<String, Task> tasksById;

    /**
     * Constructs an empty task manager.
     */
    public TaskManager() {
        this.tasksById = new LinkedHashMap<>();
    }

    /**
     * Adds a task. Duplicate task IDs are not allowed.
     *
     * @param task task to add
     * @throws IllegalArgumentException when task ID already exists
     */
    public void addTask(Task task) {
        String taskId = task.getTaskId();
        if (tasksById.containsKey(taskId)) {
            throw new IllegalArgumentException("Duplicate task ID: " + taskId);
        }
        tasksById.put(taskId, task);
    }

    /**
     * Finds a task by task ID.
     *
     * @param taskId task identifier
     * @return matching task, or null when not found
     */
    public Task findTask(String taskId) {
        return tasksById.get(taskId);
    }

    /**
     * Returns all tasks with a matching status.
     *
     * @param status status to match
     * @return list of tasks with that status
     */
    public List<Task> getTasksByStatus(String status) {
        List<Task> matches = new ArrayList<>();
        for (Task task : tasksById.values()) {
            if (task.getStatus().equals(status)) {
                matches.add(task);
            }
        }
        return matches;
    }
}

