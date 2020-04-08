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

public class PaginaCandidatos2 extends JFrame {

	/**
	 * @autor Carlos Rhedney
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNomeEsq;
	private JTextField txtNumeroEsq;
	private JTextField txtCargoEsq;
	private JTextField txtNomeEsq2;
	private JTextField txtNumeroEsq2;
	private JTextField txtCargoEsq2;
	private JTextField txtNomeDir;
	private JTextField txtNumeroDir;
	private JTextField txtCargoDir;
	private JTextField txtNomeDir2;
	private JTextField txtNumeroDir2;
	private JTextField txtCargoDir2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaginaCandidatos2 frame = new PaginaCandidatos2();
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
	public PaginaCandidatos2() {
		setTitle("Candidatos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 763, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Panel contendo o logo Candidatos
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 153, 153));
		panel.setBounds(0, 0, 764, 138);
		contentPane.add(panel);
		panel.setLayout(null);
		
		// Label com o nome Candidatos
		JLabel lblCandidatos = new JLabel("Candidatos");
		lblCandidatos.setForeground(new Color(255, 255, 255));
		lblCandidatos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblCandidatos.setBounds(310, 79, 149, 36);
		panel.add(lblCandidatos);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PaginaCandidatos2.class.getResource("/programUrnaImg/candidatos.png")));
		label.setBounds(345, 11, 72, 73);
		panel.add(label);
		
		// Panel lateral esquerda contendo os dados dos Candidatos da Esquerda
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 153, 153));
		panel_1.setBounds(0, 149, 372, 301);
		panel_1.setBorder(BorderFactory.createTitledBorder("Partido da Esquerda"));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		// Label nome candidato esquerda
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNome.setBounds(10, 22, 62, 14);
		panel_1.add(lblNome);
		
		// Saida nome candidatos esquerda 
		txtNomeEsq = new JTextField();
		txtNomeEsq.setToolTipText("Nome Presidente");
		txtNomeEsq.setEditable(false);
		txtNomeEsq.setBounds(10, 40, 179, 20);
		panel_1.add(txtNomeEsq);
		txtNomeEsq.setColumns(10);
		
		// Label numero candidato esquerda
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNmero.setBounds(209, 22, 72, 14);
		panel_1.add(lblNmero);
		
		// Saida numero candidatos esquerda
		txtNumeroEsq = new JTextField();
		txtNumeroEsq.setToolTipText("Numero Presidente");
		txtNumeroEsq.setEditable(false);
		txtNumeroEsq.setBounds(207, 40, 96, 20);
		panel_1.add(txtNumeroEsq);
		txtNumeroEsq.setColumns(10);
		
		// Label cargo candidato esquerda
		JLabel lblDescrio = new JLabel("Cargo:");
		lblDescrio.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblDescrio.setBounds(10, 71, 62, 20);
		panel_1.add(lblDescrio);
		
		// Label nome candidato2 esquerda
		JLabel lblNome_1 = new JLabel("Nome:");
		lblNome_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNome_1.setBounds(10, 171, 62, 20);
		panel_1.add(lblNome_1);
		
		// Saida nome2 candidatos esquerda
		txtNomeEsq2 = new JTextField();
		txtNomeEsq2.setToolTipText("Nome Senador");
		txtNomeEsq2.setEditable(false);
		txtNomeEsq2.setBounds(10, 193, 179, 20);
		panel_1.add(txtNomeEsq2);
		txtNomeEsq2.setColumns(10);
		
		// Saida numero2 candidatos esquerda
		txtNumeroEsq2 = new JTextField();
		txtNumeroEsq2.setToolTipText("Numero Senador");
		txtNumeroEsq2.setEditable(false);
		txtNumeroEsq2.setBounds(209, 193, 94, 20);
		panel_1.add(txtNumeroEsq2);
		txtNumeroEsq2.setColumns(10);
		
		// Label numero candidato2 esquerda
		JLabel lblNmero_1 = new JLabel("N\u00FAmero:");
		lblNmero_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNmero_1.setBounds(209, 174, 72, 14);
		panel_1.add(lblNmero_1);
		
		// Label cargo candidato2 esquerda
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblCargo.setBounds(10, 224, 62, 20);
		panel_1.add(lblCargo);
		
		txtCargoEsq = new JTextField();
		txtCargoEsq.setToolTipText("Cargo Presidente");
		txtCargoEsq.setEditable(false);
		txtCargoEsq.setBounds(10, 91, 179, 20);
		panel_1.add(txtCargoEsq);
		txtCargoEsq.setColumns(10);
		
		txtCargoEsq2 = new JTextField();
		txtCargoEsq2.setToolTipText("Cargo Senador");
		txtCargoEsq2.setEditable(false);
		txtCargoEsq2.setBounds(10, 245, 179, 20);
		panel_1.add(txtCargoEsq2);
		txtCargoEsq2.setColumns(10);
		
		// Panel lateral direita contendo os dados dos Candidatos da Direita
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(153, 153, 153));
		panel_2.setBounds(374, 149, 373, 301);
		panel_2.setBorder(BorderFactory.createTitledBorder("Partido da Direita"));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		// Label nome Candidato Direita
		JLabel lblNome_2 = new JLabel("Nome:");
		lblNome_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNome_2.setBounds(10, 22, 66, 14);
		panel_2.add(lblNome_2);
		
		// Saida nome candidato direita
		txtNomeDir = new JTextField();
		txtNomeDir.setToolTipText("Nome Presidente");
		txtNomeDir.setEditable(false);
		txtNomeDir.setBounds(10, 39, 179, 20);
		panel_2.add(txtNomeDir);
		txtNomeDir.setColumns(10);
		
		// Label numero Candidato Direita
		JLabel lblNmero_2 = new JLabel("N\u00FAmero:");
		lblNmero_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNmero_2.setBounds(209, 22, 77, 14);
		panel_2.add(lblNmero_2);
		
		// Label cargo Candidato Direita
		JLabel lblCargo_1 = new JLabel("Cargo:");
		lblCargo_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblCargo_1.setBounds(10, 70, 58, 20);
		panel_2.add(lblCargo_1);
		
		// Saida cargo candidato direita
		txtCargoDir = new JTextField();
		txtCargoDir.setToolTipText("Cargo Presidente");
		txtCargoDir.setEditable(false);
		txtCargoDir.setBounds(10, 92, 179, 20);
		panel_2.add(txtCargoDir);
		txtCargoDir.setColumns(10);
		
		// Label nome Candidato2 Direita
		JLabel lblNome_3 = new JLabel("Nome:");
		lblNome_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNome_3.setBounds(10, 173, 66, 14);
		panel_2.add(lblNome_3);
		
		// Saida nome candidato2 direita
		txtNomeDir2 = new JTextField();
		txtNomeDir2.setToolTipText("Nome Senador");
		txtNomeDir2.setEditable(false);
		txtNomeDir2.setBounds(10, 190, 179, 20);
		panel_2.add(txtNomeDir2);
		txtNomeDir2.setColumns(10);
		
		// Label numero Candidato2 Direita
		JLabel lblNmero_3 = new JLabel("N\u00FAmero:");
		lblNmero_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNmero_3.setBounds(209, 173, 77, 14);
		panel_2.add(lblNmero_3);
		
		// Saida numero candidato2 direita
		txtNumeroDir2 = new JTextField();
		txtNumeroDir2.setToolTipText("Numero Senador");
		txtNumeroDir2.setEditable(false);
		txtNumeroDir2.setBounds(209, 190, 96, 20);
		panel_2.add(txtNumeroDir2);
		txtNumeroDir2.setColumns(10);
		
		// Label cargo Candidato2 Direita
		JLabel lblCargo_2 = new JLabel("Cargo:");
		lblCargo_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblCargo_2.setBounds(10, 221, 66, 20);
		panel_2.add(lblCargo_2);
		
		txtNumeroDir = new JTextField();
		txtNumeroDir.setToolTipText("Numero Presidente");
		txtNumeroDir.setEditable(false);
		txtNumeroDir.setBounds(208, 39, 96, 20);
		panel_2.add(txtNumeroDir);
		txtNumeroDir.setColumns(10);
		
		txtCargoDir2 = new JTextField();
		txtCargoDir2.setToolTipText("Cargo Senador");
		txtCargoDir2.setEditable(false);
		txtCargoDir2.setBounds(10, 242, 179, 20);
		panel_2.add(txtCargoDir2);
		txtCargoDir2.setColumns(10);
		
		// Botao com retorno do metodo de busca dos candidatos
		JButton btnExibeCandidatos = new JButton("Exibir Candidatos");
		btnExibeCandidatos.setForeground(new Color(255, 255, 255));
		btnExibeCandidatos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnExibeCandidatos.setBackground(new Color(102, 102, 102));
		btnExibeCandidatos.setBounds(195, 460, 177, 32);
		contentPane.add(btnExibeCandidatos);
		
		// Botao Sair
		JButton btnSair = new JButton("Sair");
		btnSair.setForeground(new Color(255, 255, 255));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBackground(new Color(102, 102, 102));
		btnSair.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnSair.setBounds(374, 460, 177, 32);
		contentPane.add(btnSair);
		
		// Chamada dos Metodos
		btnExibeCandidatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscaDadosEsq();
				BuscaDadosDir();
			}
		});
	}
	// Busca os dados dos Candidatos no BD da tabela do partido da Esquerda
	public void BuscaDadosEsq() {
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
		RS = stmt.executeQuery(" Select * from esquerda ");
		while (RS.next()) {
			txtNomeEsq.setText(RS.getString("nome_candidato"));
			txtNumeroEsq.setText(RS.getString("numero"));
			txtCargoEsq.setText(RS.getString("cargo"));
			txtNomeEsq2.setText(RS.getString("nome_candidato2"));
			txtNumeroEsq2.setText(RS.getString("numero2"));
			txtCargoEsq2.setText(RS.getString("cargo2"));
		 
			consulta = false;
		 
		}
		 
		if (consulta) {
			JOptionPane.showMessageDialog(null, "Dados não Encontrados!", "Erro", JOptionPane.ERROR_MESSAGE);
		 
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
	// Busca os dados dos Candidatos no BD da tabela do partido da Direita
	public void BuscaDadosDir() {
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
		RS = stmt.executeQuery(" Select * from direita ");
		while (RS.next()) {
			txtNomeDir.setText(RS.getString("nome_candidato"));
			txtNumeroDir.setText(RS.getString("numero"));
			txtCargoDir.setText(RS.getString("cargo"));
			txtNomeDir2.setText(RS.getString("nome_candidato2"));
			txtNumeroDir2.setText(RS.getString("numero2"));
			txtCargoDir2.setText(RS.getString("cargo2"));
		 
			consulta = false;
		 
		}
		 
		if (consulta) {
			JOptionPane.showMessageDialog(null, "Dados não Encontrados!", "Erro", JOptionPane.ERROR_MESSAGE);
		 
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
