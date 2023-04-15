import java.util.Scanner;

//Porcentajes sin Seguro de Invalidez basados en: https://www.afphabitat.cl/por-que-habitat/comisiones-habitat/
public class AFPcalc {

    // Variables de instancia de la clase AFPcalc
    private float salary;
    private float userAFPPercentage;
    private String userAFPmodel;

    public AFPcalc(float salary) {
        this.salary = salary;
    }

    // Método que permite seleccionar el modelo de AFP.
    public void selectAFPModel() {
        Scanner scanner = new Scanner(System.in);

        boolean AFPModelLoop = true;
        String[] AFPModels = {"CAPITAL", "CUPRUM", "HABITAT", "PLANVITAL", "PROVIDA", "MODELO", "UNO"};
        float[] AFPModelsPercentages = {0.1144f, 0.1144f, 0.1127f, 0.1116f, 0.1145f, 0.1058f, 0.1069f};

        while (AFPModelLoop) {
            System.out.print("Ingrese su modelo de AFP (Capital, Cuprum, Habitat, PlanVital, Provida, Modelo, Uno): ");
            String userAFPModel = scanner.nextLine();
            userAFPModel = userAFPModel.toUpperCase();

            // Comprueba si la entrada del usuario se encuentra en la lista de modelos de AFP.
            // Si se encuentra, entonces se establece el porcentaje correspondiente y se sale del ciclo.
            for (int i = 0; i < AFPModels.length; i++) {
                if (userAFPModel.equals(AFPModels[i])) {
                    this.userAFPmodel = userAFPModel;
                    this.userAFPPercentage = AFPModelsPercentages[i];
                    AFPModelLoop = false;
                }
            }
        }
    }

    // Método que devuelve el porcentaje correspondiente al modelo de AFP seleccionado por el usuario.
    public int getUserAFPDiscount() {
        return (int) (this.salary * this.userAFPPercentage);
    }

    public String getUserAFPmodel(){
        return this.userAFPmodel;
    }

    public float getUserAFPPercentage(){
        return userAFPPercentage;
    }
}