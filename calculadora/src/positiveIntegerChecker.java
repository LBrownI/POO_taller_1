import java.util.Scanner;

public class positiveIntegerChecker {
    private String question;

    //define the question that would be displayed everytime the user tries to enter a value
    public void setQuestion (String question){
        this.question = question;
    }

    //ask to the user to enter a positive integer
    public float askInteger (){
        Scanner scanner = new Scanner(System.in);
        float integer = -1;

        while (integer < 0) {
            System.out.print(question);
            String input = scanner.nextLine();

            //If the input is a string, then repeat the input request until the user enters a positive integer
            try {
                integer = Integer.valueOf(input);
            } catch (NumberFormatException e) {
                integer = -1;
            }
        }
        return integer;
    }
}