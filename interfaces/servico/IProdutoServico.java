package interfaces.servico;

import entidade.Produto;
import java.util.List;

public interface IProdutoServico {
    void cadastrar(Produto produto);
    void excluir(String codigo);
    void atualizar(Produto produto);
    List<Produto> buscarTodos();
}
