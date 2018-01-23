package UniversalFSA;

import java.io.*;
import java.util.Scanner;

public class Driver {

    public static void main (String[] args) {

        String[] transitions;
        String answer = "";

        DFSA universalDFSA = new DFSA();

        /* Representation of the text file that will be inputted into the Program */
        String fileName = "input.txt";


        try {

            /* The scanner (sc) is what we are going to be using to read the input.txt file that holds our DFSAs */
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
            for(int i = 0; i < fStates.length; i ++) {
                universalDFSA.setFinalStates(fStates[i]);
            }
            parser = sc.nextLine();
            String[] arrOfAlphabet = parser.split(" ");
            universalDFSA.setAlphabet(arrOfAlphabet);
            universalDFSA.printAlphabet();
            universalDFSA.setTransitionFunction(numOfStates, arrOfAlphabet.length);
            while(sc.hasNext()) {
                parser = sc.nextLine();
                System.out.println(parser);
                transitions = parser.split(" ");
                if(transitions[0].compareTo("(") == 0) {
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

                    universalDFSA.setTransition(originState,givenAlphabet,nextS);
                }
                else {
                    /*  */
                    boolean accepted = universalDFSA.checkAccept(parser);
                    if(accepted)
                        System.out.println("Accepted");
                    else
                        System.out.println("Rejected");
                    answer += parser + " ";

                }

            }
            System.out.print(answer);


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
