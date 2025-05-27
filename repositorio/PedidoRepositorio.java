package repositorio;

import entidade.Pedido;
import interfaces.repositorio.IPedidoRepositorio;

import java.util.ArrayList;
import java.util.List;

public class PedidoRepositorio implements IPedidoRepositorio {
    private List<Pedido> pedidos = new ArrayList<>();

    @Override
    public void salvar(Pedido pedido) {
        pedidos.add(pedido);
    }

    @Override
    public void remover(String codigo) {
        pedidos.removeIf(pedido -> pedido.getCodigo().equals(codigo));
    }

    @Override
    public void alterar(Pedido pedido) {
        for (int i = 0; i < pedidos.size(); i++) {
            if (pedidos.get(i).getCodigo().equals(pedido.getCodigo())) {
                pedidos.set(i, pedido);
                return;
            }
        }
    }

    @Override
    public List<Pedido> listar() {
        return new ArrayList<>(pedidos);
    }
}
