package entidade;

public class Pedido {
    private String codigo;
    private String descricao;
    private double valorTotal;

    public Pedido() {}

    public Pedido(String codigo, String descricao, double valorTotal) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valorTotal = valorTotal;
    }

    // Getters e setters

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "codigo='" + codigo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
