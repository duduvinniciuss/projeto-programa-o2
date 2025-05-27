package entidade;

public class Produto {
    private String codigo;
    private String nome;
    private double preco;

    public Produto() {}

    public Produto(String codigo, String nome, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public void exibirInformacoes() {
        System.out.println("Produto: " + nome + ", Código: " + codigo + ", Preço: R$ " + preco);
    }
}
