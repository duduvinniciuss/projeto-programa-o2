package interfaces.servico;

import entidade.Cliente;
import java.util.List;

public interface IClienteServico {
    void cadastrar(Cliente cliente);
    void excluir(String cpf);
    void atualizar(Cliente cliente);
    List<Cliente> buscarTodos();
}
