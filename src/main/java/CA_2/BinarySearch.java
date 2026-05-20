/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;
import java.util.ArrayList;

/**
 *
 * @author nyamka.t
 */
public class BinarySearch {
    // Recursive binary search
    public Employee binarySearch(ArrayList<Employee> list,
                                 String target,
                                 int left,
                                 int right) {

        // Employee not found
        if (left > right) {
            return null;
        }

        // Find middle index
        int middle = (left + right) / 2;

        // Compare target with middle name
        int compare =
        list.get(middle).name.compareToIgnoreCase(target);

        // If found
        if (compare == 0) {
            return list.get(middle);
        }

        // Search left side
        else if (compare > 0) {
            return binarySearch(list,
                                target,
                                left,
                                middle - 1);
        }

        // Search right side
        else {
            return binarySearch(list,
                                target,
                                middle + 1,
                                right);
        }
    }
    
}
