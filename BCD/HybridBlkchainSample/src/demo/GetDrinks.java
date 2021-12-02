package demo;

import samples.adapter.DrinksAdapter;
import java.util.List;
import samples.Coke;
import samples.Drinks;

public class GetDrinks {
    
    public static void main(String[] args) {
         tst1();
        
    }
    
    static void tst1(){
        List<Drinks> all = DrinksAdapter.getDrinks();
        System.out.println("Total of drinks: " + all.size());
        for (Drinks d : all) {
            System.out.println( d.getId() );
            System.out.println( d.getName() );
        }
        System.out.println("\n\n");
        
        List<Coke> allCoke = DrinksAdapter.getCoke();
        System.out.println("Total of Cokes: " + allCoke.size());
        for (Coke d : allCoke) {
            System.out.println( d.getId() );
            System.out.println( d.getName() );
            System.out.println( d.getSlogan() );
        }
    }
    
}
