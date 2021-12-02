/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samples.adapter;

import blkchain.shautils.HashingUtils;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import samples.trnxpool.Transaction;

/**
 *
 * @author jinhern
 */
public class TrnxPoolAdapter {
    
    private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_DATE_TIME;
    
    public static void main(String[] args) {
        List<Transaction> trnxLst = TrnxPoolAdapter.getTransactions();
        System.out.println( trnxLst );
    }
    
    public static List<Transaction> getTransactions(){
        List<String> trnxLst = Transaction.getAll();
        return trnxLst.stream()
                .map( record -> record.split("\\|") )
                .filter( arr -> !arr[0].equals("ORDERITEM") )
                .map(arr -> new Transaction( arr[0], LocalDateTime.parse(arr[1], FORMATTER), arr[2], arr[3], arr[4], arr[5], LocalDateTime.parse(arr[6], FORMATTER) ))
                .collect( Collectors.toList() );
    }
    
    public static List<List<String>> getTransactionsHashes(){
        List<Transaction> trnxPool = TrnxPoolAdapter.getTransactions();
        //generate hash value of each data in Transaction
            //collect using javatuple
        List<List<String>> hashLstAll = new ArrayList();
        for (Transaction trnx : trnxPool) {
            List<String> hashLst = new ArrayList();
            hashLst.add( HashingUtils.newhash(trnx.getOrderItem(), "SHA-256") );
            hashLst.add( HashingUtils.newhash(trnx.getOrderDt().toString(), "SHA-256") );
            hashLst.add( HashingUtils.newhash(trnx.getPayment(), "SHA-256") );
            hashLst.add( HashingUtils.newhash(trnx.getEmail(), "SHA-256") );
            hashLst.add( HashingUtils.newhash(trnx.getDeliveryAddr(), "SHA-256") );
            hashLst.add( HashingUtils.newhash(trnx.getStatus(), "SHA-256") );
            hashLst.add( HashingUtils.newhash(trnx.getTrnxDt().toString(), "SHA-256") );
            hashLstAll.add(hashLst);
        }
        return hashLstAll;
    }
    
    
}
