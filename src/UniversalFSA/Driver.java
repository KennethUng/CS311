package UniversalFSA;

import java.io.*;
import java.util.Scanner;

public class Driver {

    public static void main (String[] args) {

        String[] transitions;

        DFSA universalDFSA = new DFSA();

        /* Representation of the text file that will be inputted into the Program */
        String fileName = "input.txt";


        try {

            Scanner sc = new Scanner(new File(fileName));
            int numOfStates = sc.nextInt();
            universalDFSA.setStates(numOfStates);
            sc.nextLine();
            String parser = sc.nextLine();
            String[] arrOfFinal = parser.split(" , ");
            int[] fStates = new int[arrOfFinal.length];
            for(int i = 0; i < arrOfFinal.length;i++) {
                fStates[i] = Integer.parseInt(arrOfFinal[i]);
            }
            parser = sc.nextLine();
            String[] arrOfAlphabet = parser.split(" ");
            System.out.println();
            universalDFSA.setAlphabet(arrOfAlphabet);
            universalDFSA.printAlphabet();
            System.out.println("Alphabet length: " + arrOfAlphabet.length);
            universalDFSA.setTransitionFunction(numOfStates, arrOfAlphabet.length);
            while(sc.hasNext()) {
                parser = sc.nextLine();
                System.out.println(parser);
                transitions = parser.split(" ");
                for(int i = 0; i < transitions.length; i ++) {
                    System.out.print(transitions[i]);
                }
                if(transitions[0].compareTo("(") == 0) {
                    System.out.println("I'm here");
                    int originState = Integer.parseInt(transitions[1]);
                    System.out.println(originState);
                    int givenAlphabet = Integer.parseInt(transitions[2]);
                    String nextState = transitions[3];
                    int nextS;
                    if(nextState == " "){
                        nextS = -1;
                    }
                    else {
                        nextS = Integer.parseInt(transitions[3]);
                    }
                    System.out.println(givenAlphabet);

                    universalDFSA.setTransition(originState,givenAlphabet,nextS);
                }
                else {
                }

            }


        }


//        try {
//            FileReader fileReader = new FileReader(fileName);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            while((line = bufferedReader.readLine()) != null) {
//                System.out.println(line);
//                char[] test = line.toCharArray();
//
//            }
//            bufferedReader.close();
//        }
        catch(FileNotFoundException notFound) {
            System.out.println("Unable to open file '" + fileName + "'");
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }


    }
}
