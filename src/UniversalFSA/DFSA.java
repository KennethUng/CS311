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

public class DFSA {



    private String[] alphabet; // Array for the Alphabets in our current DFSA
    private boolean[] FINAL; // Boolean Array of Final States, false if not final, true if final, any -1 is considered false
    private int[] states; // Our States are indexed from 0 - N-1
    private int[][] transitionFunction; // Table for our Transitions, syntax: Current,Alphabet = next
    private int numOfStates; // This is just to know how many states we have


    public DFSA() {
    }

    /**
     * This method is responsible for checking if a String is accepted in our DFSA or not
     * @param input : the string we are checking to see if it's in our language
     * @return : False if String Rejected, True if String Accepted
     */
    public boolean checkAccept(String input) {
        boolean answer = false;
        int nextState = 0;
        if(input.length() <= 0) {
            nextState = transitionFunction[nextState][0];
            answer = FINAL[nextState];
        }
        else {
            for (int i = 0; i < input.length(); i++) {
                for (int j = 0; j < alphabet.length; j++) {
                    if (input.charAt(i) == alphabet[j].charAt(0)) {
                        nextState = transitionFunction[nextState][j];
                        if(nextState == -1) {
                            return false;
                        }

                        answer = FINAL[nextState];

                    }
                }
            }
        }
        return answer;
    }

    /**
     * This method will set the variables numOfStates and create our FINAL and states array
     * @param numOfStates : how many states is in our current DFSA
     */

    public void setStates(int numOfStates) {
        this.numOfStates = numOfStates; // Probably Redundant and unnecessary
        states = new int[numOfStates];
        FINAL = new boolean[numOfStates];
    }

    /**
     * This method takes the input and sets the state at that index to true
     * @param stateNum : index (state) which is a final state
     */
    public void setFinalStates(int stateNum) {

        FINAL[stateNum] = true;

    }

    /**
     * This method just initializes the alphabet array
     * @param alphabet : the array that we want to initialize our alphabet array into
     */
    public void setAlphabet(String[] alphabet) {
        this.alphabet = alphabet;
    }

    /**
     * This method will initialize the Transition Function
     * @param numOfStates : How many states in machine
     * @param numOfAlphabets : How many Alphabets in machine, we can have more alphabet then states
     */

    public void setTransitionFunction(int numOfStates, int numOfAlphabets) {
        transitionFunction = new int[numOfStates][numOfAlphabets];

    }

    /**
     * This method populates the Transition Function array with values.
     * The syntax is : Current, Alphabet = Next
     * @param originState : State of Interest
     * @param givenAlphabet : Alphabet we are given
     * @param nextState : Next state that we will move to from State x Alphabet
     */

    public void setTransition(int originState, String givenAlphabet, int nextState) {

        int alphabetIndex = 0;

        for(int i = 0; i < alphabet.length; i++) {
            if(alphabet[i].compareTo(givenAlphabet) == 0) {
                alphabetIndex = i;
                break;
            }

        }

        transitionFunction[originState][alphabetIndex] = nextState;

    }




}
