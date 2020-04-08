package programUrnaEletronica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PaginaLogin extends JFrame {

	/**
	 * @autor Carlos Rhedney
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaginaLogin frame = new PaginaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PaginaLogin() {
		setTitle("Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 530);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Panel branco contendo os campos de entrada e os botões
		JPanel panel = new JPanel();
		panel.setBounds(118, 93, 425, 334);
		contentPane.add(panel);
		panel.setLayout(null);
		
		// Campo entrada de usuario 
		txtUsuario = new JTextField();
		txtUsuario.setToolTipText("Digite seu usuario");
		txtUsuario.setBounds(50, 106, 316, 40);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		// Label com icone de usuario ao lado do campo usuario
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PaginaLogin.class.getResource("/programUrnaImg/identificador.png")));
		label.setBounds(21, 114, 31, 26);
		panel.add(label);
		
		// Entrada de senha do usuario
		txtSenha = new JPasswordField();
		txtSenha.setToolTipText("Digite sua senha");
		txtSenha.setBounds(50, 157, 316, 40);
		panel.add(txtSenha);
		
		// Label com icone de chave ao lado do campo senha
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(PaginaLogin.class.getResource("/programUrnaImg/senha.png")));
		label_1.setBounds(21, 166, 48, 26);
		panel.add(label_1);
		
		// Botão Entrar
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setToolTipText("Entrar");
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VerificaLogin();
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnEntrar.setBackground(new Color(153, 153, 153));
		btnEntrar.setBounds(81, 224, 116, 40);
		panel.add(btnEntrar);
		
		// Botão Sair
		JButton btnSair = new JButton("Sair");
		btnSair.setToolTipText("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnSair.setBackground(new Color(153, 153, 153));
		btnSair.setBounds(207, 224, 116, 40);
		panel.add(btnSair);
		
		// Label com logo Efetuar Login
		JLabel lblEfetuarLogin = new JLabel("Efetuar Login");
		lblEfetuarLogin.setForeground(new Color(153, 153, 153));
		lblEfetuarLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 34));
		lblEfetuarLogin.setBounds(81, 38, 240, 46);
		panel.add(lblEfetuarLogin);
		
		// Label com icone de usuario topo
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(PaginaLogin.class.getResource("/programUrnaImg/user.png")));
		label_2.setBounds(296, 22, 71, 79);
		contentPane.add(label_2);
	}
	
	// Verificacão de usuario e senha e conexao com o BD
	public void VerificaLogin() {
		try {
			// Drive de conexao com o MySQL.
    		Class.forName("com.mysql.jdbc.Driver");
    		 
    		// Conexão com o BD.
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/urna", "root", "");
    		 
    		// Objeto comdo SQL.
    		java.sql.Statement stmt = con.createStatement();
    		ResultSet RS = null;
    		 
    		// Compara os dados no BD com os dados digitados no jtextfield e no jpasswordfield
    		// Se forem iguais abre a tela principal
    		String usuario = txtUsuario.getText();
    		String senha = new String(txtSenha.getPassword());
    		RS = stmt.executeQuery(" select * from login where usuario = '" + usuario + "' and senha = '" + senha + "' ");
    		if(RS.next()) {
    			JOptionPane.showMessageDialog(null, "Login Efetuado com sucesso!", "Info", JOptionPane.INFORMATION_MESSAGE);
    			PaginaPrincipal PaginaPrincipal = new PaginaPrincipal();
				PaginaPrincipal.setVisible(true);
				dispose();
    		}else {
    			JOptionPane.showMessageDialog(null, "Usuário e ou senha invalidos!", "ERRO", JOptionPane.ERROR_MESSAGE);
    		}
    		 
    		// Fecha a conexão com o BD.
    		con.close();
    		 
    		} catch (SQLException Erro) {
    		JOptionPane.showMessageDialog(null,
    		"Erro ao tentar se conectar com o BD MYSQL: " + Erro.getMessage());
    		 
    		// Trata os erros de conexão.
    		} catch (ClassNotFoundException Erro) {
    		 
    		JOptionPane.showMessageDialog(null, "Driver não encontrado!", "ERRO", JOptionPane.WARNING_MESSAGE);
		 
		}
	}
}
