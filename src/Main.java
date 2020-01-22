import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        //Main.primerMetodo();
        //Main.segundoMetodo();
        //Main.tercerMetodo();
//        Main.cuartoMetodo();
//        Main.quintoMetodo();
//        Main.sextoMetodo();
//        Main.septimoMetodo();
        Main.octavoMetodo();
    }

    public static void primerMetodo() {
        List<String> lista = new ArrayList<>();
        lista.add("dado");
        lista.add("arte");
        lista.add("bola");
        lista.add("asa");
        lista.add("buzo");
        lista.add("coche");
        lista.add("barco");
        lista.add("duna");

        lista.stream() //No es habitual guardar las streams en una variable porque son de un solo uso.
                .filter(s -> s.startsWith("a"))
                .forEach(System.out::println);
    }

    public static void segundoMetodo() {
        Cliente[] clientes =
                {
                        new Cliente("111", "Marta", 20),
                        new Cliente("115", "Jorge", 21),
                        new Cliente("112", "Carlos", 18),
                        new Cliente("211", "Ana", 19)
                };

        Stream.of(clientes)
                .sorted((x,y) -> x.nombre.compareTo(y.nombre)) //Si no pongo nada, me lo ordena por el criterio natural
                .forEach(System.out::println);
    }

    public static void tercerMetodo() {
        Cliente[] clientes =
                {
                        new Cliente("111", "Marta", 20),
                        new Cliente("115", "Jorge", 21),
                        new Cliente("112", "Carlos", 18),
                        new Cliente("211", "Ana", 19)
                };

        Stream.of(clientes)
                .map(nombre -> nombre.nombre) //Extraigo elementos concretos
                .forEach(System.out::println);
    }

    public static void cuartoMetodo() {
        Cliente[] clientes =
                {
                        new Cliente("111", "Marta", 20),
                        new Cliente("115", "Jorge", 21),
                        new Cliente("112", "Carlos", 18),
                        new Cliente("211", "Ana", 19)
                };

        Stream.of(clientes)
                .sorted((x,y) -> x.edad-y.edad)
                .filter(e -> e.edad < 20)
                .forEach(System.out::println);
    }

    public static void quintoMetodo() {
        Stream.of(1, 2, 3, 5, 6, 7, 3, 4, 5, -2, 5) //(1, 2, 3, 5, 6, 7, 4, -2) Sin repeticiones
            .distinct()
            .sorted()
            .forEach(elem -> System.out.print(elem + ", "));
    }

    public static void sextoMetodo() {
        Set<Integer> l = Stream.of(1, 2, 3, 5, 6, 7, 3, 4, 5, -2, 5)
                .filter(x -> x % 2 == 0)
                .sorted() //criterio natural de la clase Integer
                .collect(Collectors.toSet()); // o Collectors.toList(), pero set elimina repetidos
        System.out.println(l);
    }

    public static void septimoMetodo() {
        Cliente[] clientes =
                {
                        new Cliente("111", "Marta", 20),
                        new Cliente("115", "Jorge", 21),
                        new Cliente("112", "Carlos", 18),
                        new Cliente("211", "Ana", 19)
                };
        Map<Integer, String> m = Stream.of(clientes)
                .collect(Collectors.toMap(x -> x.edad, x -> x.nombre)); // o Collectors.toList(), pero set elimina repetidos
        System.out.println(m);
    }

    public static void octavoMetodo() {
        Stream<Integer> s1 = Stream.of(1, 2, 3, 5, 6, 7, 3, 4, 5, -2, 5);
        Stream<Integer> s2 = Stream.of(5, 6, 8, 2, -2, 6, 21, 7, -4, 0, 2);
        Object[] array = Stream.concat(s1, s2)
                .toArray(); //Lo pasa a array de Object
        //Se pasa Object a Integer porque es la clase del Stream, a otro no se podría hacer
        Integer[] tabla = Arrays.copyOf(array, array.length, Integer[].class);
        System.out.println(Arrays.toString(tabla));
    }

}

