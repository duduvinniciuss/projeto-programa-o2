package repositorio;

import entidade.Funcionario;
import interfaces.repositorio.IFuncionarioRepositorio;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepositorio implements IFuncionarioRepositorio {
    private List<Funcionario> funcionarios = new ArrayList<>();

    @Override
    public void salvar(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    @Override
    public void remover(String cpf) {
        funcionarios.removeIf(funcionario -> funcionario.getCpf().equals(cpf));
    }

    @Override
    public void alterar(Funcionario funcionario) {
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getCpf().equals(funcionario.getCpf())) {
                funcionarios.set(i, funcionario);
                return;
            }
        }
    }

    @Override
    public List<Funcionario> listar() {
        return new ArrayList<>(funcionarios);
    }
}
