public class Main {
    public static void main(String[] args) {
        MeuMapa<String, Integer> map = new MeuMapa<>();

        map.put("um", 1);
        map.put("dois", 2);
        map.put("três", 3);

        System.out.println("Valor de 'um': " + map.get("um"));
        System.out.println("Valor de 'dois': " + map.get("dois"));
        System.out.println("Valor de 'três': " + map.get("três"));

        map.remove("dois");
        System.out.println("Valor de 'dois' após a remoção: " + map.get("dois"));
    }
}
