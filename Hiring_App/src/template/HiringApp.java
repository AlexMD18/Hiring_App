/*
Program Description:
This program creates an app that can be used to hire and fire people from a company
 */
package template;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Deque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class HiringApp {

    //Array list so the user can type multiple skills per person
    Deque<Person> hire = new ArrayDeque<>();
    Deque<Person> fire = new ArrayDeque<>();
    Queue<Person> applicantQueue = new LinkedList<>();

    String name;
    String degree;
    String skills;

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HiringApp hA = new HiringApp();

        int menuChoice = 0;
        
        //do-while loop that displays a menu to the user until they give the quit command
        do {
            //display a menu
            System.out.println("Menu:");
            System.out.println("1: Accept an Application");
            System.out.println("2: Hire");
            System.out.println("3: Fire");
            System.out.println("0: Quit");
            System.out.print("Type Choice Here: ");
            menuChoice = scanner.nextInt();
            String newAssignment = scanner.nextLine();

            //get the menu choice
            //Switch statement to select what the user would like to do 
            switch (menuChoice) {
                case 1:
                    hA.acceptApplication();
                    break;
                case 2:
                    hA.hire();
                    break;
                case 3:
                    hA.fire();
                    break;
                default:
                    System.out.println("Program Ended");
                    break;
            }

        } while (menuChoice > 0);
        //looping until the user decides to quit.
    }

    //Method that accepts an application and inserts it into the queue
    public void acceptApplication() {
        ArrayList<String> listSkills = new ArrayList<>();

        System.out.print("Name of Applicant: ");
        name = scanner.nextLine();

        System.out.print("Degree of Applicant: ");
        degree = scanner.nextLine();

        System.out.print("Skills of Applicant: ");
        skills = scanner.nextLine();        
        String[] listSkillsArray = skills.split(" ");
        for (int i = 0; i < listSkillsArray.length; i++) {
            listSkills.add(listSkillsArray[i]);
        }

        applicantQueue.add(new Person(name, degree, listSkills));
    }

    //Method that hires the first person in the applicants list
    //If there is no in the applicants list, a message is sent to the supervisor
    public void hire() {
        if (applicantQueue.isEmpty()) {
            System.out.println("SUPERVISOR: No applicants available. ");
        } else if (!fire.isEmpty()) {
            Person firedPerson = fire.pop();
            hire.push(firedPerson);
            System.out.println("The last person fired: " + firedPerson);
        } else {
            Person first = applicantQueue.poll();
            hire.push(first);
            System.out.println("The person being hired is: " + first);
        }
    }

    //Method that fires the most recently hired person.
    //If no one is currently employed, a message is sent to the supervisor
    public void fire() {
        if (hire.isEmpty()) {
            System.out.println("SUPERVISOR: No employees to fire. ");
        } else {
            Person fired = hire.pop();
            fire.push(fired);
            System.out.println("The person being fired is: " + fired);
        }
    }

}
