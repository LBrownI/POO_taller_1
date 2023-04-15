class discountSalary {
    private float salary;
    private float userAFPPercentage;
    private float userPrevitionDiscount;

    public discountSalary(float salary, float userAFPModel, float userPrevitionDiscount, float gratification){
        this.salary = salary + gratification;
        this.userAFPPercentage = userAFPModel;
        this.userPrevitionDiscount = userPrevitionDiscount;
    }

    public float netSalary(){
        return (this.salary - (this.salary * this.userAFPPercentage) - (this.salary * this.userPrevitionDiscount));
    }
}