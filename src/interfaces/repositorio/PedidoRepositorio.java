package interfaces.repositorio;

import entidade.Pedido;
import java.util.List;

public interface PedidoRepositorio {
    void salvar(Pedido pedido);
    void remover(String codigo);
    void alterar(Pedido pedido);
    List<Pedido> listar();
}
