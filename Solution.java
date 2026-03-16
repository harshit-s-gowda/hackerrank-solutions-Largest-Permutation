import java.util.*;
import java.io.*;

public class Solution {

    static int[] largestPermutation(int k, int[] arr) {
        int n = arr.length;
        
        // Map each value to its current index for O(1) lookup
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pos.put(arr[i], i);
        }
        
        int maxVal = n; // largest possible value in array
        
        for (int i = 0; i < n && k > 0; i++) {
            // If current element is already the max possible, skip
            if (arr[i] == maxVal) {
                maxVal--;
                continue;
            }
            
            // Find where maxVal currently is and swap it to position i
            int j = pos.get(maxVal);
            
            // Update position map
            pos.put(arr[i], j);
            pos.put(maxVal, i);
            
            // Swap in array
            arr[j] = arr[i];
            arr[i] = maxVal;
            
            maxVal--;
            k--;
        }
        
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] result = largestPermutation(k, arr);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0) sb.append(" ");
            sb.append(result[i]);
        }
        System.out.println(sb.toString());
    }
}