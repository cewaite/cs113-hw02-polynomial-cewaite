package edu.miracosta.cs113;

import java.util.Scanner;

public class PolynomialDriver
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();

        System.out.println("Welcome to the Polynomial Calcualtor!\nThis program can take any two constructed polynomials and add them together!");
        System.out.println("\n1: Edit the First Polynomial\n2: Edit the Second Polynomial\n3: Display the results of adding the two Polynomials\n4: Exit the program");
        System.out.println("Please enter the number associated to the task you would like to do: ");

        boolean validInput = true;

        while (validInput = true)
        {
            validInput = true;
            System.out.println("Please enter the number associated to the task you would like to do: ");
            int input = keyboard.nextInt();
            if (input == 1)
            {
                System.out.println("Would you like to:\n1: Clear the Polynomial\n2: Add terms to the Polynomial\n");
                input = keyboard.nextInt();
                if (input == 1)
                {
                    p1.clear();
                    System.out.println("Polynomial 1 has been cleared");
                }
                else if (input == 2)
                {
                    System.out.println("Please enter the\nCoefficient: ");
                    int coeff = keyboard.nextInt();
                    System.out.println("Please enter the\nExponent: ");
                    int expo = keyboard.nextInt();
                    p1.addTerm(new Term(coeff,expo));
                    System.out.println("The new term has been added to Polynomial 1");
                }
            }
            else if (input == 2)
            {
                System.out.println("Would you like to:\n1: Clear the Polynomial\n2: Add terms to the Polynomial\n");
                input = keyboard.nextInt();
                if (input == 1)
                {
                    p2.clear();
                    System.out.println("Polynomial 2 has been cleared");
                }
                else if (input == 2)
                {
                    System.out.println("Please enter the\nCoefficient: ");
                    int coeff = keyboard.nextInt();
                    System.out.println("Please enter the\nExponent: ");
                    int expo = keyboard.nextInt();
                    p2.addTerm(new Term(coeff,expo));
                    System.out.println("The new term has been added to Polynomial 2");
                }
            }
            else if (input == 3)
            {
                Polynomial p1Original = p1;
                p1.add(p2);
                System.out.println("The added Polynomial is: " + p1.toString());
                p1 = p1Original;
            }
            else if (input == 4)
            {
                System.out.println("Thank you, have a nice day");
                System.exit(0);
            }
            else
            {
                System.out.print("Invalid Input, please try again");
                validInput = false;
            }
        }
    }
}
