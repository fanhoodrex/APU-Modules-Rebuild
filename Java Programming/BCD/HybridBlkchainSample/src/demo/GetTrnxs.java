/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.util.List;
import samples.adapter.TrnxPoolAdapter;
import samples.trnxpool.Transaction;

/**
 *
 * @author jinhern
 */
public class GetTrnxs {
 
    public static void main(String[] args) {
        tst1();
    }
    
    static void tst1(){
        List<Transaction> trnxPool = TrnxPoolAdapter.getTransactions();
        trnxPool.stream().forEach( System.out::println );
    }
    
}
