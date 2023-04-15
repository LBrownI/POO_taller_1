import java.util.Scanner;

public class GratificationCalc {
    private float salary;
    private float userGratification;
    private String userGratificationElection;

    public GratificationCalc(float salary) {
        this.salary = salary;
    }

    public float getUserGratification() {
        Scanner scanner = new Scanner(System.in);
        positiveIntegerChecker positiveIntegerChecker = new positiveIntegerChecker();

        while(true) {
            System.out.print("Tiene gratificación (si, no, otro): ");
            String userOption = scanner.nextLine();

            if (userOption.equalsIgnoreCase("Si")) {
                this.userGratificationElection = "sí";
                if (this.salary < 649166) {
                    this.userGratification = this.salary * 0.25f;
                } else {
                    this.userGratification = 162292f;
                }
                break;
            } else if (userOption.equalsIgnoreCase("no")) {
                this.userGratificationElection = "no";
                this.userGratification = 0;
                break;
            } else if (userOption.equalsIgnoreCase("otro")) {
                this.userGratificationElection = "otro";
                positiveIntegerChecker.setQuestion("Ingrese su valor de gratificación: ");
                this.userGratification = positiveIntegerChecker.askInteger();
                break;
            }
        }
        return this.userGratification;

    }

    //muestra la elección del usuario en el final del programa Main (en la parte del resumen)
    public String getUserGratificationElection() {
        return userGratificationElection;
    }
}