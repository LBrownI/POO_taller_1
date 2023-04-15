import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        positiveIntegerChecker positiveIntegerChecker = new positiveIntegerChecker();

        salaryCalc sCalc = new salaryCalc();  // Crear una instancia de la clase salaryCalc
        float salary = sCalc.getSalary();     // Llamar al método getSalary() para obtener el salario

        //ask to the user to enter his gratification if it has.
        GratificationCalc gratificationCalc = new GratificationCalc(salary);
        int gratification = (int) gratificationCalc.getUserGratification();
        salary = salary + gratification;

        AFPcalc afpCalc = new AFPcalc(salary);      // Crear una instancia de la clase AFPcalc
        afpCalc.selectAFPModel();   // Llamar al método selectAFPModel() para permitir que el usuario seleccione su modelo de AFP
        int userAFPDiscount = afpCalc.getUserAFPDiscount();   // Llamar al método getUserAFPPercentage() para obtener el porcentaje de AFP del usuario

        //Solicita a el usuario que ingrese su tipo de previsión (Fonasa o isapre), si es Isapre, solicitar su plan de UF. La clase devuelve el descuento en función de las elecciones del usuario.
        previtionCalc previtionCalc = new previtionCalc(salary);
        int userPrevitionDiscount = (int) previtionCalc.previtionCalcDiscount();


        System.out.println("============================================");
        System.out.println("Resumen: \n");
        System.out.printf("- Gratifiación (%s): +%d$\n", gratificationCalc.getUserGratificationElection(), gratification);
        System.out.printf("- Modelo AFP (%s) (%.2f%%): -%d$\n", afpCalc.getUserAFPmodel(), afpCalc.getUserAFPPercentage() * 100, userAFPDiscount);
        if(previtionCalc.getUserPrevition().equalsIgnoreCase("fonasa")){
            System.out.printf("- Prevision (%s) (7%%): -%d$\n", previtionCalc.getUserPrevition(), userPrevitionDiscount);
        }
        else {
            System.out.printf("- Previsión (%s) (%.2f UF plan): -%d$\n", previtionCalc.getUserPrevition(), previtionCalc.getUFPlan() ,userPrevitionDiscount);
        }

        int finalSalary = Math.round(salary - userAFPDiscount - userPrevitionDiscount);
        System.out.printf("\nEl sueldo líquido es: %d\n", finalSalary);
        System.out.println("============================================");
    }
}