class Solution {
    public String[] getFolderNames(String[] names) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] ans = new String[names.length];

        for (int i = 0; i < names.length; i++) {
            String name = names[i];

            if (!map.containsKey(name)) {
                // Name is unused
                ans[i] = name;
                map.put(name, 1);
            } else {
                // Name is already used
                int k = map.get(name);
                String newName = name + "(" + k + ")";

                while (map.containsKey(newName)) {
                    k++;
                    newName = name + "(" + k + ")";
                }

                ans[i] = newName;

                // Next suffix to try for this original name
                map.put(name, k + 1);

                // This generated name is also now reserved
                map.put(newName, 1);
            }
        }

        return ans;
    }
}