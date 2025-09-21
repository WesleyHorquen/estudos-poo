package pilares.heranca;

import java.util.Scanner;

public class TestePessoa{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //Definindo valores teste heranca
        System.out.println("Defina a idade teste:");
        int idadeTeste = sc.nextInt();
        sc.nextLine(); //Limpa o buffer

        System.out.println("Defina o salario teste:");
        double salarioTeste = sc.nextDouble();
        sc.nextLine(); //Limpa o buffer

        // Criando um novo objeto Funcionario com dados do usuário
        Funcionario teste = new Funcionario("Teste", 0, 0);
        teste.setIdade(idadeTeste);
        teste.setSalario(salarioTeste);

        //Exibir informações do teste
        System.out.printf("Nome: %s | Idade: %d | Salario: %.2f\n", teste.getNome(), teste.getIdade(), teste.getSalario());
        sc.close();
    }
}