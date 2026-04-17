import java.util.*;

public class SocialMedia {

    HashMap<String, Integer> users = new HashMap<>();
    HashMap<String, Integer> attempts = new HashMap<>();

    boolean checkAvailability(String username) {
        attempts.put(username, attempts.getOrDefault(username, 0) + 1);
        return !users.containsKey(username);
    }

    List<String> suggestAlternatives(String username) {

        List<String> suggestions = new ArrayList<>();

        for(int i=1;i<=3;i++){
            suggestions.add(username+i);
        }

        suggestions.add(username.replace("_","."));

        return suggestions;
    }

    String getMostAttempted(){

        String result="";
        int max=0;

        for(String key: attempts.keySet()){
            if(attempts.get(key)>max){
                max=attempts.get(key);
                result=key;
            }
        }

        return result;
    }

    public static void main(String[] args){

        SocialMedia checker=new SocialMedia();

        checker.users.put("john_doe",1);
        checker.users.put("admin",2);

        System.out.println(checker.checkAvailability("john_doe"));
        System.out.println(checker.checkAvailability("jane_smith"));

        System.out.println(checker.suggestAlternatives("john_doe"));
        System.out.println(checker.getMostAttempted());
    }
}