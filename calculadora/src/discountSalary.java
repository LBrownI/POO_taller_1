class discountSalary {
    private float salary;
    private float userAFPPercentage;
    private float userPrevitionPercentage;
    private float UFPlan;
    private float gratification;

    public discountSalary(float salary, float userAFPModel, float userPrevitionPercentage, float UFPlan, float gratification){
        this.salary = salary;
        this.userAFPPercentage = userAFPModel;
        this.userPrevitionPercentage = userPrevitionPercentage;
        this.UFPlan = UFPlan;
        this.gratification = gratification;
    }

    public float netSalary(){
        return (this.salary - (this.salary * this.userAFPPercentage) - (this.salary * this.userPrevitionPercentage));
    }

}