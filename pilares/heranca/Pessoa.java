package pilares.heranca;

public class Pessoa{
    private String nome;
    private int idade;

    //Método Construtor
    public Pessoa(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    //Métodos getter e setter para encapsulamento
    public String getNome(){
        return nome;
    }
    public int getIdade(){
        return idade;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setIdade(int idade){
        if(idade > 0){ this.idade = idade;}else{throw new IllegalArgumentException("ERRO: Idade deve ser maior que zero.");}
    }
}