public class Employee{
    private String employeeName;
    private String title;
    private String address;
    

    public String  getEmployeeName(){
        return this.employeeName;
    }

    public String  getTitle(){
        return this.title;
    }

    public String  getAddress(){
        return this.address;
    }

    public void  setEmployeeName(String name){
        this.employeeName=name;
    }

    public void  setTitle(String title){
        this.title=title;
    }

    public String  getAddress(String add){
        this.address=add;
    }

    public void Employee(){
        
    }

    public void Employee(String name, String title, String add){
        this.employeeName=name;
        this.title=title;
        this.address=add;
    }



}