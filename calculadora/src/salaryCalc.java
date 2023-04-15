import java.util.Scanner;

public class salaryCalc {

    // Variable de instancia de la clase salaryCalc
    private Scanner scanner;

    // Constructor de la clase salaryCalc
    public salaryCalc() {
        scanner = new Scanner(System.in);
    }

    // Método que permite al usuario ingresar su salario
    public float getSalary() {
        float salary = -1;

        while (salary < 0) {
            System.out.print("Ingrese su sueldo bruto: ");
            String input = scanner.nextLine();

            // Si la entrada es una cadena, se repite la solicitud de entrada hasta que el usuario ingrese un entero
            try {
                salary = Integer.valueOf(input);
            } catch (NumberFormatException e) {
                salary = -1;
            }
        }

        return salary;
    }
}