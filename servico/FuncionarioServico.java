package servico;

import entidade.Funcionario;
import interfaces.repositorio.IFuncionarioRepositorio;
import interfaces.servico.IFuncionarioServico;

import java.util.List;

public class FuncionarioServico implements IFuncionarioServico {
    private IFuncionarioRepositorio funcionarioRepositorio;

    public FuncionarioServico(IFuncionarioRepositorio funcionarioRepositorio) {
        this.funcionarioRepositorio = funcionarioRepositorio;
    }

    @Override
    public void cadastrar(Funcionario funcionario) {
        funcionarioRepositorio.salvar(funcionario);
    }

    @Override
    public void excluir(String cpf) {
        funcionarioRepositorio.remover(cpf);
    }

    @Override
    public void atualizar(Funcionario funcionario) {
        funcionarioRepositorio.alterar(funcionario);
    }

    @Override
    public List<Funcionario> buscarTodos() {
        return funcionarioRepositorio.listar();
    }
}
