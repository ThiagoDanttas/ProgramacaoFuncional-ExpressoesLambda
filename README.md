# Programa��o Funcional e Express�es Lambda - Java

---

## Uma experi�ncia com Comparator

� Suponha uma classe Product com os atributos name e price. <br>
� Podemos implementar a compara��o de produtos por meio da
implementa��o da interface Comparable<Product> <br>
� Entretanto, desta forma nossa classe n�o fica fechada para
altera��o: se o crit�rio de compara��o mudar, precisaremos
alterar a classe Product. <br>
� Podemos ent�o usar o default method "sort" da interface List:
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
        // Observa��o 
        list.sort((p1, p2) -> p1.getProduct().toUpperCase().compareTo(p2.getProduct().toUpperCase()));
        //list.sort(Comparator.comparing(p -> p.getProduct().toUpperCase())); Outro m�todo com a mesma finalidade

        for (Product p : list) {
            System.out.println(p);
        }
    }

}
~~~~

# Programa��o funcional e c�lculo lambda

---

## O que s�o "express�es lambda"?
Em programa��o funcional, express�o lambda corresponde a uma
fun��o an�nima de primeira classe.

## Paradigmas de programa��o
� Imperativo (C, Pascal, Fortran, Cobol) <br>
� Orientado a objetos (C++, Object Pascal, Java (< 8), C# (< 3)) <br>
� Funcional (Haskell, Closure, Clean, Erlang) <br>
� L�gico (Prolog) <br>
� Multiparadigma (JavaScript, Java (8+), C# (3+), Ruby, Python, Go)  <br>

### Paradigma funcional de programa��o
Baseado no formalismo matem�tico C�lculo Lambda (Church 1930)

formalismo| Programa��o Imperativa | Programa��o Funcional)
------------------------------|------------------------|---------------------------------
 Como se descreve algo a ser computado (*)| comandos ("como" - imperativa) | express�es ("o qu�" - declarativa)
 Fun��es possuem transpar�ncia referencial (aus�ncia de efeitos colaterais) | fraco| Forte 
 Objetos imut�veis (*) | raro| Comum 
 Fun��es s�o objetos de primeira ordem | n�o | sim   
 Expressividade / c�digo conciso | baixa| alta
 Tipagem din�mica / infer�ncia de tipos | raro| comum

## Transpar�ncia referencial

Uma fun��o possui transpar�ncia referencial se seu resultado for sempre o mesmo
para os mesmos dados de entrada. Benef�cios: simplicidade e previsibilidade.

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

## Fun��es s�o objetos de primeira ordem (ou primeira classe)

Isso significa que fun��es podem, por exemplo, serem passadas como par�metros de
m�todos, bem como retornadas como resultado de m�todos.

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

## Tipagem din�mica / infer�ncia de tipos

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

## Expressividade / c�digo conciso
~~~~java
Integer sum = 0;
for (Integer x : list) {
    sum += x;
}

// vs.
        
Integer sum = list.stream().reduce(0, Integer::sum);
~~~~

### C�lculo Lambda = formalismo matem�tico base da programa��o funcional *

### Express�o lambda = fun��o an�nima de primeira classe *