package CA_2;


import CA_2.Employee;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nyamka.t
 */
public class TreeNode {

    Employee employee;

    TreeNode left;
    TreeNode right;
    TreeNode parent;

    public TreeNode(Employee employee) {
        this.employee = employee;
        left = null;
        right = null;
    }

}
