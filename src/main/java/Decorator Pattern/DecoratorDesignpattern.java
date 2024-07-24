/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
abstract class BasePizza{
    
    public abstract int cost();
}

abstract class Toppings extends BasePizza{
    
}

class Margherita extends BasePizza{
    int margheritaCost=100;
    
    @Override
    public int cost(){
        return margheritaCost;
    }
}

class FarmHouse extends BasePizza{
    int farmHouseCost=150;
    
    @Override
    public int cost(){
        return farmHouseCost;
    }
}

class ExtraCheese extends Toppings{
    BasePizza basePizza;
    
    public ExtraCheese(BasePizza pizza){
        this.basePizza=pizza;
    }
    
    @Override
    public int cost(){
        return this.basePizza.cost()+70;
    }
}
class ExtraSweetCorn extends Toppings{
    BasePizza basePizza;
    
    public ExtraSweetCorn(BasePizza pizza){
        this.basePizza=pizza;
    }
    
    @Override
    public int cost(){
        return this.basePizza.cost()+40;
    }
}
public class Kitchen
{
	public static void main(String[] args) {
	    
	    
	    BasePizza pizza1=new ExtraCheese(new ExtraSweetCorn(new FarmHouse()));
	    
	    
	    
		System.out.println("Margherita Pizza Cost: " + pizza1.cost());
	}
}