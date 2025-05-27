package interfaces.servico;

import entidade.Pedido;
import java.util.List;

public interface IPedidoServico {
    void cadastrar(Pedido pedido);
    void excluir(String codigo);
    void atualizar(Pedido pedido);
    List<Pedido> buscarTodos();
}
