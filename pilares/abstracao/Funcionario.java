/*
ABSTRAÇÃO:
A abstração é o processo de esconder os detalhes internos e mostrar apenas o que é relevante para o usuário do objeto. Ela permite que você interaja com objetos sem se preocupar com sua implementação interna.
Usada para impor ao desenvolvedor que implemente os métodos da classe herdada.
*/

package pilares.abstracao;

//Herança
public class Funcionario extends Pessoa{
    public Funcionario(String nome, int idade){
        //Chama o construtor da uperclasse
        super(nome, idade);
    }

    //Implementacao do metodo abstrato
    @Override
    public void mostrarProfissao(){
        System.out.println("Profissão: Funcionário de uma empresa.");
    }
}