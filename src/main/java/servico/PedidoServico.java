package servico;

import entidade.Pedido;
import repositorio.PedidoRepositorio;

import java.util.List;

public class PedidoServico {

    private PedidoRepositorio repositorio = new PedidoRepositorio();

    public void cadastrar(Pedido pedido) {
        repositorio.salvar(pedido);
    }

    public void atualizar(Pedido pedido) {
        repositorio.atualizar(pedido);
    }

    public void remover(Pedido pedido) {
        repositorio.remover(pedido);
    }

    public List<Pedido> listar() {
        return repositorio.listar();
    }
}
