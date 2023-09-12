public class MeuMapa<K, V> {
    private Node<K, V> head;
    private int size;

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;
        Node<K, V> prev;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key, V value) {
        Node<K, V> newNode = new Node<>(key, value);
        if (head == null) {
            head = newNode;
        } else {
            Node<K, V> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
        size++;
    }

    public V get(K key) {
        Node<K, V> current = head;
        while (current != null) {
            if (key.equals(current.key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public void remove(K key) {
        Node<K, V> current = head;
        while (current != null) {
            if (key.equals(current.key)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                }
                size--;
                return;
            }
            current = current.next;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        MeuMapa<String, Integer> map = new MeuMapa<>();

        map.put("um", 1);
        map.put("dois", 2);
        map.put("três", 3);

        System.out.println("Tamanho do mapa: " + map.size());
        System.out.println("Está vazio? " + map.isEmpty());

        map.remove("dois");
        System.out.println("Tamanho do mapa após a remoção: " + map.size());
    }
}
