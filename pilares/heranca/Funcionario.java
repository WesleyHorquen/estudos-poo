/*
HERANCA:
A herança permite que uma classe (subclasse) herde atributos e métodos de outra classe (superclasse), promovendo a reutilização de código e a extensão de comportamentos.
*/
package pilares.heranca;

//Herda Pessoa através de extends
public class Funcionario extends Pessoa{
    private double salario;

    public Funcionario(String nome, int idade, double salario){
        //Chama o construtor da uperclasse
        super(nome, idade);
        this.salario = salario;
    }

    //Getter e Setter
    public double getSalario(){
        return salario;
    }
    public void setSalario(double salario){
        if(salario > 0){ this.salario = salario;}else{throw new IllegalArgumentException("ERRO: Salario deve ser maior que zero.");}
    }
}
