import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Enter salary
        float salary = -1;

        while (salary < 0) {
            System.out.print("Ingrese su sueldo bruto: ");
            String input = scanner.nextLine();

            //If the input is a string, then repeat the input request until the user enters an integer
            try {
                salary = Integer.valueOf(input);
            } catch (NumberFormatException e) {
                salary = -1;
            }
        }

        //enter AFPmodel
        boolean AFPModelLoop = true;
        String[] AFPModels = {"CAPITAL", "CUPRUM", "HABITAT", "PLANVITAL", "PROVIDA", "MODELO", "UNO"};
        float[] AFPModelsPercentages = {0.10f, 0.20f, 0.30f, 0.40f, 0.50f, 0.60f, 0.70f};       //Example percentages

        float userAFPPercentage = 0;
        while (AFPModelLoop) {
            System.out.print("Ingrese su modelo de AFP (Capital, Cuprum, Habitat, PlanVital, Provida, Modelo, Uno): ");
            String userAFPModel = scanner.nextLine();
            userAFPModel = userAFPModel.toUpperCase();

            //checks if the input is in the AFP model list, if it is, then set his correspond percentage and break the loop
            for (int i = 0; i < AFPModels.length; i++) {
                if (userAFPModel.equals(AFPModels[i])) {
                    userAFPPercentage = AFPModelsPercentages[i];
                    AFPModelLoop = false;
                }
            }
        }

        //Enable loop for prevition request
        boolean previtionLoop = true;

        //global variables
        float UFPlan = 0;
        float userPrevitionPercentage = 0;

        while (previtionLoop) {
            System.out.print("Ingrese su tipo de preivisón (Fonasa, Isapre): ");
            String userPrevition = scanner.nextLine();
            userPrevition = userPrevition.toUpperCase();

            if (userPrevition.equals("FONASA")) {
                userPrevitionPercentage = 0.3f;           //example value
                previtionLoop = false;
            }
            if (userPrevition.equals("ISAPRE")) {
                UFPlan = -1;

                while (UFPlan < 0) {
                    System.out.print("Ingrese su plan de salud UF: ");
                    String input = scanner.nextLine();

                    try {
                        UFPlan = Integer.valueOf(input);
                    } catch (NumberFormatException e) {
                        UFPlan = -1;
                    }
                }
                previtionLoop = false;
            }
        }

        float gratification = 0;
        //...


        discountSalary finalSalary = new discountSalary(salary, userAFPPercentage, userPrevitionPercentage, UFPlan, gratification);
        System.out.print(finalSalary.netSalary());

    }
}