import java.util.Scanner;

public class previtionCalc {
    private float salary;
    private String userPrevition;
    private float UFPlan;

    public previtionCalc(float salary){
        this.salary = salary;
    }

    public float previtionCalcDiscount() {
        //objects
        Scanner scanner = new Scanner(System.in);
        positiveIntegerChecker positiveIntegerChecker = new positiveIntegerChecker();

        //global variables
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

                //calculate the discount applied to his UFPlan selectd
                float UF = 35630.06f;       //UF value (06/04/2023)
                userPrevitionDiscount = (UF * this.UFPlan);
                break;
            }
        }
        return (userPrevitionDiscount);
    }

    public String getUserPrevition() {
        return userPrevition;
    }

    public float getUFPlan() {
        return UFPlan;
    }
}