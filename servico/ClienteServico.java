package servico;

import entidade.Cliente;
import interfaces.repositorio.IClienteRepositorio;
import interfaces.servico.IClienteServico;

import java.util.List;

public class ClienteServico implements IClienteServico {
    private IClienteRepositorio clienteRepositorio;

    public ClienteServico(IClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    @Override
    public void cadastrar(Cliente cliente) {
        clienteRepositorio.salvar(cliente);
    }

    @Override
    public void excluir(String cpf) {
        clienteRepositorio.remover(cpf);
    }

    @Override
    public void atualizar(Cliente cliente) {
        clienteRepositorio.alterar(cliente);
    }

    @Override
    public List<Cliente> buscarTodos() {
        return clienteRepositorio.listar();
    }
}
