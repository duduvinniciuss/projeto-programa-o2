package servico;

import entidade.Pedido;
import interfaces.repositorio.PedidoRepositorio;
import interfaces.servico.PedidoServico;
import repositorio.PedidoRepositorioImpl;

import java.util.List;

public class PedidoServicoImpl implements PedidoServico {

    private PedidoRepositorio repositorio = new PedidoRepositorioImpl();

    @Override
    public void cadastrar(Pedido pedido) {
        repositorio.salvar(pedido);
    }

    @Override
    public void remover(String codigo) {
        repositorio.remover(codigo);
    }

    @Override
    public void atualizar(Pedido pedido) {
        repositorio.alterar(pedido);
    }

    @Override
    public List<Pedido> listar() {
        return repositorio.listar();
    }
}
