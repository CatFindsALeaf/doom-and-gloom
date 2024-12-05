import java.util.Scanner;

/**
 * This program can take commands to compute basic integer operations.
 *
 * Date Last Modified: 11/10/2024
 * @author Elliot Kucharski
 * CS1122 Lab Section 2 Fall 2024
 */
public class Gloom {

    private char[] cmd;                         //the command that is passed in
    private Stack<Integer> stk = new Stack<>(); //the stack used to handle integer operations
    private Doom<String, Integer> doom;         //the Doom map the key-value pairs are stored in

    /**
     * The constructor for the Gloom class
     *
     * @param cmd the command that is passed in
     * @param doom the map the key-value pairs are stored in (it probably shouldn't be stored in the object but whatever)
     */
    public Gloom(String cmd, Doom doom) {
        cmd += " ";
        this.doom = doom;
        this.cmd = cmd.toCharArray();
        parse();
    }

    /**
     * Handles the command passed in
     */
    private void parse() {
        String varName = "";
        int i = 0;
        boolean storeVar = false;
        boolean printVar = false;

        while(i < cmd.length) {
            if(cmd[i] == '=') { //assign value to doom map
                storeVar = true;
                i++;
                while(cmd[i] == ' ') {
                    i++;
                }

                while((cmd[i] > 64 && cmd[i] < 91) || (cmd[i] > 96 && cmd[i] < 123)) {
                    varName += cmd[i];
                    i++;
                }
            }

            if(cmd[i] == '!') { //print out variable, should have nothing following the variable in the command
                printVar = true;
                i++;
                while(cmd[i] == ' ') {
                    i++;
                }

                while((cmd[i] > 64 && cmd[i] < 91) || (cmd[i] > 96 && cmd[i] < 123)) {
                    varName += cmd[i];
                    i++;
                }
            }

            if(cmd[i] > 47 && cmd[i] < 58) { //reads integers in the command
                stk.push((int)cmd[i] - 48);
            }

            if(cmd[i] == '+') { //adds previous two integers in the command
                add();
            }

            if(cmd[i] == '-') {
                subtract();
            }

            if(cmd[i] == '*') {
                multiply();
            }

            if(cmd[i] == '/') {
                divide();
            }

            i++;
        }

        if(storeVar) {
            doom.put(varName, stk.pop());
            while(!stk.isEmpty()) {
                stk.pop();
            }
        }

        if(printVar) {
            System.out.println(doom.get(varName));
        }
    }

    /**
     * Adds the two integers on the top of the stack
     */
    private void add() {
        int a = stk.pop();
        int b = stk.pop();
        stk.push(b + a);
    }

    /**
     * Subtracts the two integers on the top of the stack
     */
    private void subtract() {
        int a = stk.pop();
        int b = stk.pop();
        stk.push(b - a);
    }

    /**
     * Multiplies the two integers on the top of the stack
     */
    private void multiply() {
        int a = stk.pop();
        int b = stk.pop();
        stk.push(b * a);
    }

    /**
     * Divides the two integers on the top of the stack
     */
    private void divide() {
        int a = stk.pop();
        int b = stk.pop();
        stk.push(b / a);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Doom<String, Integer> doom = new Doom<>();

        System.out.println("Hello, please enter a command:");

        while(true) {
            String cmd = sc.nextLine();
            Gloom g = new Gloom(cmd, doom);
        }
    }
}