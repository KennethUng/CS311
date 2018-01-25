package UniversalFSA;

public class DFSA {



    private String[] alphabet;
    private boolean[] FINAL;
    private int[] states;
    private int[][] transitionFunction;
    private int numOfStates;


    public DFSA() {
    }

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

    public void setStates(int numOfStates) {
        this.numOfStates = numOfStates;
        states = new int[numOfStates];
        FINAL = new boolean[numOfStates];
    }

    public void printStates() {
        for(int i = 0; i < states.length; i++) {
                System.out.print(states[i] + " | ");

        }
    }

    public void setFinalStates(int stateNum) {

        FINAL[stateNum] = true;

    }

    public void setAlphabet(String[] alphabet) {
        this.alphabet = alphabet;
    }

    public void printAlphabet() {
        for(int i = 0; i < alphabet.length; i ++) {
            System.out.println(alphabet[i]);
        }
    }

    public void setTransitionFunction(int numOfStates, int numOfAlphabets) {
        transitionFunction = new int[numOfStates][numOfAlphabets];

    }

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

    public void printTransitionFunction() {
        for(int i = 0; i < numOfStates; i++) {
            for(int j = 0; j < alphabet.length; j++) {
                System.out.println("Current State : " + i + "\nAlphabet Given: " + j + "\nNext State: " + transitionFunction[i][j]);

            }

        }
    }

    public void printTransitionFunction(int state, int alphabet) {
        System.out.println(state + " " + alphabet + " " + transitionFunction[state][alphabet]);
    }


}
