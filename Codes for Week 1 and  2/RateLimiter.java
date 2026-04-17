import java.util.*;

class TokenBucket{
    int tokens;
    long lastTime;

    TokenBucket(int tokens){
        this.tokens=tokens;
        lastTime=System.currentTimeMillis();
    }
}

public class RateLimiter{

    HashMap<String,TokenBucket> clients=new HashMap<>();

    boolean checkRateLimit(String client){

        clients.putIfAbsent(client,new TokenBucket(1000));

        TokenBucket bucket=clients.get(client);

        if(bucket.tokens>0){
            bucket.tokens--;
            return true;
        }

        return false;
    }

    public static void main(String[] args){

        RateLimiter limiter=new RateLimiter();

        System.out.println(limiter.checkRateLimit("client1"));
    }
}