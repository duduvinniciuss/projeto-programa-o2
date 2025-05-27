package repositorio;

import entidade.Produto;
import interfaces.repositorio.IProdutoRepositorio;

import java.util.ArrayList;
import java.util.List;

public class ProdutoRepositorio implements IProdutoRepositorio {
    private List<Produto> produtos = new ArrayList<>();

    @Override
    public void salvar(Produto produto) {
        produtos.add(produto);
    }

    @Override
    public void remover(String codigo) {
        produtos.removeIf(produto -> produto.getCodigo().equals(codigo));
    }

    @Override
    public void alterar(Produto produto) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getCodigo().equals(produto.getCodigo())) {
                produtos.set(i, produto);
                return;
            }
        }
    }

    @Override
    public List<Produto> listar() {
        return new ArrayList<>(produtos);
    }
}
