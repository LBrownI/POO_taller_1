public class Main {
    public static void main(String[] args) {

        positiveIntegerChecker positiveIntegerChecker = new positiveIntegerChecker();

        /*
         * LLama a la clase positiveIntegerCheker para obtener el salario del usuario
         */
        positiveIntegerChecker.setQuestion("Ingrese su sueldo bruto: ");
        float salary = positiveIntegerChecker.askInteger();

        /*
         * Llama a la clase GratificationCacl para obtener la gratificación del usuario. Después sumarla con el salario
         */
        GratificationCalc gratificationCalc = new GratificationCalc(salary);
        int gratification = (int) gratificationCalc.getUserGratification();
        salary = salary + gratification;

        /*
         * Llama a la clase AFPcalc para obtener el modelo de AFP del usuario, además de calcular el descuento
         */
        AFPcalc afpCalc = new AFPcalc(salary);
        afpCalc.selectAFPModel();
        int userAFPDiscount = (afpCalc.getUserAFPDiscount());

        /*
         * LLama a la clase previtionCalc para obtener el tipo de previsión del usuario, además de calcular el descuento
         */
        previtionCalc previtionCalc = new previtionCalc(salary);
        int userPrevitionDiscount = (int) previtionCalc.previtionCalcDiscount();

        /*
         * Muestra un resumen de las elecciones del usuario, junto con el decuento aplicado por cada categoria
         */
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
        System.out.printf("\nSu sueldo líquido es: %d$\n", finalSalary);
        System.out.println("============================================");
    }
}