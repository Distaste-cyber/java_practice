import java.util.*;

public class HashMapCode {
    static class HashMap<K, V> {
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;

            }
        }

        private int n; // no of total nodes
        private int N; // total number of buckets
        private LinkedList<Node> buckets[];

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.n = 0;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < N; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int bi = key.hashCode();
            bi = Math.abs(bi) % N;

            return bi;
        }

        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = this.buckets[bi];

            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key.equals(key)) {
                    return i;
                }
            }

            return -1;
        }

        private void rehash() {
            LinkedList<Node> oldBuckets[] = this.buckets;

            this.N = this.N * 2;
            this.buckets = new LinkedList[N];

            for (int i = 0; i < N; i++) {
                this.buckets[i] = new LinkedList<>();
            }

            for (int i = 0; i < oldBuckets.length; i++) {
                LinkedList<Node> ll = oldBuckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di == -1) {
                // key does not exist
                this.buckets[bi].add(new Node(key, value));
                n++;
            } else {
                // key already exists
                Node node = this.buckets[bi].get(di);
                node.value = value;
            }

            double lambda = (double) n / N;

            if (lambda > 2.0) {
                rehash();
            }

        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di == -1) {
                // key does not exist
                return false;
            } else {
                // key already exists
                return true;
            }
        }

        public V remove(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di == -1) {
                // key does not exist
                System.err.println("The key does not exist");
                return null;
            } else {
                // key already exists
                Node node = this.buckets[bi].remove(di);
                n--;
                return node.value;
            }
        }

        public V get(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di == -1) {
                // key does not exist
                return null;
            } else {
                // key already exists
                Node node = this.buckets[bi].get(di);
                return node.value;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();

            for (int i = 0; i < this.buckets.length; i++) {
                LinkedList<Node> ll = this.buckets[i];

                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }

            return keys;
        }

        public boolean isEmpty() {
            return n == 0;
        }

    }

    public static void main(String args[]) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("India", 190);
        map.put("China", 200);
        map.put("Pakistan", 33);

        ArrayList<String> keys = map.keySet();

        for (int i = 0; i < keys.size(); i++) {
            System.out.println(keys.get(i) + " : " + map.get(keys.get(i)));
        }

        map.remove("India");
        keys = map.keySet();

        for (int i = 0; i < keys.size(); i++) {
            System.out.println(keys.get(i) + " : " + map.get(keys.get(i)));
        }

    }
}
