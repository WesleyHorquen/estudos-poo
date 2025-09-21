/*
POLIMORFISMO:
O polimorfismo permite que o mesmo método tenha comportamentos diferentes dependendo do tipo do objeto que o invoca. Isso significa que um único método pode agir de maneiras distintas, de acordo com a classe do objeto.
*/
package pilares.polimorfismo;

public class TestePolimorfismo {
    public static void main(String[] args) {
        // Criando objetos das classes filhas
        Animal cachorro = new Cachorro();
        Animal gato = new Gato();

        // Usando polimorfismo para chamar o método
        System.out.println("O cachorro faz: ");
        cachorro.fazerSom();
        System.out.println("O gato faz: ");
        gato.fazerSom();
    }
}