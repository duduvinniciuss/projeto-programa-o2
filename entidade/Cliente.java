package entidade;

public class Cliente extends Pessoa {
    private String email;

    public Cliente() {}

    public Cliente(String nome, String cpf, String email) {
        super(nome, cpf);
        this.email = email;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public void exibirInformacoes() {
        System.out.println("Cliente: " + nome + ", CPF: " + cpf + ", Email: " + email);
    }
}
