package apresentacao;

import javax.swing.*;
import java.awt.*;
import negocio.Sistema;

public class TelaLogin extends JFrame {

    private JTextField campoUsuario;
    private JPasswordField campoSenha;

    public TelaLogin() {
        setTitle("Login - Sistema de Finanças");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridLayout(4, 2, 10, 10));

        painel.add(new JLabel("Usuário:"));
        campoUsuario = new JTextField();
        painel.add(campoUsuario);

        painel.add(new JLabel("Senha:"));
        campoSenha = new JPasswordField();
        painel.add(campoSenha);

        JButton btnLogin = new JButton("Login");
        JButton btnCadastro = new JButton("Cadastrar");

        painel.add(btnLogin);
        painel.add(btnCadastro);

        add(painel);

        btnLogin.addActionListener(e -> {
            String nome = campoUsuario.getText();
            String senha = new String(campoSenha.getPassword());
            String resultado = Sistema.fazerLogin(nome, senha);
            JOptionPane.showMessageDialog(this, resultado);

            if (Sistema.isUsuarioLogado()) {
                new TelaPrincipal().setVisible(true);
                this.dispose();
            }
        });

        btnCadastro.addActionListener(e -> {
            String nome = campoUsuario.getText();
            String senha = new String(campoSenha.getPassword());
            String resultado = Sistema.cadastrarUsuario(nome, senha);
            JOptionPane.showMessageDialog(this, resultado);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaLogin().setVisible(true));
    }
}
