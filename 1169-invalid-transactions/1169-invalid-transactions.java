import java.util.*;

class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        int n = transactions.length;
        
        // Parsed data storage
        String[] names = new String[n];
        int[] times = new int[n];
        int[] amounts = new int[n];
        String[] cities = new String[n];
        
        // Parse transactions
        for (int i = 0; i < n; i++) {
            String[] parts = transactions[i].split(",");
            names[i] = parts[0];
            times[i] = Integer.parseInt(parts[1]);
            amounts[i] = Integer.parseInt(parts[2]);
            cities[i] = parts[3];
        }
        
        Set<Integer> invalid = new HashSet<>();
        
        // Rule 1: amount > 1000
        for (int i = 0; i < n; i++) {
            if (amounts[i] > 1000) {
                invalid.add(i);
            }
        }
        
        // Rule 2: same name, different city, within 60 mins
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (names[i].equals(names[j])) {
                    if (Math.abs(times[i] - times[j]) <= 60 &&
                        !cities[i].equals(cities[j])) {
                        invalid.add(i);
                        invalid.add(j);
                    }
                }
            }
        }
        
        // Build result
        List<String> result = new ArrayList<>();
        for (int idx : invalid) {
            result.add(transactions[idx]);
        }
        
        return result;
    }
}

