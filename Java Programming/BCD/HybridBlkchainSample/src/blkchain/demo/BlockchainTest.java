package blkchain.demo;

import blkchain.core.Block;
import blkchain.core.Blockchain;
import com.google.gson.GsonBuilder;
import java.util.LinkedList;
import java.util.List;
import samples.adapter.TrnxPoolAdapter;
import samples.trnxpool.Transaction;

public class BlockchainTest {

    //data structure
    static LinkedList<Block> bchain = new LinkedList();
    
    public static void main(String[] args) {
//        firstBlock();
        nextBlock();

    }

    public static void firstBlock() {
       
        System.out.println("--- Transaction objects ---");
        List<Transaction> trnxPool = TrnxPoolAdapter.getTransactions();
//        trnxPool.stream().forEach( System.out::println );
        
        System.out.println("--- Transactions with hashes ---");
        List<List<String>> trnxPool_hashes = TrnxPoolAdapter.getTransactionsHashes();
//        System.out.println( trnxPool_hashes );
        
        
        Block b1 = new Block(trnxPool_hashes, "0"); //genesis block
        bchain.add(b1);
        //clear the trnxpool.txt
        Transaction.empty();
        Blockchain.persist(bchain);
        //distribute/display the linkedlist elements/blocks
         out(bchain);
        
    }
    
    public static void nextBlock(){
        List<List<String>> trnxPool_hashes = TrnxPoolAdapter.getTransactionsHashes();
        bchain = Blockchain.get();
        Block block = new Block(trnxPool_hashes, bchain.getLast().getCurrentHash() );
        bchain.add(block);
        Transaction.empty();
        Blockchain.persist(bchain);
        out(bchain);

    }
    
    public static void out(LinkedList<Block> bchain){
        String temp = new GsonBuilder().setPrettyPrinting().create().toJson(bchain);
        System.out.println( temp );
        Blockchain.distribute(temp);
    }

}
