package CA_2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nyamka.t
 */
public class Employee {

    String name;
    ManagerType managerType;
    DepartmentType department;

    // Constructor
    public Employee(String name, ManagerType managerType, DepartmentType department) {

        this.name = name;
        this.managerType = managerType;
        this.department = department;
    }
    
    @Override
public String toString() {

    return "Name: " + name
            + ", Manager Type: " + managerType
            + ", Department: " + department;
}
}
