import java.util.Scanner;

public class positiveIntegerChecker {
    private String question;

    public positiveIntegerChecker(){
    }

    //Definir la pregunta que se mostraría cada vez que el usuario intente ingresar un valor.
    public void setQuestion (String question){
        this.question = question;
    }

    //Pide al usuario que introduzca un número entero positivo.
    public float askInteger (){
        Scanner scanner = new Scanner(System.in);
        float integer = -1;

        while (integer < 0) {
            System.out.print(question);
            String input = scanner.nextLine();

            //Si la entrada es una cadena, repite la solicitud de entrada hasta que el usuario ingrese un número entero positivo.
            try {
                integer = Integer.valueOf(input);
            } catch (NumberFormatException e) {
                integer = -1;
            }
        }
        return integer;
    }
}