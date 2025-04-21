package sisrh.dto;

public class Empregado {
    private String matricula;
    private String nome;
    private String funcao;

    public Empregado() {}

    public Empregado(String matricula, String nome, String funcao) {
        this.matricula = matricula;
        this.nome = nome;
        this.funcao = funcao;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}