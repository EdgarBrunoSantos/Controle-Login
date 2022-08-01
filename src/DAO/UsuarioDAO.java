package DAO;

import entidades.Usuario;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

public class UsuarioDAO {

    Connection conn;

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
}
