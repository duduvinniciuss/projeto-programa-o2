package servico;

import entidade.Funcionario;
import repositorio.FuncionarioRepositorio;

import java.util.List;

public class FuncionarioServico {

    private FuncionarioRepositorio repositorio = new FuncionarioRepositorio();

    public void cadastrar(Funcionario funcionario) {
        repositorio.salvar(funcionario);
    }

    public void atualizar(Funcionario funcionario) {
        repositorio.atualizar(funcionario);
    }

    public void remover(Funcionario funcionario) {
        repositorio.remover(funcionario);
    }

    public List<Funcionario> listar() {
        return repositorio.listar();
    }
}
