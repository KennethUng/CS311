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
        input.toCharArray();
        return true;
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


}
