package main.com.sumit.coding.topics.hashing;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class SortElementsByFrequency {

    public static void main(String[] args) throws IOException {

        int arr[] = { 2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8 };
        System.out.println(sortByFrequency(arr, arr.length));
    }

    public static StringBuffer sortByFrequency(int[] arr, int len){

        Map<Integer, Integer> countMap = getMapCount (arr, len);
        StringBuffer stringBuffer = new StringBuffer();

        countMap.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer> comparingByValue().reversed())
                .forEach(e -> {

                    int key = e.getKey();
                    int value = e.getValue();

                    for (int i=0; i<value; i++){
                        stringBuffer.append(key+" ");
                    }
                });

        return stringBuffer;
    }

    private static Map<Integer, Integer> getMapCount(int[] arr, int len){

        Map<Integer, Integer> countMap = new TreeMap<>();

        int i=0;
        while(i<len){
            if(countMap.containsKey(arr[i])){
                countMap.put(arr[i], countMap.get(arr[i])+1 );
            }
            else{
                countMap.put(arr[i], 1);
            }
            i++;
        }

        return countMap;
    }
}
