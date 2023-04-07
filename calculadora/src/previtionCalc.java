import java.util.Scanner;

public class previtionCalc {
    private float salary;

    public previtionCalc(float salary){
        this.salary = salary;
    }

    public float previtionCalcDiscount() {
        //objetos
        Scanner scanner = new Scanner(System.in);
        positiveIntegerChecker positiveIntegerChecker = new positiveIntegerChecker();

        //Variables globales
        float UFPlan = 0;
        float userPrevitionDiscount = 0;

        while (true) {
            System.out.print("Ingrese su tipo de preivisón (Fonasa, Isapre): ");
            String userPrevition = scanner.nextLine();
            userPrevition = userPrevition.toUpperCase();

            if (userPrevition.equals("FONASA")) {
                userPrevitionDiscount = this.salary * 0.07f;
                break;
            }
            else if (userPrevition.equals("ISAPRE")) {
                positiveIntegerChecker.setQuestion("Ingrese su plan de salud UF: ");
                userPrevitionDiscount = positiveIntegerChecker.askInteger();

                //Calcula el descuento aplicado a su UFPlan seleccionado
                float UF = 35568.59f;       //Valor del UF (06/04/2023)
                userPrevitionDiscount = this.salary - (UF * UFPlan);
                break;
            }
        }
        return (userPrevitionDiscount);
    }
}