class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] count = new int[10];

        // Count frequency of each digit
        for (int digit : digits) {
            count[digit]++;
        }

        int[] temp = new int[900];
        int index = 0;

        // Generate all 3-digit even numbers
        for (int num = 100; num <= 998; num += 2) {
            int a = num / 100;
            int b = (num / 10) % 10;
            int c = num % 10;

            int[] need = new int[10];
            need[a]++;
            need[b]++;
            need[c]++;

            boolean possible = true;

            for (int i = 0; i < 10; i++) {
                if (need[i] > count[i]) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                temp[index++] = num;
            }
        }

        // Create result array of exact size
        int[] result = new int[index];

        for (int i = 0; i < index; i++) {
            result[i] = temp[i];
        }

        return result;
    }
}