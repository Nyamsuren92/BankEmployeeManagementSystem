package CA_2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nyamka.t
 */
public class BinaryTree {

    TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public void insert(Employee employee) {

        TreeNode newNode = new TreeNode(employee);
        if (root == null) {
    root = newNode;
    return;
}

if (root.left == null) {
    root.left = newNode;
    newNode.parent = root;
}

else if (root.right == null) {
    root.right = newNode;
    newNode.parent = root;
}

else if (root.left.left == null) {
    root.left.left = newNode;
    newNode.parent = root.left;
}

else if (root.left.right == null) {
    root.left.right = newNode;
    newNode.parent = root.left;
}

else if (root.right.left == null) {
    root.right.left = newNode;
    newNode.parent = root.right;
}

else {
    root.right.right = newNode;
    newNode.parent = root.right;
}

        
    }
public void display() {
    displayRecursive(root, "Root");
}

private void displayRecursive(TreeNode node, String position) {

    if (node != null) {

        String parentName = "None";

if (node.parent != null) {
    parentName = node.parent.employee.name;
}

System.out.println(
    position +
    " -> Name: " + node.employee.name +
    ", Parent: " + parentName +
    ", Manager: " + node.employee.managerType +
    ", Department: " + node.employee.department
);
        displayRecursive(node.left, "Left");
        displayRecursive(node.right, "Right");
    }
}

    public int countNodes(TreeNode node) {
        
    if (node == null) {
        return 0;
    }

    return 1 + countNodes(node.left) + countNodes(node.right);
}
    public int getHeight(TreeNode node) {

    if (node == null) {
        return 0;
    }

    int leftHeight = getHeight(node.left);
    int rightHeight = getHeight(node.right);

    if (leftHeight > rightHeight) {
        return leftHeight + 1;
    }
    else {
        return rightHeight + 1;
    }
}
private TreeNode insertRecursive(TreeNode current,
                                 Employee employee,
                                 TreeNode parent) {

    if (current == null) {

        TreeNode newNode = new TreeNode(employee);
        newNode.parent = parent;

        return newNode;
    }

    if (employee.name.compareTo(current.employee.name) < 0) {

        current.left =
            insertRecursive(current.left, employee, current);

    } else {

        current.right =
            insertRecursive(current.right, employee, current);
    }

    return current;
}
}