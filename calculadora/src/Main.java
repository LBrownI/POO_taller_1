import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        positiveIntegerChecker positiveIntegerChecker = new positiveIntegerChecker();

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

        //ask to the user to enter his prevition type (Fonasa or isapre), if it is Isapre, then ask for his UF plan. The class returns the discount based on the user elections.
        previtionCalc previtionCalc = new previtionCalc(salary);
        float userPrevitionDiscount = previtionCalc.previtionCalcDiscount();

        //ask to the user to enter his gratification if it has.
        positiveIntegerChecker.setQuestion("Ingrese su gratificación (poner 0 si no tiene): ");
        float gratification = positiveIntegerChecker.askInteger();

        discountSalary finalSalary = new discountSalary(salary, userAFPPercentage, userPrevitionDiscount, gratification);
        System.out.print("Su salario final es: " +finalSalary.netSalary());
    }
}