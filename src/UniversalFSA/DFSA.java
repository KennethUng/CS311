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
        int initialState = 0;
        int nextState = 0; //Representation of the current state you are in
        for(int i = 0; i < input.length(); i ++) {
            for(int j = 0; j < alphabet.length; j ++) {
                if(input.charAt(i) == alphabet[j].charAt(0)) {
                    nextState = transitionFunction[nextState][j];
                    answer = FINAL[nextState];

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

    public void setTransition(int originState, int givenAlphabet, int nextState) {

        transitionFunction[originState][givenAlphabet] = nextState;

    }

    public void printTransitionFunction() {
        for(int i = 0; i < numOfStates; i++) {
            for(int j = 0; j < alphabet.length; j++) {
                System.out.println("Current State : " + i + "\nAlphabet Given: " + j + "\nNext State: " + transitionFunction[i][j]);

            }

        }
    }


}
