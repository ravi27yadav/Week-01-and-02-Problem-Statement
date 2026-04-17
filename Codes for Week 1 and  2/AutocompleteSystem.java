import java.util.*;

public class AutocompleteSystem {

    HashMap<String,Integer> queries=new HashMap<>();

    void addQuery(String q){
        queries.put(q,queries.getOrDefault(q,0)+1);
    }

    List<String> search(String prefix){

        List<String> result=new ArrayList<>();

        for(String q:queries.keySet()){
            if(q.startsWith(prefix)){
                result.add(q);
            }
        }

        return result;
    }

    public static void main(String[] args){

        AutocompleteSystem auto=new AutocompleteSystem();

        auto.addQuery("java tutorial");
        auto.addQuery("javascript");

        System.out.println(auto.search("jav"));
    }
}