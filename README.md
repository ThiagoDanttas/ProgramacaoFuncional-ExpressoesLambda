# Programação Funcional e Expressões Lambda - Java

---

## Uma experiência com Comparator

• Suponha uma classe Product com os atributos name e price. <br>
• Podemos implementar a comparação de produtos por meio da
implementação da interface Comparable<Product> <br>
• Entretanto, desta forma nossa classe não fica fechada para
alteração: se o critério de comparação mudar, precisaremos
alterar a classe Product. <br>
• Podemos então usar o default method "sort" da interface List:
default void sort(Comparator<? super E> c) <br>

~~~~java

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {

        List<Product> list = new ArrayList<>() {{
            add(new Product("Tv", 900.00));
            add(new Product("Notebook", 1200.00));
            add(new Product("Tablet", 450.00));
        }};

        // Sistema Arrow function
        // Observação 
        list.sort((p1, p2) -> p1.getProduct().toUpperCase().compareTo(p2.getProduct().toUpperCase()));
        //list.sort(Comparator.comparing(p -> p.getProduct().toUpperCase())); Outro método com a mesma finalidade

        for (Product p : list) {
            System.out.println(p);
        }
    }

}
~~~~

# Programação funcional e cálculo lambda

---

## O que são "expressões lambda"?
Em programação funcional, expressão lambda corresponde a uma
função anônima de primeira classe.

## Paradigmas de programação
• Imperativo (C, Pascal, Fortran, Cobol) <br>
• Orientado a objetos (C++, Object Pascal, Java (< 8), C# (< 3)) <br>
• Funcional (Haskell, Closure, Clean, Erlang) <br>
• Lógico (Prolog) <br>
• Multiparadigma (JavaScript, Java (8+), C# (3+), Ruby, Python, Go)  <br>

### Paradigma funcional de programação
Baseado no formalismo matemático Cálculo Lambda (Church 1930)

formalismo| Programação Imperativa | Programação Funcional)
------------------------------|------------------------|---------------------------------
 Como se descreve algo a ser computado (*)| comandos ("como" - imperativa) | expressões ("o quê" - declarativa)
 Funções possuem transparência referencial (ausência de efeitos colaterais) | fraco| Forte 
 Objetos imutáveis (*) | raro| Comum 
 Funções são objetos de primeira ordem | não | sim   
 Expressividade / código conciso | baixa| alta
 Tipagem dinâmica / inferência de tipos | raro| comum

## Transparência referencial

Uma função possui transparência referencial se seu resultado for sempre o mesmo
para os mesmos dados de entrada. Benefícios: simplicidade e previsibilidade.

~~~~java
package application;
import java.util.Arrays;

public class Program {
    
    public static int globalValue = 3;
    
    public static void main(String[] args) {
    int[] vect = new int[] {3, 4, 5};
        changeOddValues(vect);
        System.out.println(Arrays.toString(vect));
    }
    
    public static void changeOddValues(int[] numbers) {
        for (int i=0; i<numbers.length; i++) {
        if (numbers[i] % 2 != 0) numbers[i] += globalValue;
        }
    }
}
~~~~

## Funções são objetos de primeira ordem (ou primeira classe)

Isso significa que funções podem, por exemplo, serem passadas como parâmetros de
métodos, bem como retornadas como resultado de métodos.

~~~~java

public class Program {
    public static int compareProducts(Product p1, Product p2) {
        return p1.getPrice().compareTo(p2.getPrice());
    }
    
public static void main(String[] args) {
    List<Product> list = new ArrayList<>();
    
    list.add(new Product("TV", 900.00));
    list.add(new Product("Notebook", 1200.00));
    list.add(new Product("Tablet", 450.00));
    list.sort(Program::compareProducts);
    list.forEach(System.out::println);
    
    }
}
~~~~

## Tipagem dinâmica / inferência de tipos

~~~~java
public static void main(String[] args) {
    
    List<Product> list = new ArrayList<>();
    list.add(new Product("TV", 900.00));
    list.add(new Product("Notebook", 1200.00));
    list.add(new Product("Tablet", 450.00));
    
    list.sort((p1, p2) -> p1.getPrice().compareTo(p2.getPrice()));
    list.forEach(System.out::println);
}
~~~~

## Expressividade / código conciso
~~~~java
Integer sum = 0;
for (Integer x : list) {
    sum += x;
}

// vs.
        
Integer sum = list.stream().reduce(0, Integer::sum);
~~~~

### Cálculo Lambda = formalismo matemático base da programação funcional *

### Expressão lambda = função anônima de primeira classe *