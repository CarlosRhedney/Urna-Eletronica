package programUrnaEletronica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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

public class PaginaEleitor extends JFrame {

	/**
	 * @autor Carlos Rhedney
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSaiNome;
	private JTextField txtSaiCPF;
	private JTextField txtSaiRG;
	private JTextField txtSaiRua;
	private JTextField txtSaiBairro;
	private JTextField txtSaiCep;
	private JTextField txtSaiNumero;
	private JLabel label;
	private JLabel lblNome;
	private JLabel lblRg;
	private JLabel lblRua;
	private JLabel lblBairro;
	private JLabel lblCpf;
	private JLabel lblN;
	private JLabel lblCep;
	private JButton btnSair;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaginaEleitor frame = new PaginaEleitor();
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
	public PaginaEleitor() {
		setResizable(false);
		setTitle("Eleitor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 720, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Panel contendo o logo topo
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 153, 153));
		panel.setBounds(0, 0, 704, 147);
		contentPane.add(panel);
		panel.setLayout(null);
		
		// Label logo Eleitor topo
		JLabel lblEleitor = new JLabel("Eleitor");
		lblEleitor.setForeground(new Color(255, 255, 255));
		lblEleitor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lblEleitor.setBounds(301, 102, 107, 34);
		panel.add(lblEleitor);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(PaginaEleitor.class.getResource("/programUrnaImg/eleitor.png")));
		label.setBounds(321, 11, 54, 80);
		panel.add(label);
		
		// Panel retornando com os dados do eleitor
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 153, 153));
		panel_1.setBounds(10, 158, 684, 293);
		panel_1.setBorder(BorderFactory.createTitledBorder("Eleitor"));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		// Campo de saida dos dados, Nome
		txtSaiNome = new JTextField();
		txtSaiNome.setToolTipText("Nome");
		txtSaiNome.setEditable(false);
		txtSaiNome.setBounds(44, 44, 273, 30);
		panel_1.add(txtSaiNome);
		txtSaiNome.setColumns(10);
		
		// Campo de saida dos dados, CPF
		txtSaiCPF = new JTextField();
		txtSaiCPF.setToolTipText("CPF");
		txtSaiCPF.setEditable(false);
		txtSaiCPF.setBounds(368, 44, 273, 30);
		panel_1.add(txtSaiCPF);
		txtSaiCPF.setColumns(10);
		
		// Campo de saida dos dados, RG
		txtSaiRG = new JTextField();
		txtSaiRG.setToolTipText("RG");
		txtSaiRG.setEditable(false);
		txtSaiRG.setBounds(44, 92, 273, 30);
		panel_1.add(txtSaiRG);
		txtSaiRG.setColumns(10);
		
		// Campo de saida dos dados, Rua
		txtSaiRua = new JTextField();
		txtSaiRua.setToolTipText("Rua");
		txtSaiRua.setEditable(false);
		txtSaiRua.setBounds(44, 140, 273, 30);
		panel_1.add(txtSaiRua);
		txtSaiRua.setColumns(10);
		
		// Campo de saida dos dados, Bairro
		txtSaiBairro = new JTextField();
		txtSaiBairro.setToolTipText("Bairro");
		txtSaiBairro.setEditable(false);
		txtSaiBairro.setBounds(44, 191, 273, 30);
		panel_1.add(txtSaiBairro);
		txtSaiBairro.setColumns(10);
		
		// Campo de saida dos dados, Cep
		txtSaiCep = new JTextField();
		txtSaiCep.setToolTipText("CEP");
		txtSaiCep.setEditable(false);
		txtSaiCep.setBounds(44, 241, 273, 30);
		panel_1.add(txtSaiCep);
		txtSaiCep.setColumns(10);
		
		// Campo de saida dos dados, Numero
		txtSaiNumero = new JTextField();
		txtSaiNumero.setToolTipText("Numero");
		txtSaiNumero.setEditable(false);
		txtSaiNumero.setBounds(368, 140, 273, 30);
		panel_1.add(txtSaiNumero);
		txtSaiNumero.setColumns(10);
		
		lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNome.setBounds(44, 29, 66, 14);
		panel_1.add(lblNome);
		
		lblRg = new JLabel("RG:");
		lblRg.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblRg.setBounds(44, 78, 48, 14);
		panel_1.add(lblRg);
		
		lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblRua.setBounds(44, 125, 48, 14);
		panel_1.add(lblRua);
		
		lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblBairro.setBounds(44, 175, 66, 14);
		panel_1.add(lblBairro);
		
		lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblCpf.setBounds(368, 29, 48, 14);
		panel_1.add(lblCpf);
		
		lblN = new JLabel("N\u00B0:");
		lblN.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblN.setBounds(368, 125, 48, 14);
		panel_1.add(lblN);
		
		lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblCep.setBounds(44, 226, 48, 14);
		panel_1.add(lblCep);
		
		JButton btnExibirDados = new JButton("Exibir Dados");
		btnExibirDados.setBounds(214, 462, 138, 30);
		contentPane.add(btnExibirDados);
		btnExibirDados.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnExibirDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscaDados();
			}
		});
		btnExibirDados.setForeground(new Color(255, 255, 255));
		btnExibirDados.setBackground(new Color(102, 102, 102));
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(356, 462, 138, 30);
		contentPane.add(btnSair);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBackground(new Color(102, 102, 102));
		btnSair.setForeground(new Color(255, 255, 255));
		btnSair.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
	}
	
	public void BuscaDados() {
		boolean consulta = true;
		 
		try {
		// * Driver de conexao com o MySQL.
		Class.forName("com.mysql.jdbc.Driver");
		 
		// * Conexão com o BD
		Connection con = DriverManager.getConnection(
		"jdbc:mysql://localhost/urna", "root", "");
		 
		// Objeto comdo SQL.
		java.sql.Statement stmt = con.createStatement();
		ResultSet RS = null;
		
		// Retorna os dados do BD.
		RS = stmt.executeQuery(" Select * from cadastroeleitor ");
		while (RS.next()) {
			txtSaiNome.setText(RS.getString("nomeEleitor"));
			txtSaiCPF.setText(RS.getString("cpf"));
			txtSaiRG.setText(RS.getString("rg"));
			txtSaiRua.setText(RS.getString("rua"));
			txtSaiBairro.setText(RS.getString("bairro"));
			txtSaiCep.setText(RS.getString("cep"));
			txtSaiNumero.setText(RS.getString("numero"));
		 
			consulta = false;
			JOptionPane.showMessageDialog(null, "Dados Encontrados!", "Info", JOptionPane.INFORMATION_MESSAGE);
		 
		}
		 
		if (consulta) {
			JOptionPane.showMessageDialog(null, "Dados não Encontrados.\nNenhum eleitor foi cadastrado!", "Alerta", JOptionPane.WARNING_MESSAGE);
		 
		}
		
		// Fecha as conexões.
		RS.close();
		stmt.close();
		con.close();
		
		// Trata os erros de conexão.
		} catch (SQLException Erro) {
			JOptionPane.showMessageDialog(null, "Erro Cmdo SQL" + Erro.getMessage());
		 
		} catch (ClassNotFoundException Erro) {
			JOptionPane.showMessageDialog(null, "Driver não Encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
		 
		}
	}
}
