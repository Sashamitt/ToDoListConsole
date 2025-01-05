package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static Repository repository = new Repository();

    public static void main(String[] args) {
        System.out.println("Select action\n");
        System.out.println("1. Add task");
        System.out.println("2. Get all tasks");
        System.out.println("3. Delete task");
        System.out.println("4. Delete all tasks");
        System.out.println("5. Change task");
        var command = 0;
        while (true) {
            command = GetCommand();
            repository.SetCommand(command);
        }
    }

    public static int GetCommand() {
        var scan = new Scanner(System.in);
        while (true) {
            try {
                var num = scan.nextInt();
                if (num > 0 && num < 7)
                    return num;
                else
                    System.out.println("Input incorrect");
            } catch (Exception ex) {
                System.out.println("Input incorrect");
            }
        }
    }
}
