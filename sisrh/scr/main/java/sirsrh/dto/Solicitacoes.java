package sisrh.dto;

public class Solicitacao {
    private int id;
    private String matricula;
    private String tipo;
    private String descricao;

    public Solicitacao() {}

    public Solicitacao(int id, String matricula, String tipo, String descricao) {
        this.id = id;
        this.matricula = matricula;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}