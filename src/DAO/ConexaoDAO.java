package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoDAO {

    public Connection conexao() {
        Connection conn = null;
        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar" + e);
        }

        return conn;
    }
}
