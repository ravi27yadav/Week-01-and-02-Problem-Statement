import java.util.*;

public class InventoryManager {

    HashMap<String,Integer> stock=new HashMap<>();
    LinkedHashMap<Integer,String> waitingList=new LinkedHashMap<>();

    boolean purchaseItem(String product,int userId){

        int currentStock=stock.getOrDefault(product,0);

        if(currentStock>0){
            stock.put(product,currentStock-1);
            System.out.println("Purchase successful. Remaining: "+(currentStock-1));
            return true;
        }else{
            waitingList.put(userId,product);
            System.out.println("Added to waiting list");
            return false;
        }
    }

    void checkStock(String product){
        System.out.println("Stock: "+stock.getOrDefault(product,0));
    }

    public static void main(String[] args){

        InventoryManager manager=new InventoryManager();

        manager.stock.put("IPHONE15",100);

        manager.checkStock("IPHONE15");

        manager.purchaseItem("IPHONE15",101);
        manager.purchaseItem("IPHONE15",102);
    }
}