package org.example;

import java.util.HashMap;

import java.util.Scanner;

public class Repository {
    private static HashMap<Integer, Task> taskDictionary;

    public Repository() {
        if (taskDictionary == null) {
            taskDictionary = new HashMap<>();
        }
    }

    public void SetCommand(int cmd) {
        switch (cmd) {
            case 1:
                System.out.println("Your choose is create new Task");
                CreateNewTask();
                break;
            case 2:
                System.out.println("Your choose is Get all tasks");
                GetAllTask();
                break;
            case 3:
                System.out.println("Your choose is Delete task");
                DeleteTaskById();
                break;
            case 4:
                System.out.println("Your choose is Delete all tasks");
                taskDictionary.clear();
                break;
            case 5:
                System.out.println("Your choose is Edit Task by Id");
                EditTaskById();
                break;
            case 6:
                System.exit(0);
        }
    }

    private void CreateNewTask() {
        var task = InsertTask();
        taskDictionary.put(taskDictionary.size(), task);
        System.out.println("Task " + task.get_taskName() + " is created");

    }

    private void GetAllTask() {

        taskDictionary.forEach((key, t) -> {
            System.out.println("ID: " + key + " Name: " + t.get_taskName());
            System.out.println("Description: \n" + t.get_taskDescription());
            System.out.println("Date: \n" + t.get_date());
        });
    }

    private void DeleteTaskById() {
        var scan = new Scanner(System.in);
        System.out.println("Insert Task ID");
        var id = scan.nextInt();
        taskDictionary.remove(id);
        System.out.println("Task is deleted");
    }


    private void EditTaskById() {
        var scan = new Scanner(System.in);
        System.out.println("Insert Task ID");
        var id = scan.nextInt();
        if (taskDictionary.containsKey(id)) {
            var newTask = InsertTask();
            taskDictionary.put(id, newTask);
        } else {
            System.out.println("Task not found");
        }
    }


    private Task InsertTask() {
        var scan = new Scanner(System.in);
        System.out.println("Insert Task Name");
        var name = scan.nextLine();
        scan.reset();
        System.out.println("Insert Task Description");
        var description = scan.nextLine();
        scan.reset();
        return new Task(name, description);
    }

}
