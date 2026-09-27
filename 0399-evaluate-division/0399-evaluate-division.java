import java.util.*;

class Solution {

    public double[] calcEquation(List<List<String>> equations,
                                 double[] values,
                                 List<List<String>> queries) {

        Map<String, List<Node>> graph = new HashMap<>();

        // Build graph
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());

            graph.get(a).add(new Node(b, value));
            graph.get(b).add(new Node(a, 1.0 / value));
        }

        double[] answer = new double[queries.size()];

        // Process queries
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                answer[i] = -1.0;
            } else {
                Set<String> visited = new HashSet<>();
                answer[i] = dfs(graph, start, end, visited);
            }
        }

        return answer;
    }

    private double dfs(Map<String, List<Node>> graph,
                       String current,
                       String target,
                       Set<String> visited) {

        if (current.equals(target)) {
            return 1.0;
        }

        visited.add(current);

        for (Node node : graph.get(current)) {

            if (visited.contains(node.name)) {
                continue;
            }

            double result = dfs(graph, node.name, target, visited);

            if (result != -1.0) {
                return node.value * result;
            }
        }

        return -1.0;
    }

    class Node {
        String name;
        double value;

        Node(String name, double value) {
            this.name = name;
            this.value = value;
        }
    }
}