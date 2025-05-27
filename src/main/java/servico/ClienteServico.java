package servico;

import entidade.Cliente;
import repositorio.ClienteRepositorio;

import java.util.List;

public class ClienteServico {

    private ClienteRepositorio repositorio = new ClienteRepositorio();

    public void cadastrar(Cliente cliente) {
        repositorio.salvar(cliente);
    }

    public void atualizar(Cliente cliente) {
        repositorio.atualizar(cliente);
    }

    public void remover(Cliente cliente) {
        repositorio.remover(cliente);
    }

    public List<Cliente> listar() {
        return repositorio.listar();
    }
}
