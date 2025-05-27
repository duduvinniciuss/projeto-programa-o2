package servico;

import entidade.Pedido;
import interfaces.repositorio.IPedidoRepositorio;
import interfaces.servico.IPedidoServico;

import java.util.List;

public class PedidoServico implements IPedidoServico {
    private IPedidoRepositorio pedidoRepositorio;

    public PedidoServico(IPedidoRepositorio pedidoRepositorio) {
        this.pedidoRepositorio = pedidoRepositorio;
    }

    @Override
    public void cadastrar(Pedido pedido) {
        pedidoRepositorio.salvar(pedido);
    }

    @Override
    public void excluir(String codigo) {
        pedidoRepositorio.remover(codigo);
    }

    @Override
    public void atualizar(Pedido pedido) {
        pedidoRepositorio.alterar(pedido);
    }

    @Override
    public List<Pedido> buscarTodos() {
        return pedidoRepositorio.listar();
    }
}
