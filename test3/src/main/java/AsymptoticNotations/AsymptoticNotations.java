/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AsymptoticNotations;

/**
 *
 * @author ADMIN
 */
public class AsymptoticNotations {
    // Example of Big-O Notation (O-notation)
    public static void bigONotation(int n) {
        System.out.println("Big-O Notation Example:");
        // O(n) Example - Linear Time Complexity
        for (int i = 0; i < n; i++) {
            System.out.println("Step " + i); // Executes n times
        }
        System.out.println();
    }

    // Example of Omega Notation (Ω-notation)
    public static void omegaNotation(int n) {
        System.out.println("Omega Notation Example:");
        // Ω(n) Example - Best Case Time Complexity
        if (n > 0) {
            System.out.println("Best case executed."); // Executes once
        }
        System.out.println();
    }

    // Example of Theta Notation (Θ-notation)
    public static void thetaNotation(int n) {
        System.out.println("Theta Notation Example:");
        // Θ(n) Example - Both Upper and Lower Bounds
        for (int i = 0; i < n; i++) {
            System.out.println("Step " + i); // Executes exactly n times
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 5; // Input size
        
        bigONotation(n);  // Demonstrate Big-O Notation
        omegaNotation(n); // Demonstrate Omega Notation
        thetaNotation(n); // Demonstrate Theta Notation
    }
}
