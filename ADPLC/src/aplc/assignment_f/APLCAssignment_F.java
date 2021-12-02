package aplc.assignment_f;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.jpl7.Query;
import org.jpl7.Term;

/* @author fang */

public class APLCAssignment_F {
    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) {
        String TARGET_FILE = "coursework-marks.xlsx";   
        FileReader fr = new FileReader(TARGET_FILE);
        List<List<String>> data = fr.getData();
        task1_Q1(data);
        task1_Q2(data);
        task1_Q3_1(data);
        task1_Q3_2(data);
        task1_Q4(data);
        task1_Q5(data);
        task1_Q6(data);
        task2_prolog(data);
    }
    
    public static void task1_Q1(List<List<String>> data){
        data.stream().map(mark -> mark.get(3)).forEach(System.out::println);
    }
    
    public static void task1_Q2(List<List<String>> data){
        data.stream().map(mark -> mark.get(3)).mapToDouble(Double::parseDouble).average().ifPresent(System.out::println);
    }
     
    public static void task1_Q3_1(List<List<String>> data){
        System.out.println(data.stream().map(mark -> mark.get(3)).mapToDouble(Double::parseDouble).max().getAsDouble());
    }    
    
    public static void task1_Q3_2(List<List<String>> data){
        System.out.println(data.stream().map(mark -> mark.get(3)).mapToDouble(Double::parseDouble).summaryStatistics().getMin());
    }
    
    public static void task1_Q4(List<List<String>> data){
        Function<List<List<String>>,List<List<String>>> getFail = st -> st.stream().filter(std -> Double.parseDouble(std.get(3)) < 50).collect(Collectors.toList());
        getFail.apply(data).forEach(System.out::println);
    }
    
    public static void task1_Q5(List<List<String>> data){
        data.stream().filter(st -> Double.parseDouble(st.get(3)) > 85).forEach(System.out::println);
    }
    
    public static void task1_Q6(List<List<String>> data){
        data.stream().forEach(System.out::println);
    }
    
    public static void task2_prolog(List<List<String>> data){
        List<String> mrk = data.stream().map(st -> st.get(3)).collect(Collectors.toList());
        String query = "consult('prolog.pl')";
        Query q1 = new Query(query);
        System.out.println(q1.hasSolution() ? "success" : "false");
        String query2 = "insert_sort(" + mrk.toString() + ",List)";
        Query q2 = new Query(query2);
        Map<String, Term> solution = q2.oneSolution();
        for (Term t : solution.get("List").toTermArray())
            System.out.println(t);
    }
}
