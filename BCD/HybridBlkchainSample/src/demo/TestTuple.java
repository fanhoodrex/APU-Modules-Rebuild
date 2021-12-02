/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.util.*;
import org.javatuples.Pair;
import org.javatuples.Triplet;

/**
 *
 * @author jinhern
 */
public class TestTuple {
    
    public static void main(String[] args) {
        
        //coupling the data and digital signature
        
        Pair<String, String> pair1 = Pair.with("sample_hash1", "digital_signature1");
        Pair<String, String> pair2 = Pair.with("sample_hash2", "digital_signature3");
        Pair<String, String> pair3 = Pair.with("sample_hash2", "digital_signature3");
        
        //collect 3 items and etc
        Triplet<Pair<String, String>, Pair<String, String>, Pair<String, String>> signed_data = Triplet.with(pair1, pair2, pair3);
        System.out.println( signed_data );
    }
    
}
