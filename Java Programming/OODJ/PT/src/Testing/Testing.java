/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Patrick Tan
 */
class A{
    List<B> BList;
    private String ID;
    private String Name;
    public A(String ID,String Name){
        setID(ID);
        setName(Name);
    }

    public void setBList(List<B> BList) {
        this.BList = BList;
    }
    public List<B> getBList() {
        return BList;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }
    private void setID(String ID){
        this.ID = ID;
    }
    private void setName(String Name){
        this.Name = Name;
    }
}
class B{
    private String Beverage;
    private String Food;
    public B(){
    
    }
    public void setOrder(String b,String f){
        setBeverage(b);
        setFood(f);
    }
    private void setBeverage(String Beverage){
        this.Beverage = Beverage;
    }
    private void setFood(String Food){
        this.Food = Food;
    }
    public String getBeverage() {
        return Beverage;
    }

    public String getFood() {
        return Food;
    }
    @Override
    public String toString() {
        return "Food: " + getFood() + " | Beverage:" + getBeverage();
    }
}
public class Testing {
    public static void main(String[] args){
        A Patrick = new A("001","Patrick");
        B Order = new B();
        Order.setOrder("Nasi Lemak", "Orange Juice");
        B Order2 = new B();
        Order2.setOrder("Nasi Lemak2", "Orange Juice2");
        List<B> orders = new ArrayList();
        orders.add(Order);
        orders.add(Order2);
        Patrick.setBList(orders);
        System.out.println(Patrick.getBList());
    }
}
