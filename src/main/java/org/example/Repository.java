package org.example;

import java.util.HashMap;
import java.util.Map;
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
                break;
            case 6:
                System.exit(0);
        }
    }

    private void CreateNewTask() {
        var scan = new Scanner(System.in);
        System.out.println("Insert Task Name");
        var name = scan.nextLine();
        scan.reset();
        System.out.println("Insert Task Description");
        var description = scan.nextLine();
        scan.reset();
        var task = new Task(name, description);
        taskDictionary.put(taskDictionary.size(), task);
        System.out.println("Task " + name + " is created");

    }

    private void GetAllTask() {

        taskDictionary.forEach((key, t) ->{
            System.out.println("ID: " + key + " Name: " + t.get_taskName());
            System.out.println("Description: \n" + t.get_taskDescription());
            System.out.println("Date: \n" + t.get_date());
        });
    }

    private void DeleteTaskById(){
        var scan = new Scanner(System.in);
        System.out.println("Insert Task ID");
        var id = scan.nextInt();
        taskDictionary.remove(id);
        System.out.println("Task is deleted");
    }


}
