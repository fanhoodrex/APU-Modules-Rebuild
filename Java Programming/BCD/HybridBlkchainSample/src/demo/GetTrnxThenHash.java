package demo;

import blkchain.shautils.HashingUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.javatuples.Septet;
import samples.adapter.TrnxPoolAdapter;
import samples.trnxpool.Transaction;

public class GetTrnxThenHash {

    public static void main(String[] args) {
        tst1();
    }
    static void tst1(){
        List<Transaction> trnxPool = TrnxPoolAdapter.getTransactions();
        System.out.println("---- All transaction objects ----");
        trnxPool.stream().forEach(System.out::println);
        System.out.println("");
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
        System.out.println("----- All in List collection ----");
        System.out.println( hashLstAll );
        
        
        //for definite 7 items - optional
        List<Septet<String, String, String, String, String, String, String>> hashes = hashLstAll.stream()
                .map( elem -> Septet.fromCollection(elem) )
                .collect(Collectors.toList());
        System.out.println("");
        System.out.println("----- All in Septet -----");
        System.out.println( hashes );
        
    }
    

    
}
