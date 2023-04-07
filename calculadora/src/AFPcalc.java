import java.util.Scanner;

//Porcentajes sin Seguro de Invalidez basados en: https://www.afphabitat.cl/por-que-habitat/comisiones-habitat/
public class AFPcalc {

    // Variables de instancia de la clase AFPcalc
    private boolean AFPModelLoop = true;
    private String[] AFPModels = {"CAPITAL", "CUPRUM", "HABITAT", "PLANVITAL", "PROVIDA", "MODELO", "UNO"};
    private float[] AFPModelsPercentages = {0.1144f, 0.1144f, 0.1127f, 0.1116f, 0.1145f, 0.1058f, 0.1069f};
    private float userAFPPercentage = 0;
    private Scanner scanner;

    public AFPcalc() {
        scanner = new Scanner(System.in);
    }

    // Método que permite seleccionar el modelo de AFP.
    public void selectAFPModel() {
        while (AFPModelLoop) {
            System.out.print("Ingrese su modelo de AFP (Capital, Cuprum, Habitat, PlanVital, Provida, Modelo, Uno): ");
            String userAFPModel = scanner.nextLine();
            userAFPModel = userAFPModel.toUpperCase();

            // Comprueba si la entrada del usuario se encuentra en la lista de modelos de AFP.
            // Si se encuentra, entonces se establece el porcentaje correspondiente y se sale del ciclo.
            for (int i = 0; i < AFPModels.length; i++) {
                if (userAFPModel.equals(AFPModels[i])) {
                    userAFPPercentage = AFPModelsPercentages[i];
                    AFPModelLoop = false;
                }
            }
        }
    }

    // Método que devuelve el porcentaje correspondiente al modelo de AFP seleccionado por el usuario.
    public float getUserAFPPercentage() {
        return userAFPPercentage;
    }
}