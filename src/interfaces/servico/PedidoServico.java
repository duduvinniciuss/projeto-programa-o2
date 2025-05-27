package interfaces.servico;

import entidade.Pedido;
import java.util.List;

public interface PedidoServico {
    void cadastrar(Pedido pedido);
    void remover(String codigo);
    void atualizar(Pedido pedido);
    List<Pedido> listar();
}
