package interfaces.repositorio;

import entidade.Cliente;
import java.util.List;

public interface IClienteRepositorio {
    void salvar(Cliente cliente);
    void remover(String cpf);
    void alterar(Cliente cliente);
    List<Cliente> listar();
}
