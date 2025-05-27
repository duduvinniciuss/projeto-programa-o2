package entidade;

public class Funcionario extends Pessoa {
    private String cargo;

    public Funcionario() {}

    public Funcionario(String nome, String cpf, String cargo) {
        super(nome, cpf);
        this.cargo = cargo;
    }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    @Override
    public void exibirInformacoes() {
        System.out.println("Funcionário: " + nome + ", CPF: " + cpf + ", Cargo: " + cargo);
    }
}
