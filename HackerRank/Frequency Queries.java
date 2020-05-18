import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> ans = new ArrayList<>();
        
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> mapFreq = new HashMap<>();

        for(int i = 0; i < queries.size(); i++){
            int command = queries.get(i).get(0);
            int num = queries.get(i).get(1);

            if(command == 1){
                if(map.containsKey(num)){
                    int before = map.get(num);
                    map.put(num, before + 1);
                    
                    subtract(mapFreq, before);
                    add(mapFreq, before + 1);
                }
                else{
                    map.put(num, 1);
                    add(mapFreq, 1);
                }
            }
            else if(command == 2){
                if(map.containsKey(num)){
                    int freq = map.get(num);
                    subtract(map, num);
                    if(freq > 1) add(mapFreq, freq - 1);
                    subtract(mapFreq, freq);
                }
            }
            else{
                if(mapFreq.containsKey(num))
                    ans.add(1);
                else
                    ans.add(0);
            }
        }
        return ans;
    }
    static void add(Map<Integer, Integer> hm, int adding){
        if(hm.containsKey(adding))
            hm.put(adding, hm.get(adding) + 1);
        else
            hm.put(adding, 1);
    }
    static void subtract(Map<Integer, Integer> hm, int subtracting){
        if(hm.get(subtracting) > 1)
            hm.put(subtracting, hm.get(subtracting) - 1);
        else
            hm.remove(subtracting);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
            ans.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
