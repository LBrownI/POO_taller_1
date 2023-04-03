package com.mycompany;

import java.util.Scanner;

public class Calc {

    public static void main(String[] args) {

        // Crear objeto Scanner para leer la entrada del usuario
        Scanner input = new Scanner(System.in);

        // Solicitar el ingreso de los elementos por teclado
        System.out.print("Ingrese el salario bruto: ");
        float gross_Salary = input.nextFloat();

        System.out.print("Ingrese el porcentaje de AFP actual (ejemplo: 10): ");
        float AFP = input.nextFloat();

        System.out.print("Ingrese el tipo de seguro de salud (Fonasa o Isapre): ");
        String HPinsurance = input.next();

        float planIsapre = 0.0F;
        if (HPinsurance.equalsIgnoreCase("isapre")) {
            System.out.print("Ingrese el valor del plan en UF: ");
            planIsapre = input.nextFloat();
        }

        System.out.print("Ingrese la gratificación (coloque 0 si no tiene): ");
        float gratification = input.nextFloat();

        // Crear objeto de la clase Salary
        Salary salary = new Salary(gross_Salary, AFP, HPinsurance, planIsapre, gratification);

        // Calcular el salario líquido y mostrar el resultado
        float netSalary = salary.calcularSalarioLiquido();
        System.out.println("El salario líquido es: $" + netSalary);

        // Cerrar el objeto Scanner
        input.close();
    }
}
