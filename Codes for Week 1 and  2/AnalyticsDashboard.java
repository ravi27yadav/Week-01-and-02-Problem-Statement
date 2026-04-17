import java.util.*;

public class AnalyticsDashboard {

    HashMap<String,Integer> pageViews=new HashMap<>();
    HashMap<String,Set<String>> uniqueVisitors=new HashMap<>();
    HashMap<String,Integer> sources=new HashMap<>();

    void processEvent(String url,String user,String source){

        pageViews.put(url,pageViews.getOrDefault(url,0)+1);

        uniqueVisitors.putIfAbsent(url,new HashSet<>());
        uniqueVisitors.get(url).add(user);

        sources.put(source,sources.getOrDefault(source,0)+1);
    }

    void showDashboard(){

        System.out.println("Page views: "+pageViews);
        System.out.println("Unique visitors: "+uniqueVisitors);
        System.out.println("Traffic sources: "+sources);
    }

    public static void main(String[] args){

        AnalyticsDashboard dash=new AnalyticsDashboard();

        dash.processEvent("/news","user1","google");
        dash.processEvent("/news","user2","facebook");

        dash.showDashboard();
    }
}