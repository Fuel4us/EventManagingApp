/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.services;

/**
 *
 * @author Pedro Rodrigues - (1140572)
 */
public class TasksDTO {

    /**
     * Name of the task
     */
    private String name;

    /**
     * Description of the task
     */
    private String description;

    /**
     * Priority level of the task
     */
    private int priorityLevel;

    /**
     * Progress of the task
     */
    private int progress;

    /**
     * Indicates if a task is completed
     */
    private boolean taskCompleted;

    public TasksDTO(String name, String description, int priorityLevel, int progress, boolean taskCompleted) {
        this.name = name;
        this.description = description;
        this.priorityLevel = priorityLevel;
        this.progress = progress;
        this.taskCompleted = taskCompleted;
    }

    protected TasksDTO() {

    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the priorityLevel
     */
    public int getPriorityLevel() {
        return priorityLevel;
    }

    /**
     * @return the progress
     */
    public int getProgress() {
        return progress;
    }

    /**
     * @return the taskCompleted
     */
    public boolean isTaskCompleted() {
        return taskCompleted;
    }
    
}
