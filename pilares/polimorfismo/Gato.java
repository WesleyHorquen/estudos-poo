package pilares.polimorfismo;

// Subclasse Gato
class Gato extends Animal {
    @Override
    public void fazerSom() {
        System.out.println("Miau!");
    }
}