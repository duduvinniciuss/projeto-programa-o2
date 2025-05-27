package interfaces.repositorio;

import entidade.Produto;
import java.util.List;

public interface IProdutoRepositorio {
    void salvar(Produto produto);
    void remover(String codigo);
    void alterar(Produto produto);
    List<Produto> listar();
}
