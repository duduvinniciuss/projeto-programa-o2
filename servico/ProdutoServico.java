package servico;

import entidade.Produto;
import interfaces.repositorio.IProdutoRepositorio;
import interfaces.servico.IProdutoServico;

import java.util.List;

public class ProdutoServico implements IProdutoServico {
    private IProdutoRepositorio produtoRepositorio;

    public ProdutoServico(IProdutoRepositorio produtoRepositorio) {
        this.produtoRepositorio = produtoRepositorio;
    }

    @Override
    public void cadastrar(Produto produto) {
        produtoRepositorio.salvar(produto);
    }

    @Override
    public void excluir(String codigo) {
        produtoRepositorio.remover(codigo);
    }

    @Override
    public void atualizar(Produto produto) {
        produtoRepositorio.alterar(produto);
    }

    @Override
    public List<Produto> buscarTodos() {
        return produtoRepositorio.listar();
    }
}
