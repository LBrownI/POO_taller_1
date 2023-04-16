import java.util.Scanner;

/**
 * Fuerza al usuario a que ingrese un número entero positivo
 */
public class positiveIntegerChecker {
    private String question;

    /**
     * define la pregunta que será mostrada cada vez que el usuario ingrese un valor por teclado
     * @param question pregunta que será mostrada
     */
    public void setQuestion (String question){
        this.question = question;
    }

    /**
     * pregunta al usuario por un entero positivo.
     * Si ingresa un valor negativo o un texto, se repetirá hasta que ingrese un valor correcto.
     * @return un número entero ingresado por el usuario
     */
    public int askInteger (){
        Scanner scanner = new Scanner(System.in);
        int integer = -1;

        while (integer < 0) {
            System.out.print(question);
            String input = scanner.nextLine();

            /*
             * Si el valor ingresado es un String, entonces volver a pregunar al usuario para ingresar otro valor
             */
            try {
                integer = Integer.valueOf(input);
            } catch (NumberFormatException e) {
                integer = -1;
            }
        }
        return integer;
    }
}