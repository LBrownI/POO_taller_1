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

        while (AFPModelLoop) {
            System.out.print("Ingrese su modelo de AFP (Capital, Cuprum, Habitat, PlanVital, Provida, Modelo, Uno): ");
            String userAFPModel = scanner.nextLine();
            userAFPModel = userAFPModel.toUpperCase();

            //checks if the input is in the AFP model list, if it is, break the loop
            for (int i = 0; i < AFPModels.length; i++) {
                if (userAFPModel.equals(AFPModels[i])) {
                    AFPModelLoop = false;
                }
            }
        }

        //Enter prevetion type
        boolean previtionLoop = true;
        String[] previtionTipes = {"FONASA", "ISAPRE"};

        while (previtionLoop){
            System.out.print("Ingrese su tipo de preivisón (Fonasa, Isapre): ");
            String userPrevition = scanner.nextLine();
            userPrevition = userPrevition.toUpperCase();

            for (int i = 0; i < previtionTipes.length; i++) {
                if(userPrevition.equals(previtionTipes[i])) {

                    if (i == 1) {

                        //Enter UF plan if Isapre (i == 1) is selected
                        float UFplan = -1;

                        while (UFplan < 0) {
                            System.out.print("Ingrese su plan de salud UF: ");
                            String input = scanner.nextLine();

                            try {
                                UFplan = Integer.valueOf(input);
                            } catch (NumberFormatException e) {
                                UFplan = -1;
                            }
                        }

                    }
                    previtionLoop = false;
                }
            }
        }
    }
}