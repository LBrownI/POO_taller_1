import java.util.Scanner;

/**
 * Pregunta al usuario si tiene gratificación.
 * Si tiene, la calcula respecto al salario ingresado.
 */
public class GratificationCalc {
    private float salary;
    private float userGratification;
    private String userGratificationElection;

    /**
     * guarda el salario del usuario para hacer los cálculos
     * @param salary salario del usuario
     */
    public GratificationCalc(float salary) {
        this.salary = salary;
    }

    /**
     * pregunta al usuario si tiene gratifiacion. En caso de tenerla, se le calcula respecto a su salario ingresado.
     * @return gratificación correspondiente a lo elegido por el usuario
     * <li>En caso de haber elegido "si":  </li>
     *     <ul><li>si el salario es menor que 649166$, devuelve salario * 25%</li></ul>
     *     <ul><li>si el salario es mayor que 649166$, devuelve 162292$</li></ul>
     * <li>En caso de haber elegido "no", la gratificación devuelve 0</li>
     * <li>En caso de haber elegido "otro", la gratificación devuelve el valor ingresado</li>
     */
    public int getUserGratification() {
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
        return Math.round(this.userGratification);

    }

    /**
     * @return devuelve la elección que hizo el usuario sobre su gratifiación (si, no, otro)
     */
    public String getUserGratificationElection() {
        return userGratificationElection;
    }
}