/**
 *
 * Kenneth Ung
 * 1/28/18
 * CS311.02
 * Project # 1: Universal Finite State Automata
 *
 *
 *
 *
 */
package UniversalFSA;

import java.io.*;
import java.util.Scanner;

public class Driver {

    public static void main (String[] args) {

        int counter = 0; // Will be used for a print statement that keeps track of what # automaton we are on

        String[] transitions; // Constantly changes, used as a helper variable to implement the transition into our transition table

        DFSA universalDFSA = new DFSA(); // Our Universal DFSA Object, which does all of the computing in our program

        /* Representation of the text file that will be inputted into the Program */
        String fileName = "input.txt";


        try {

            /* The scanner (sc) is what we are going to be using to read the input.txt file that holds our DFSAs */
            Scanner sc = new Scanner(new File(fileName));

            /* This while loop will iterate until we reach End of File */
            while (sc.hasNext()) {
                System.out.println("Finite State Automaton #" + ++counter);
                int numOfStates = sc.nextInt();
                System.out.println("(1) number of states: " + numOfStates);
                universalDFSA.setStates(numOfStates);
                sc.nextLine();
                String parser = sc.nextLine();
                System.out.println("(2) final states: " + parser);
                /* This is where we start creating separate arrays for each line of the file */
                String[] arrOfFinal = parser.split(","); // For Final States, I separated them with comma
                int[] finalStates = new int[arrOfFinal.length];
                for (int i = 0; i < arrOfFinal.length; i++) { // This for loop is responsible for assigning the final states
                    finalStates[i] = Integer.parseInt(arrOfFinal[i]);
                }
                for (int i = 0; i < finalStates.length; i++) { // This loop sets final States of current DFSA
                    universalDFSA.setFinalStates(finalStates[i]);
                }
                parser = sc.nextLine();
                System.out.println("(3) alphabets: " + parser);
                String[] arrOfAlphabet = parser.split(" ");//Alphabets are lines that have a space inbetween them
                universalDFSA.setAlphabet(arrOfAlphabet);
                universalDFSA.setTransitionFunction(numOfStates, arrOfAlphabet.length);
                System.out.println("(4) transitions: ");
                parser = sc.nextLine();
                /* This while loop will keep going until we no longer have transition functions and is responsible for setting transition functions */
                while (parser.startsWith("(")) { // Transitions start with ( character and are separated by spaces
                    transitions = parser.split(" ");
                    int originState = Integer.parseInt(transitions[1]);
                    String givenAlphabet = transitions[2];
                    String nextState = transitions[3];
                    int nextS;
                    if (nextState == " ") {
                        nextS = -1;
                    } else {
                        nextS = Integer.parseInt(nextState);
                    }
                    universalDFSA.setTransition(originState, givenAlphabet, nextS);
                    System.out.println("     " + originState + " " + givenAlphabet + " " + nextS);
                    parser = sc.nextLine();
                }
                System.out.println("(5) Strings: ");
                /* This while loop is where we start checking strings to see whether or not they are accepted by our DFSA */
                while (!parser.startsWith("/") && sc.hasNext()) {
                    System.out.print("       " + parser);
                    boolean accepted = universalDFSA.checkAccept(parser);
                    if (accepted)
                        System.out.println(" Accepted");
                    else
                        System.out.println(" Rejected");

                    parser = sc.nextLine();
                }
                System.out.println("\n\n\n");
            }
        }
        catch(FileNotFoundException notFound) {
            System.out.println("Unable to open file '" + fileName + "'");
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }


    }
}
