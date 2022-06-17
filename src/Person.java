/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Administrator
 */
public class Person {
    String ID;
    String name;
    String birthplace;
    String dob;
    
    //contructor
    public Person(String ID) {
        this.ID = ID;
    }
    
    //contructor co tham so
    public Person(String ID, String name, String birthplace, String dob){
        this.ID = ID;
        this.name = name;
        this.birthplace = birthplace;
        this.dob = dob;
    }
    
    //hien thi thong tin
    @Override
    public String toString(){
        return String.format("%-10s %-10s %-20s %-10s", ID, name, dob, birthplace);
    }
    
    //so sanh
    @Override
    public boolean equals(Object obj) {
        
        return false;
    }
}
