package pilares.abstracao;

public class TestePessoa {
    public static void main(String[] args){
        Funcionario funcionario = new Funcionario("Joao", 20);
        System.out.printf("Nome: %s | Idade: %d | ", funcionario.getNome(), funcionario.getIdade());
        funcionario.mostrarProfissao();
    }
}
