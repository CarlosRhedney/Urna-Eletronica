package programUrnaEletronica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PaginaCadastroEleitor extends JFrame {

	/**
	 * @autor Carlos Rhedney
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEntNome;
	private JTextField txtEntRua;
	private JTextField txtEntBairro;
	private JTextField txtEntNumero;
	private JTextField txtEntRG;
	private JTextField txtEntCep;
	private JTextField txtEntCPF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaginaCadastroEleitor frame = new PaginaCadastroEleitor();
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
	public PaginaCadastroEleitor() {
		setTitle("Cadastro Eleitor");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 697, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Panel logo Cadastro Eleitor topo
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 153, 153));
		panel.setBounds(0, 0, 684, 128);
		contentPane.add(panel);
		panel.setLayout(null);
		
		// Label logo Cadastro Eleitor
		JLabel lblCadastroEleitor = new JLabel("Cadastro Eleitor");
		lblCadastroEleitor.setForeground(new Color(255, 255, 255));
		lblCadastroEleitor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblCadastroEleitor.setBounds(246, 90, 202, 27);
		panel.add(lblCadastroEleitor);
		
		// Label com icone do eleitor topo
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PaginaCadastroEleitor.class.getResource("/programUrnaImg/eleitor.png")));
		label.setBounds(310, 11, 76, 68);
		panel.add(label);
		
		// Panel Dados Pessoais
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 153, 153));
		panel_1.setBounds(10, 139, 664, 317);
		panel_1.setBorder(BorderFactory.createTitledBorder("Dados Pessoais"));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		// Label Nome
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNome.setBounds(109, 47, 63, 14);
		panel_1.add(lblNome);
		
		// Entrada cadastro de nome
		txtEntNome = new JTextField();
		txtEntNome.setToolTipText("Digite o seu nome");
		txtEntNome.setBounds(179, 43, 361, 26);
		panel_1.add(txtEntNome);
		txtEntNome.setColumns(10);
		
		// Label CPF
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setForeground(new Color(255, 255, 255));
		lblCpf.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblCpf.setBounds(119, 81, 48, 20);
		panel_1.add(lblCpf);
		
		// Label Rua
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setForeground(new Color(255, 255, 255));
		lblRua.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblRua.setBounds(121, 160, 48, 20);
		panel_1.add(lblRua);
		
		// Entrada cadastro de rua
		txtEntRua = new JTextField();
		txtEntRua.setToolTipText("Digite a sua rua");
		txtEntRua.setBounds(179, 159, 361, 26);
		panel_1.add(txtEntRua);
		txtEntRua.setColumns(10);
		
		// Label Bairro
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setForeground(new Color(255, 255, 255));
		lblBairro.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblBairro.setBounds(106, 194, 63, 26);
		panel_1.add(lblBairro);
		
		// Entrada cadastro de bairro
		txtEntBairro = new JTextField();
		txtEntBairro.setToolTipText("Digite o seu bairro");
		txtEntBairro.setBounds(179, 196, 361, 26);
		panel_1.add(txtEntBairro);
		txtEntBairro.setColumns(10);
		
		// Label Cep
		JLabel lblCep = new JLabel("Cep:");
		lblCep.setForeground(new Color(255, 255, 255));
		lblCep.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblCep.setBounds(115, 230, 54, 31);
		panel_1.add(lblCep);
		
		// Label Numero
		JLabel lblN = new JLabel("N\u00B0:");
		lblN.setForeground(new Color(255, 255, 255));
		lblN.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblN.setBounds(121, 273, 48, 20);
		panel_1.add(lblN);
		
		// Entrada cadastro de numero
		txtEntNumero = new JTextField();
		txtEntNumero.setToolTipText("Digite o numero da sua casa");
		txtEntNumero.setBounds(179, 272, 361, 26);
		panel_1.add(txtEntNumero);
		txtEntNumero.setColumns(10);
		
		// Label rg
		JLabel lblRg = new JLabel("RG:");
		lblRg.setForeground(new Color(255, 255, 255));
		lblRg.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblRg.setBounds(129, 112, 41, 37);
		panel_1.add(lblRg);
		
		// Entrada cadastro de rg
		txtEntRG = new JTextField();
		txtEntRG.setToolTipText("Digite o seu rg");
		txtEntRG.setBounds(179, 117, 361, 31);
		panel_1.add(txtEntRG);
		txtEntRG.setColumns(10);
		
		// Entrada cadastro de cep
		txtEntCep = new JTextField();
		txtEntCep.setToolTipText("Digite o seu cep");
		txtEntCep.setBounds(179, 233, 361, 28);
		panel_1.add(txtEntCep);
		txtEntCep.setColumns(10);
		
		// Entrada cadastro de cpf
		txtEntCPF = new JTextField();
		txtEntCPF.setToolTipText("Digite o seu cpf");
		txtEntCPF.setBounds(179, 80, 361, 26);
		panel_1.add(txtEntCPF);
		txtEntCPF.setColumns(10);
		
		// Botão Cadastrar chamando o metodo de cadastro
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setToolTipText("Cadastrar");
		btnCadastrar.setBounds(193, 459, 120, 23);
		contentPane.add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroEleitor();
			}
		});
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnCadastrar.setBackground(new Color(102, 102, 102));
		
		// Botão Limpar
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setToolTipText("Limpar");
		btnLimpar.setBounds(325, 459, 108, 23);
		contentPane.add(btnLimpar);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnLimpar.setBackground(new Color(102, 102, 102));
		btnLimpar.setForeground(new Color(255, 255, 255));
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		// Botão Sair
		JButton btnSair = new JButton("Sair");
		btnSair.setToolTipText("Sair");
		btnSair.setBounds(443, 459, 89, 23);
		contentPane.add(btnSair);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBackground(new Color(102, 102, 102));
		btnSair.setForeground(new Color(255, 255, 255));
		btnSair.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
	}
	// Metodo que cadastra o eleitor, é chamado pelo botao cadastrar
	public void CadastroEleitor() {
		try {
		// * Driver de conexao com o MySQL.
		Class.forName("com.mysql.jdbc.Driver");
		 
		// Conexão como BD.
		Connection con = DriverManager.getConnection(
		"jdbc:mysql://localhost/urna", "root", "");
		 
		// Objeto comdo SQL.
		java.sql.Statement stmt = con.createStatement();
		 
		// Pega os dados do formulário,
		String nome = txtEntNome.getText();
		String cpf = txtEntCPF.getText();
		String rg = txtEntRG.getText();
		String rua = txtEntRua.getText();
		String bairro = txtEntBairro.getText();
		String cep = txtEntCep.getText();
		String numero = txtEntNumero.getText();
		
		// Checando se todos os campos foram preenchidos
		if(nome.equals("") || cpf.equals("") || rg.equals("") || rua.equals("") || bairro.equals("") || cep.equals("") || numero.equals("")) {
			JOptionPane.showMessageDialog(null, "Todos campos devem ser preenchidos!", "Alerta", JOptionPane.WARNING_MESSAGE);
		}else {
			// Insere os dados BD.
			stmt.executeUpdate("insert into cadastroeleitor (nomeEleitor, cpf, rg, rua, bairro, cep, numero) values ('"
			+ nome + "','" + cpf + "', '" + rg + "' , '" + rua + "' , '" + bairro + "' , '" + cep + "' , '" + numero + "')");
			JOptionPane.showMessageDialog(null, "Eleitor cadastrado com sucesso!", "Info", JOptionPane.INFORMATION_MESSAGE);
		}
		 
		// Fecha a conexão com BD.
		con.close();
		 
		// Trata os erros de conexão.
		} catch (SQLException Erro) {
			JOptionPane.showMessageDialog(null,"Erro ao tentar se conectar com o BD MYSQL: " + Erro.getMessage());
		 
		} catch (ClassNotFoundException Erro) {
			JOptionPane.showMessageDialog(null, "Driver não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
		 
		}
	}
	
	// Limpa os campos de cadastro do eleitor.
	public void limparCampos() {
		txtEntNome.setText("");
		txtEntCPF.setText("");
		txtEntRG.setText("");
		txtEntRua.setText("");
		txtEntBairro.setText("");
		txtEntCep.setText("");
		txtEntNumero.setText("");
	}
}
