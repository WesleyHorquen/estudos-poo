package pilares.abstracao;

//Classe abstrata
public abstract class Pessoa {
    private String nome;
    private int idade;

    //Construtor
    public Pessoa(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    //Getters e Setters
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
        if(idade > 0){ this.idade = idade;}else{ throw new IllegalArgumentException("ERRO: Idade deve ser maior que zero");}
    }

    //Método abstrato que deve ser implementado obrigatoriamente pelas subclasses
    public abstract void mostrarProfissao();
}
