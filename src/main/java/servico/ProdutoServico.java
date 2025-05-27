package servico;

import entidade.Produto;
import repositorio.ProdutoRepositorio;

import java.util.List;

public class ProdutoServico {

    private ProdutoRepositorio repositorio = new ProdutoRepositorio();

    public void cadastrar(Produto produto) {
        repositorio.salvar(produto);
    }

    public void atualizar(Produto produto) {
        repositorio.atualizar(produto);
    }

    public void remover(Produto produto) {
        repositorio.remover(produto);
    }

    public List<Produto> listar() {
        return repositorio.listar();
    }
}
