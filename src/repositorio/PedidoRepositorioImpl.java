package repositorio;

import entidade.Pedido;
import interfaces.repositorio.PedidoRepositorio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoRepositorioImpl implements PedidoRepositorio {

    @Override
    public void salvar(Pedido pedido) {
        String sql = "INSERT INTO pedido (codigo, descricao, valor) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pedido.getCodigo());
            stmt.setString(2, pedido.getDescricao());
            stmt.setDouble(3, pedido.getValorTotal());
            stmt.executeUpdate();
            System.out.println("Pedido salvo com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao salvar pedido: " + e.getMessage());
        }
    }

    @Override
    public void remover(String codigo) {
        String sql = "DELETE FROM pedido WHERE codigo = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, codigo);
            stmt.executeUpdate();
            System.out.println("Pedido removido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao remover pedido: " + e.getMessage());
        }
    }

    @Override
    public void alterar(Pedido pedido) {
        String sql = "UPDATE pedido SET descricao = ?, valor = ? WHERE codigo = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pedido.getDescricao());
            stmt.setDouble(2, pedido.getValorTotal());
            stmt.setString(3, pedido.getCodigo());
            stmt.executeUpdate();
            System.out.println("Pedido alterado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao alterar pedido: " + e.getMessage());
        }
    }

    @Override
    public List<Pedido> listar() {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedido";
        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Pedido pedido = new Pedido(
                        rs.getString("codigo"),
                        rs.getString("descricao"),
                        rs.getDouble("valor")
                );
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar pedidos: " + e.getMessage());
        }
        return pedidos;
    }
}
