import java.util.List;
import java.util.ArrayList;
public class Program {

    public static void main(String[] args){

        List<Product> list = new ArrayList<>(){{
            add(new Product("Tv", 900.00));
            add(new Product("Notebook", 1200.00));
            add(new Product("Tablet", 450.00));
        }};

        // Sistema Arrow function

        list.sort((p1, p2) -> p1.getProduct().toUpperCase().compareTo(p2.getProduct().toUpperCase()));
        // list.sort(Comparator.comparing(p -> p.getProduct().toUpperCase()))

        for(Product p: list){
            System.out.println(p);
        }
    }

}
