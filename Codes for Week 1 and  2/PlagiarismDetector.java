import java.util.*;

public class PlagiarismDetector {

    HashMap<String,Set<String>> index=new HashMap<>();

    void addDocument(String docId,String text){

        String[] words=text.split(" ");

        for(int i=0;i<words.length-4;i++){

            String gram=words[i]+" "+words[i+1]+" "+words[i+2]+" "+words[i+3]+" "+words[i+4];

            index.putIfAbsent(gram,new HashSet<>());
            index.get(gram).add(docId);
        }
    }

    void checkDocument(String docId,String text){

        int matches=0;

        String[] words=text.split(" ");

        for(int i=0;i<words.length-4;i++){

            String gram=words[i]+" "+words[i+1]+" "+words[i+2]+" "+words[i+3]+" "+words[i+4];

            if(index.containsKey(gram)){
                matches++;
            }
        }

        System.out.println("Matching ngrams: "+matches);
    }

    public static void main(String[] args){

        PlagiarismDetector p=new PlagiarismDetector();

        p.addDocument("doc1","this is a simple plagiarism detection example text");

        p.checkDocument("doc2","this is a simple plagiarism detection program");
    }
}