/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package CA_2;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author nyamka.t
 */

public class BankEmployeeManagementSystem {

    public static void main(String[] args) {

        // Create scanner object to receive keyboard input
        Scanner input = new Scanner(System.in);

        // Create binary tree object to store employee hierarchy
        BinaryTree tree = new BinaryTree();

        // Create ArrayList to store employee records
        ArrayList<Employee> employeeList = new ArrayList<>();

        // Load employee data from text file
        loadEmployees(employeeList, tree);

        // Variable used for menu selection
        int choice;

        // Repeat menu until user selects Exit option
        do {

            // Display system menu
            System.out.println("\n=== Bank Employee Management System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. Sort Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Display Binary Tree Hierarchy");
            System.out.println("5. Count Nodes");
            System.out.println("6. Tree Height");
            System.out.println("7. Exit");

            // Ask user to select menu option
            System.out.print("Enter choice: ");
            choice = input.nextInt();

            // Execute selected menu option
            switch(choice) {

                case 1:

                    // Clear scanner buffer
                    input.nextLine();

                    // Ask user to enter employee name
                    System.out.print("Enter Employee Name: ");
                    String name = input.nextLine();

                    // Display manager type options
                    System.out.println("Select Manager Type:");
                    System.out.println("1. HEAD_MANAGER");
                    System.out.println("2. ASSISTANT_MANAGER");
                    System.out.println("3. TEAM_LEADER");

                    // Store selected manager type
                    int managerChoice = input.nextInt();

                    // Variable to store manager type
                    ManagerType managerType;

                    // Convert integer choice into enum value
                    switch(managerChoice) {

                        case 1:
                            managerType = ManagerType.HEAD_MANAGER;
                            break;

                        case 2:
                            managerType = ManagerType.ASSISTANT_MANAGER;
                            break;

                        default:
                            managerType = ManagerType.TEAM_LEADER;
                            break;
                    }

                    // Display department options
                    System.out.println("Select Department:");
                    System.out.println("1. CUSTOMER_SERVICE");
                    System.out.println("2. FOREIGN_EXCHANGE");
                    System.out.println("3. HR");

                    // Store selected department
                    int departmentChoice = input.nextInt();

                    // Variable to store department type
                    DepartmentType department;

                    // Convert integer choice into enum value
                    switch(departmentChoice) {

                        case 1:
                            department = DepartmentType.CUSTOMER_SERVICE;
                            break;

                        case 2:
                            department = DepartmentType.FOREIGN_EXCHANGE;
                            break;

                        default:
                            department = DepartmentType.HR;
                            break;
                    }

                    // Create employee object using entered information
                    Employee employee =
                    new Employee(name, managerType, department);

                    // Insert employee into binary tree
                    tree.insert(employee);

                    // Add employee into ArrayList
                    employeeList.add(employee);

                    // Display success message
                    System.out.println(name + " added successfully!");

                    break;

                case 2:

                    // Create MergeSort object
                    MergeSort sorter = new MergeSort();

                    // Sort employee list alphabetically
                    sorter.mergeSort(employeeList);

                    // Display sorted employee names
                    System.out.println("Sorted Employees:");

                    // Print all sorted employees
                    for (Employee emp : employeeList) {

                        System.out.println(emp.name);
                    }

                    break;

                case 3:

                    // Create MergeSort object before searching
                    MergeSort sorter2 = new MergeSort();

                    // Sort employee list before Binary Search
                    sorter2.mergeSort(employeeList);

                    // Clear scanner buffer
                    input.nextLine();

                    // Ask user for employee name
                    System.out.print("Enter employee name to search: ");

                    // Store search keyword
                    String searchName = input.nextLine();

                    // Create BinarySearch object
                    BinarySearch searcher = new BinarySearch();

                    // Search employee using Binary Search algorithm
                    Employee found =
                    searcher.binarySearch(
                    employeeList,
                    searchName,
                    0,
                    employeeList.size() - 1);

                    // Display employee information if found
                    if (found != null) {

                        System.out.println("Employee Found:");
                        System.out.println("Name: " + found.name);
                        System.out.println("Manager: "
                                + found.managerType);
                        System.out.println("Department: "
                                + found.department);

                    } else {

                        // Display message if employee does not exist
                        System.out.println("Employee not found");
                    }

                    break;

                case 4:

                    // Display binary tree hierarchy
                    tree.display();

                    break;

                case 5:

                    // Display total number of nodes in binary tree
                    System.out.println("Total Nodes: "
                            + tree.countNodes(tree.root));

                    break;

                case 6:

                    // Display height of binary tree
                    System.out.println("Tree Height: "
                            + tree.getHeight(tree.root));

                    break;

                case 7:

                    // Exit system
                    System.out.println("System Closed");

                    break;

                default:

                    // Display error message for invalid option
                    System.out.println("Invalid Option");
            }

        } while(choice != 7);

    }

    // Method used to load employee data from text file
    public static void loadEmployees(ArrayList<Employee> employeeList,
                                     BinaryTree tree) {

        try {

            // Create BufferedReader object to read text file
            BufferedReader reader =
            new BufferedReader(new FileReader("employees.txt"));

            // Variable used to store each line from file
            String line;

            // Read file until end of file
            while ((line = reader.readLine()) != null) {

                // Split line using comma separator
                String[] data = line.split(",");

                // Store employee name
                String name = data[0];

                // Convert text into ManagerType enum
                ManagerType manager =
                ManagerType.valueOf(data[1]);

                // Convert text into DepartmentType enum
                DepartmentType department =
                DepartmentType.valueOf(data[2]);

                // Create employee object
                Employee employee =
                new Employee(name, manager, department);

                // Add employee into ArrayList
                employeeList.add(employee);

                // Insert employee into Binary Tree
                tree.insert(employee);
            }

            // Close file reader
            reader.close();

        } catch (IOException e) {

            // Display error message if file cannot be read
            System.out.println("File could not be read.");
        }
    }
}