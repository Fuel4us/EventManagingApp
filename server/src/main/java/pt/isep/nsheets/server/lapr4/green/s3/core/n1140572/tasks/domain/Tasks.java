/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.green.s3.core.n1140572.tasks.domain;

import eapli.framework.domain.AggregateRoot;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import pt.isep.nsheets.server.lapr4.blue.s2.core.n1160713.contacts.domain.Contact;
import pt.isep.nsheets.shared.services.TasksDTO;

/**
 *
 * @author Pedro Rodrigues - (1140572)
 */
@Entity
public class Tasks implements AggregateRoot<Long>, Serializable {

    @Id
    @GeneratedValue
    private Long id;

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

    @ManyToMany
    private ArrayList<Contact> contacts;

    /**
     * Default constructor for ORM
     */
    protected Tasks() {
    }

    public Tasks(String name, String description, int priorityLevel) {
        this.name = name;
        this.description = description;
        this.priorityLevel = priorityLevel;
        this.progress = 0;
        this.taskCompleted = false;
        this.contacts = new ArrayList<>();
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

    /**
     * @return the contacts
     */
    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @param priorityLevel the priorityLevel to set
     */
    public void setPriorityLevel(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    /**
     * @param progress the progress to set
     */
    public void setProgress(int progress) {
        this.progress = progress;
    }

    /**
     * @param taskCompleted the taskCompleted to set
     */
    public void setTaskCompleted(boolean taskCompleted) {
        this.taskCompleted = taskCompleted;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Tasks)) {
            return false;
        }

        final Tasks otherTask = (Tasks) other;
        if (this == otherTask) {
            return true;
        }
        if (!this.name.equals(otherTask.name)) {
            return false;
        }
        if (!this.description.equals(otherTask.description)) {
            return false;
        }
        if (this.getPriorityLevel() != otherTask.getPriorityLevel()) {
            return false;
        }
        if (this.getProgress() != otherTask.getProgress()) {
            return false;
        }

        return this.isTaskCompleted() == otherTask.isTaskCompleted();
    }

    @Override
    public boolean is(Long id) {
        return this.id.compareTo(id) == 0;
    }

    @Override
    public Long id() {
        return this.id;
    }

    public TasksDTO toDTO() {
        return new TasksDTO(this.name, this.description, this.priorityLevel, this.progress, this.taskCompleted);
    }

    public static Tasks fromDTO(TasksDTO tasksDTO) throws IllegalArgumentException {
        return new Tasks(tasksDTO.getName(), tasksDTO.getDescription(), tasksDTO.getPriorityLevel());
    }
}
