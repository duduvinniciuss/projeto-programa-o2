package repositorio;

import entidade.Cliente;
import interfaces.repositorio.IClienteRepositorio;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepositorio implements IClienteRepositorio {
    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public void salvar(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public void remover(String cpf) {
        clientes.removeIf(cliente -> cliente.getCpf().equals(cpf));
    }

    @Override
    public void alterar(Cliente cliente) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCpf().equals(cliente.getCpf())) {
                clientes.set(i, cliente);
                return;
            }
        }
    }

    @Override
    public List<Cliente> listar() {
        return new ArrayList<>(clientes);
    }
}
