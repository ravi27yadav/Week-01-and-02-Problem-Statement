import java.util.*;

public class TransactionAnalyzer {

    void twoSum(int[] arr,int target){

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<arr.length;i++){

            int complement=target-arr[i];

            if(map.containsKey(complement)){
                System.out.println("Pair found: "+arr[i]+" "+complement);
                return;
            }

            map.put(arr[i],i);
        }
    }

    public static void main(String[] args){

        TransactionAnalyzer t=new TransactionAnalyzer();

        int[] arr={500,300,200};

        t.twoSum(arr,500);
    }
}