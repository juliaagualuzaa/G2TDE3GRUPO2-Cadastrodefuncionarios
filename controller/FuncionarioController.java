package controller;

import java.util.ArrayList;
import java.util.List;
import model.*;

public class FuncionarioController {
    private List<Funcionario> funcionarios = new ArrayList<>();

    public void adicionar(Funcionario f) {
        funcionarios.add(f);
    }

    public void listar() {
        for (Funcionario f : funcionarios) {
            f.exibirDetalhes();
        }
    }

    public Funcionario buscarPorMatricula(String matricula) throws FuncionarioNaoEncontradoException {
        for (Funcionario f : funcionarios) {
            if (f.getMatricula().equals(matricula)) {
                return f;
            }
        }
        throw new FuncionarioNaoEncontradoException("Funcionário com matrícula " + matricula + " não encontrado.");
    }

    public void removerPorMatricula(String matricula) throws FuncionarioNaoEncontradoException {
        Funcionario f = buscarPorMatricula(matricula);
        funcionarios.remove(f);
    }

    public void atualizarNome(String matricula, String novoNome) throws FuncionarioNaoEncontradoException {
        Funcionario f = buscarPorMatricula(matricula);
        f.nome = novoNome;
    }
}
