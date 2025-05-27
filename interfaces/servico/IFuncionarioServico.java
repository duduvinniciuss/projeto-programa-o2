package interfaces.servico;

import entidade.Funcionario;
import java.util.List;

public interface IFuncionarioServico {
    void cadastrar(Funcionario funcionario);
    void excluir(String cpf);
    void atualizar(Funcionario funcionario);
    List<Funcionario> buscarTodos();
}
