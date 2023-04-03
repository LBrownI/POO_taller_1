package com.mycompany;

class Salary {

    private float gross_Salary;
    private float AFP;
    private String HPinsurance;
    private float planIsapre;
    private float gratification;

    public Salary(float gross_Salary, float AFP, String HPinsurance, float planIsapre, float gratification) {
        this.gross_Salary = gross_Salary;
        this.AFP = AFP;
        this.HPinsurance = HPinsurance;
        this.planIsapre = planIsapre;
        this.gratification = gratification;
    }

    public float calcularSalarioLiquido() {
        // Calcular el descuento por AFP
        float AFPdiscount = gross_Salary * AFP / 100;

        // Calcular el descuento por seguro de salud
        float HPdiscount = 0.0F;
        if (HPinsurance.equalsIgnoreCase("FONASA")) {
            HPdiscount = (float) (gross_Salary * 0.07);
        } else if (HPinsurance.equalsIgnoreCase("ISAPRE")) {
            HPdiscount = (float) (planIsapre * 0.8 / 12);
        }

        // Calcular el salario imponible (salario bruto - descuentos)
        float taxableSalary = gross_Salary - AFPdiscount - HPdiscount;

        // Calcular la gratificación
        float gratificationAmount = gross_Salary * gratification / 100;

        // Calcular el salario líquido (salario imponible + gratificación)
        float netSalary = taxableSalary + gratificationAmount;

        // Redondear el salario líquido a dos decimales
        netSalary = (float) (Math.round(netSalary * 100) / 100.0);

        return netSalary;
    }
}
