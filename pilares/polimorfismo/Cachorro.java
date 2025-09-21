package pilares.polimorfismo;

// Subclasse Cachorro
class Cachorro extends Animal {
    @Override
    public void fazerSom() {
        System.out.println("Au Au!");
    }
}
