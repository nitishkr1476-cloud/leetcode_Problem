import java.util.*;

class RandomizedSet {

    private List<Integer> list;
    private HashMap<Integer, Integer> map;
    private Random random;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        // Add value at the end
        list.add(val);

        // Store value -> index
        map.put(val, list.size() - 1);

        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        // Index of value to remove
        int index = map.get(val);

        // Last element in the list
        int lastValue = list.get(list.size() - 1);

        // Move last element to the position of removed element
        list.set(index, lastValue);

        // Update index of last element
        map.put(lastValue, index);

        // Remove last element
        list.remove(list.size() - 1);

        // Remove value from map
        map.remove(val);

        return true;
    }

    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}