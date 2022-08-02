package DAO;

import entidades.Usuario;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

public class UsuarioDAO {

    Connection conn;
    PreparedStatement pstm;

    public ResultSet autenticacao(Usuario usuario) {
        conn = new ConexaoDAO().conexao();
        try {
            String sql = "SELECT * FROM usuarios where nome=? and senha=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getSenha());
            ResultSet rs = pstm.executeQuery();
            return rs;
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Erro ao autenticar" + e);
            return null;
        }

    }

    public void cadastrar(Usuario usuario) {

        String sql = "insert into usuarios (nome,senha) values (?,?)";
        ConexaoDAO conexaoDAO = new ConexaoDAO();
        conn = conexaoDAO.conexao();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getSenha());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null,"Novo usuario inserido com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar" + e);
        }

    }
}
