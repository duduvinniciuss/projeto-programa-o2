package interfaces.repositorio;

import entidade.Funcionario;
import java.util.List;

public interface IFuncionarioRepositorio {
    void salvar(Funcionario funcionario);
    void remover(String cpf);
    void alterar(Funcionario funcionario);
    List<Funcionario> listar();
}
