import java.util.Scanner;

/**
 * pregunta al usuario por su tipo de contrato (indefinido o fijo).
 */
public class contratcType {
    private String userContractType;
    private float salary;
    private float salaryAfterContractType;

    /**
     * guarda el salario del usuario para hacer los cálculos
     * @param salary salario del usuario
     */
    public contratcType(float salary){
        this.salary = salary;
    }

    /**
     * pregunta al usuario por su tipo de contrato y calcula el descuento.
     * @return descuento seguro cesantia correspondiente a lo elegido por el usuario
     * <li>En caso de haber elegido "indefinido", devuelve el salario * 0.6%</li>
     * <li>En caso de haber elegido "fijo", devuelve 0</li>
     */
    public int getContractType() {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("Que tipo de contrato tiene (indefinido, fijo): ");
            String userContractType = scanner.nextLine();

            if(userContractType.equalsIgnoreCase("indefinido")){
                this.userContractType = "Indefinido";
                this.salaryAfterContractType = this.salary * 0.006f;
                break;
            }
            else if(userContractType.equalsIgnoreCase("fijo")){
                this.userContractType = "FIjo";
                this.salaryAfterContractType = 0;
                break;
            }
        }
        return Math.round(this.salaryAfterContractType);
    }

    /**
     * @return el tipo de contrato elegido por el usuario (indefinido o fijo)
     */
    public String getUserContractType() {
        return this.userContractType;
    }
}