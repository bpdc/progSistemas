package ProgramacaoSistemas.demo;

public class Curso {
    private String nome;
    private int duracao;

    public Curso() {
    }

    public Curso(String nome, int duracao) {
        this.nome = nome;
        this.duracao = duracao;
    }

    public int getDuracao() {
        return duracao;
    }

    public String getNome() {
        return nome;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
