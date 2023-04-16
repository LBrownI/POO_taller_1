import java.util.Scanner;
/**
 * pregunta al usuario sobre su AFP y calcula el descuento respecto a su salario
 * Porcentajes sin Seguro de Invalidez basados en: https://www.afphabitat.cl/por-que-habitat/comisiones-habitat/
 */
public class AFPcalc {
    private float salary;
    private float userAFPPercentage;
    private String userAFPmodel;

    /**
     * guarda el salario del usuario para hacer los cálculos
     * @param salary salario del usuario
     */
    public AFPcalc(float salary) {
        this.salary = salary;
    }

    /**
     * pregunta al usuario por su modelo de AFP
     */
    public void selectAFPModel() {
        Scanner scanner = new Scanner(System.in);

        boolean AFPModelLoop = true;
        String[] AFPModels = {"CAPITAL", "CUPRUM", "HABITAT", "PLANVITAL", "PROVIDA", "MODELO", "UNO"};
        float[] AFPModelsPercentages = {0.1144f, 0.1144f, 0.1127f, 0.1116f, 0.1145f, 0.1058f, 0.1069f};

        while (AFPModelLoop) {
            System.out.print("Ingrese su modelo de AFP (Capital, Cuprum, Habitat, PlanVital, Provida, Modelo, Uno): ");
            String userAFPModel = scanner.nextLine();
            userAFPModel = userAFPModel.toUpperCase();

            /*
             * compureba si la entrada del usuario se encuentra en la lista de modelos de AFP.
             * Si se encuentra, entonces se le establece su porcentaje correspondiente y sale del bucle.
             */
            for (int i = 0; i < AFPModels.length; i++) {
                if (userAFPModel.equals(AFPModels[i])) {
                    this.userAFPmodel = userAFPModel;
                    this.userAFPPercentage = AFPModelsPercentages[i];
                    AFPModelLoop = false;
                }
            }
        }
    }

    /**
     * @return decuento de la AFP del usuario respecto a su salario
     */
    public int getUserAFPDiscount() {
        return Math.round((this.salary * this.userAFPPercentage));
    }

    /**
     * @return modelo de AFP del usuario
     */
    public String getUserAFPmodel(){
        return this.userAFPmodel;
    }

    /**
     * @return el porcentaje del modelo AFP del usuario
     */
    public float getUserAFPPercentage(){
        return userAFPPercentage;
    }
}