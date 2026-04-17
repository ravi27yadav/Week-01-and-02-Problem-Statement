import java.util.*;

class DNSEntry{
    String ip;
    long expiry;

    DNSEntry(String ip,long ttl){
        this.ip=ip;
        this.expiry=System.currentTimeMillis()+ttl;
    }
}

public class DNSCache{

    HashMap<String,DNSEntry> cache=new HashMap<>();

    String resolve(String domain){

        DNSEntry entry=cache.get(domain);

        if(entry!=null && entry.expiry>System.currentTimeMillis()){
            return "Cache HIT: "+entry.ip;
        }

        String newIP="192.168.1."+new Random().nextInt(255);

        cache.put(domain,new DNSEntry(newIP,30000));

        return "Cache MISS: "+newIP;
    }

    public static void main(String[] args){

        DNSCache dns=new DNSCache();

        System.out.println(dns.resolve("google.com"));
        System.out.println(dns.resolve("google.com"));
    }
}