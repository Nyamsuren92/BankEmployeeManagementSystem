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
public class MergeSort {

    // Recursive merge sort method
    public void mergeSort(ArrayList<Employee> list) {

        // Stop recursion if list has 1 item
        if (list.size() <= 1) {
            return;
        }

        // Find middle index
        int middle = list.size() / 2;

        // Create left and right lists
        ArrayList<Employee> left = new ArrayList<>();
        ArrayList<Employee> right = new ArrayList<>();

        // Fill left list
        for (int i = 0; i < middle; i++) {
            left.add(list.get(i));
        }

        // Fill right list
        for (int i = middle; i < list.size(); i++) {
            right.add(list.get(i));
        }

        // Recursive calls
        mergeSort(left);
        mergeSort(right);

        // Merge sorted lists
        merge(list, left, right);
    }

    // Merge method
    public void merge(ArrayList<Employee> list,
                      ArrayList<Employee> left,
                      ArrayList<Employee> right) {

        int i = 0;
        int j = 0;
        int k = 0;

        // Compare employee names
        while (i < left.size() && j < right.size()) {

            if (left.get(i).name.compareTo(right.get(j).name) < 0) {

                list.set(k, left.get(i));
                i++;

            } else {

                list.set(k, right.get(j));
                j++;
            }

            k++;
        }

        // Remaining left items
        while (i < left.size()) {

            list.set(k, left.get(i));
            i++;
            k++;
        }

        // Remaining right items
        while (j < right.size()) {

            list.set(k, right.get(j));
            j++;
            k++;
        }
    }
}
