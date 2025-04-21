package sisrh.banco;

import java.util.*;
import sisrh.dto.Empregado;
import sisrh.dto.Solicitacao;

public class Banco {

    private static Map<String, Empregado> empregados = new HashMap<>();
    private static Map<Integer, Solicitacao> solicitacoes = new HashMap<>();
    private static int idSolicitacao = 1;

    static {
        empregados.put("1001", new Empregado("1001", "Ana Clara", "Analista"));
        empregados.put("1002", new Empregado("1002", "Bruno Silva", "Desenvolvedor"));
        empregados.put("1003", new Empregado("1003", "Carlos Eduardo", "Tester"));

        solicitacoes.put(idSolicitacao, new Solicitacao(idSolicitacao++, "1001", "Férias", "Solicitação de férias em julho"));
        solicitacoes.put(idSolicitacao, new Solicitacao(idSolicitacao++, "1002", "Home Office", "Trabalho remoto na próxima semana"));
    }

    // Métodos para empregados
    public static List<Empregado> listarEmpregados() {
        return new ArrayList<>(empregados.values());
    }

    public static Empregado buscarEmpregadoPorMatricula(String matricula) {
        return empregados.get(matricula);
    }

    public static Empregado incluirEmpregado(Empregado e) {
        empregados.put(e.getMatricula(), e);
        return e;
    }

    public static Empregado alterarEmpregado(String matricula, Empregado e) {
        empregados.put(matricula, e);
        return e;
    }

    public static void excluirEmpregado(String matricula) {
        empregados.remove(matricula);
    }

    // Métodos para solicitações
    public static List<Solicitacao> listarSolicitacoes() {
        return new ArrayList<>(solicitacoes.values());
    }

    public static Solicitacao buscarSolicitacaoPorId(int id) {
        return solicitacoes.get(id);
    }

    public static Solicitacao incluirSolicitacao(Solicitacao s) {
        s.setId(idSolicitacao);
        solicitacoes.put(idSolicitacao, s);
        idSolicitacao++;
        return s;
    }

    public static Solicitacao alterarSolicitacao(int id, Solicitacao s) {
        solicitacoes.put(id, s);
        return s;
    }

    public static void excluirSolicitacao(int id) {
        solicitacoes.remove(id);
    }
}