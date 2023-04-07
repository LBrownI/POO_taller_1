import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        positiveIntegerChecker positiveIntegerChecker = new positiveIntegerChecker();

        salaryCalc sCalc = new SalaryCalc();  // Crear una instancia de la clase salaryCalc
        float salary = sCalc.getSalary();     // Llamar al método getSalary() para obtener el salario

        AFPcalc afpCalc = new AFPcalc();      // Crear una instancia de la clase AFPcalc
        afpCalc.selectAFPModel();   // Llamar al método selectAFPModel() para permitir que el usuario seleccione su modelo de AFP
        float userAFPPercentage = afpCalc.getUserAFPPercentage();   // Llamar al método getUserAFPPercentage() para obtener el porcentaje de AFP del usuario

        //Solicita a el usuario que ingrese su tipo de previsión (Fonasa o isapre), si es Isapre, luego solicitar su plan de UF. La clase devuelve el descuento en función de las elecciones del usuario.
        previtionCalc previtionCalc = new previtionCalc(salary);
        float userPrevitionDiscount = previtionCalc.previtionCalcDiscount();

        //Pedir al usuario que introduzca su gratificación si la tiene.
        positiveIntegerChecker.setQuestion("Ingrese su gratificación (poner 0 si no tiene): ");
        float gratification = positiveIntegerChecker.askInteger();

        discountSalary finalSalary = new discountSalary(salary, userAFPPercentage, userPrevitionDiscount, gratification);
        System.out.print("Su salario final es: " +finalSalary.netSalary());
    }
}