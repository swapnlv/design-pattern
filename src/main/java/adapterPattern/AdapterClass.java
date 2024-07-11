public class Adapter extends Employee implements TargetCustomer{
    public String getname(){
        return this.getEmployeeName();
    }
    
    public String getJobDesc(){
        return this.getTitle();
    }
    
    public String getAddress(){
        return this.getEmpAddress();
    }
}