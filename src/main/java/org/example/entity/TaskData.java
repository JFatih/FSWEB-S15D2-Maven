package org.example.entity;

import java.util.HashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks = new HashSet<>();
    private Set<Task> bobsTasks = new HashSet<>();
    private Set<Task> carolsTasks = new HashSet<>();
    private Set<Task> unassignedTasks = new HashSet<>();

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTasks(String name){
        switch (name) {
            case "ann":
                return annsTasks;
            case "bob":
                return bobsTasks;
            case "carol":
                return carolsTasks;
            case "all":
                return getUnion(annsTasks,bobsTasks,carolsTasks);
            default:
                return new HashSet<>();
        }
    }

    public Set<Task> getUnion(Set<Task>... tasks){
        Set<Task> unionTasks = new HashSet<>();
        for(Set<Task> task : tasks){
            unionTasks.addAll(task);
        }
        return unionTasks;
    }

    public Set<Task> getIntersection(Set<Task> task1, Set<Task> task2){
        Set<Task> copyTasks = new HashSet<>(task1);
        copyTasks.retainAll(task2);
        return copyTasks;
    }

    public Set<Task> getDifferences(Set<Task> task1, Set<Task> task2){
        task1.removeAll(task2);
        return task1;
    }

}
