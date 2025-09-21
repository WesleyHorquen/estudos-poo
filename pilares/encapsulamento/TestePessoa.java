public class TestePessoa{
    public static void main(String[] args){
        Pessoa pessoa1 = new Pessoa("Weley", 30);

        System.out.printf("Ola, meu nome é %s e tenho %d anos.", pessoa1.getNome(), pessoa1.getIdade());
    }
}