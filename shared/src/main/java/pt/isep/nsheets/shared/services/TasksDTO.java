/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.IsSerializable;


/**
 *
 * @author Pedro Rodrigues - (1140572)
 */
@SuppressWarnings("serial")
public class TasksDTO implements IsSerializable{

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
    public int priorityLevel;

    /**
     * Progress of the task
     */
    public int progress;

    /**
     * Indicates if a task is completed
     */
    public boolean taskCompleted;

    public TasksDTO() {

    }

    public TasksDTO(String name, String description, int priorityLevel, int progress, boolean taskCompleted) {
        this.name = name;
        this.description = description;
        this.priorityLevel = priorityLevel;
        this.progress = progress;
        this.taskCompleted = taskCompleted;
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
