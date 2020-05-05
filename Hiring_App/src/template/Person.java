//Assign 5, Person: 
//  Represent an applicant, or an employee
package template;

import java.util.ArrayList;

public class Person {

    //define data fields: name, degree, skill list
    private String name;
    private String degree;
    private ArrayList<String> listOfSkills;

    //define the constructor with given name, degree, and skill list
    public Person(String name, String degree, ArrayList<String> listOfSkills) {
        this.listOfSkills = new ArrayList<>();
        this.name = name;
        this.degree = degree;
        this.listOfSkills = listOfSkills;
    }

    //define getters
    public String getName() {
        return name;
    }

    public String getDegree() {
        return degree;
    }

    public ArrayList<String> getListOfSkills() {
        return listOfSkills;
    }

    //define setters
    public void setName(String newName) {
        name = newName;
    }

    public void setDegree(String newDegree) {
        degree = newDegree;
    }

    public void setListOfSkills(ArrayList<String> newListOfSkills) {
        listOfSkills = newListOfSkills;
    }

    //define toString()
    @Override
    public String toString() {
        return "\nEmployee Name: " + name + "\nEmployee Degree: " + degree + "\nEmployee Skills: " + listOfSkills;
    }
}
