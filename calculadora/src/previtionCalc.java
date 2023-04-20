import java.util.Scanner;

/**
 * Pregunta al usuario su tipo de previsión y la calcula respecto al salario ingresado
 */
 public class previtionCalc {
    private float salary;
    private String userPrevition;
    private float UFPlan;

    /**
     * Guarda el valor del salario ingresado por el usuario
     * @param salary salario ingresado por la persona
     */
    public previtionCalc(float salary){
        this.salary = salary;
    }

    /**
     * pregunta al usuario por su tipo de prevision.
     * Si no elige una de las opciones (Fonasa o Isapre), se le preguntará denuevo.
     * @return devuelve el salario del usuario con su correspondiente descuento aplicado
     * <li>En caso de haber elegido "Fonasa", devuelve salario * 7%</li>
     * <li>En caso de haber elegido "Isapre", devuelve el valor de un UF (15/04/2023) * el plan UF ingresado por el usuario</li>
     */
    public int previtionCalcDiscount() {

        Scanner scanner = new Scanner(System.in);
        positiveIntegerChecker positiveIntegerChecker = new positiveIntegerChecker();

        /**
        variables globales
         */
        float UFPlan = 0;
        float userPrevitionDiscount = 0;

        while (true) {
            System.out.print("Ingrese su tipo de preivisón (Fonasa, Isapre): ");
            String userPrevition = scanner.nextLine();
            userPrevition = userPrevition.toUpperCase();

            if (userPrevition.equals("FONASA")) {
                this.userPrevition = "Fonasa";
                userPrevitionDiscount = this.salary * 0.07f;
                break;
            }
            else if (userPrevition.equals("ISAPRE")) {
                this.userPrevition = "Isapre";
                positiveIntegerChecker.setQuestion("Ingrese su plan de salud UF: ");
                this.UFPlan = positiveIntegerChecker.askInteger();

                float UF = 35643.05f;       //valor de un UF (15/04/2023)
                userPrevitionDiscount = (UF * this.UFPlan);
                break;
            }
        }
        return Math.round(userPrevitionDiscount);
    }

    /**
     * @return devuelve la prevision elegida por el usuario
     */
    public String getUserPrevition() {
        return userPrevition;
    }

    /**
     * @return devuelve el plan UF del usuario
     */
    public float getUFPlan() {
        return UFPlan;
    }
}