/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.services;

import java.io.Serializable;

/**
 *
 * @author Pedro Rodrigues - (1140572)
 */
@SuppressWarnings("serial")
public class TasksDTO implements Serializable {

    /**
     * Name of the task
     */
    public String name;

    /**
     * Description of the task
     */
    public String description;

    /**
     * Priority level of the task
     */
    public String priorityLevel;

    /**
     * Progress of the task
     */
    public String progress;

    /**
     * Indicates if a task is completed
     */
    public boolean taskCompleted;

    public TasksDTO() {
    }

    ;

    public TasksDTO(String name, String description, String priorityLevel, String progress, boolean taskCompleted) {
        this.name = name;
        this.description = description;
        this.priorityLevel = priorityLevel;
        this.progress = progress;
        this.taskCompleted = taskCompleted;
    }

}
