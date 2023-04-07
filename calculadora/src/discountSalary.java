class discountSalary {
    private float salary;
    private float userAFPPercentage;
    private float userPrevitionDiscount;
    private float gratification;

    public discountSalary(float salary, float userAFPModel, float userPrevitionDiscount, float gratification){
        this.salary = salary;
        this.userAFPPercentage = userAFPModel;
        this.userPrevitionDiscount = userPrevitionDiscount;
        this.gratification = gratification;
    }

    public float netSalary(){
        return (this.salary - (this.salary * this.userAFPPercentage) - (this.salary * this.userPrevitionDiscount));
    }
}