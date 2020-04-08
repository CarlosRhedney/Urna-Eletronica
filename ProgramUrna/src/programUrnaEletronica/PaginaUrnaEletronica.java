package programUrnaEletronica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PaginaUrnaEletronica extends JFrame {

	/**
	 * @autor Carlos Rhedney
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNumeroCandidato;
	private JTextField txtNomeCandidato;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaginaUrnaEletronica frame = new PaginaUrnaEletronica();
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
	public PaginaUrnaEletronica() {
		setResizable(false);
		setTitle("Urna Eletronica");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 693, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Panel contendo Foto, Nome e Número e os Avisos
		JPanel panel = new JPanel();
		panel.setBounds(10, 84, 350, 367);
		contentPane.add(panel);
		panel.setLayout(null);
		
		// Panel contendo a foto
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 153, 153));
		panel_1.setBounds(100, 24, 131, 169);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		// Label dentro do panel
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(PaginaUrnaEletronica.class.getResource("/programUrnaImg/user.png")));
		label.setBounds(0, 0, 131, 169);
		panel_1.add(label);
		
		// Label nome onde retorna o nome do candidato escolhido
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNome.setBounds(10, 212, 55, 19);
		panel.add(lblNome);
		
		// Label numero onde retorna os numeros digitados na urna
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNmero.setBounds(10, 245, 72, 19);
		panel.add(lblNmero);
		
		// Panel contendo os avisos
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(153, 255, 204));
		panel_2.setBounds(0, 286, 350, 81);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		// Label aviso TECLE VERDE PARA CONFIRMAR
		JLabel lblNewLabel = new JLabel("TECLE VERDE PARA CONFIRMAR");
		lblNewLabel.setForeground(new Color(0, 255, 102));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(32, 0, 308, 41);
		panel_2.add(lblNewLabel);
		
		// Label aviso TECLE LARANJA PARA CORRIGIR
		JLabel lblTecleLaranjaPara = new JLabel("TECLE LARANJA PARA CORRIGIR");
		lblTecleLaranjaPara.setForeground(new Color(255, 153, 51));
		lblTecleLaranjaPara.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblTecleLaranjaPara.setBounds(32, 52, 308, 29);
		panel_2.add(lblTecleLaranjaPara);
		
		// Entrada do numero do candidato quando clicado no botao
		txtNumeroCandidato = new JTextField();
		txtNumeroCandidato.setToolTipText("Numero Presidente");
		txtNumeroCandidato.setEditable(false);
		txtNumeroCandidato.setBounds(81, 246, 55, 20);
		panel.add(txtNumeroCandidato);
		txtNumeroCandidato.setColumns(10);
		
		// Saida com nome do candidato
		txtNomeCandidato = new JTextField();
		txtNomeCandidato.setToolTipText("Nome Presidente");
		txtNomeCandidato.setEditable(false);
		txtNomeCandidato.setBounds(63, 213, 214, 20);
		panel.add(txtNomeCandidato);
		txtNomeCandidato.setColumns(10);
		
		// Botão 1 e o evento de captura do numero, testa se o campo foi preenchido e seta o numero no jtextfield
		JButton button1 = new JButton("1");
		button1.setForeground(new Color(255, 255, 255));
		button1.setBackground(new Color(51, 102, 102));
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NumCandidato = txtNumeroCandidato.getText();
				if(NumCandidato == null || NumCandidato.isEmpty()) {
					txtNumeroCandidato.setText("1");
				}else {
					txtNumeroCandidato.setText(NumCandidato + "1");
				}
				// Testa se numero digitado é igual a algum candidato
				// Se nao for é redirecionado para a pagina de candidatos
				String NumCand = txtNumeroCandidato.getText();
				if(NumCand != "45" || NumCand != "25") {
					JOptionPane.showMessageDialog(null, "Candidato Inválido, abrindo tela de candidatos!", "Erro", JOptionPane.ERROR_MESSAGE);
					PaginaCandidatos2 frame = new PaginaCandidatos2();
					frame.setVisible(true);
				}
			}
		});
		button1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		button1.setBounds(378, 84, 89, 48);
		contentPane.add(button1);
		
		// Botão 2 e o evento de captura do numero, testa se o campo foi preenchido e seta o numero no jtextfield
		JButton button2 = new JButton("2");
		button2.setForeground(new Color(255, 255, 255));
		button2.setBackground(new Color(51, 102, 102));
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NumCandidato = txtNumeroCandidato.getText();
				if(NumCandidato == null || NumCandidato.isEmpty()) {
					txtNumeroCandidato.setText("2");
				}else {
					txtNumeroCandidato.setText(NumCandidato + "2");
				}
			}
		});
		button2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		button2.setBounds(477, 84, 89, 48);
		contentPane.add(button2);
		
		// Botão 3 e o evento de captura do numero, testa se o campo foi preenchido e seta o numero no jtextfield
		JButton button3 = new JButton("3");
		button3.setForeground(new Color(255, 255, 255));
		button3.setBackground(new Color(51, 102, 102));
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NumCandidato = txtNumeroCandidato.getText();
				if(NumCandidato == null || NumCandidato.isEmpty()) {
					txtNumeroCandidato.setText("3");
				}else {
					txtNumeroCandidato.setText(NumCandidato + "3");
				}
				// Testa se numero digitado é igual a algum candidato
				// Se nao for é redirecionado para a pagina de candidatos
				String NumCand = txtNumeroCandidato.getText();
				if(NumCand != "45" || NumCand != "25") {
					JOptionPane.showMessageDialog(null, "Candidato Inválido, abrindo tela de candidatos!", "Erro", JOptionPane.ERROR_MESSAGE);
					PaginaCandidatos2 frame = new PaginaCandidatos2();
					frame.setVisible(true);
				}
			}
		});
		button3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		button3.setBounds(576, 84, 89, 48);
		contentPane.add(button3);
		
		// Botão 4 e o evento de captura do numero, testa se o campo foi preenchido e seta o numero no jtextfield
		JButton button4 = new JButton("4");
		button4.setForeground(new Color(255, 255, 255));
		button4.setBackground(new Color(51, 102, 102));
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NumCandidato = txtNumeroCandidato.getText();
				if(NumCandidato == null || NumCandidato.isEmpty()) {
					txtNumeroCandidato.setText("4");
				}else {
					txtNumeroCandidato.setText(NumCandidato + "4");
				}
			}
		});
		button4.setFont(new Font("Tahoma", Font.PLAIN, 22));
		button4.setBounds(378, 153, 89, 48);
		contentPane.add(button4);
		
		// Botão 5 e o evento de captura do numero, testa se o campo foi preenchido e seta o numero no jtextfield
		JButton button5 = new JButton("5");
		button5.setForeground(new Color(255, 255, 255));
		button5.setBackground(new Color(51, 102, 102));
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NumCandidato = txtNumeroCandidato.getText();
				if(NumCandidato == null || NumCandidato.isEmpty()) {
					txtNumeroCandidato.setText("5");
				}else {
					txtNumeroCandidato.setText(NumCandidato + "5");
				}
				// Testa se numero digitado é igual a algum candidato
				// Se nao for é redirecionado para a pagina de candidatos
				String NumCand = txtNumeroCandidato.getText();
				if(NumCand.equals("45")) {
					txtNomeCandidato.setText("Floriano Peixoto");
				}else if(NumCand.equals("25")) {
					txtNomeCandidato.setText("Afonso Pena");
				}else if(NumCand != "45" || NumCand != "25") {
					JOptionPane.showMessageDialog(null, "Candidato Inválido, abrindo tela de candidatos!", "Erro", JOptionPane.ERROR_MESSAGE);
					PaginaCandidatos2 frame = new PaginaCandidatos2();
					frame.setVisible(true);
				}
			}
		});
		button5.setFont(new Font("Tahoma", Font.PLAIN, 22));
		button5.setBounds(477, 153, 89, 48);
		contentPane.add(button5);
		
		// Botão 6 e o evento de captura do numero, testa se o campo foi preenchido e seta o numero no jtextfield
		JButton button6 = new JButton("6");
		button6.setForeground(new Color(255, 255, 255));
		button6.setBackground(new Color(51, 102, 102));
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NumCandidato = txtNumeroCandidato.getText();
				if(NumCandidato == null || NumCandidato.isEmpty()) {
					txtNumeroCandidato.setText("6");
				}else {
					txtNumeroCandidato.setText(NumCandidato + "6");
				}
				// Testa se numero digitado é igual a algum candidato
				// Se nao for é redirecionado para a pagina de candidatos
				String NumCand = txtNumeroCandidato.getText();
				if(NumCand != "45" || NumCand != "25") {
					JOptionPane.showMessageDialog(null, "Candidato Inválido, abrindo tela de candidatos!", "Erro", JOptionPane.ERROR_MESSAGE);
					PaginaCandidatos2 frame = new PaginaCandidatos2();
					frame.setVisible(true);
				}
			}
		});
		button6.setFont(new Font("Tahoma", Font.PLAIN, 22));
		button6.setBounds(576, 153, 89, 48);
		contentPane.add(button6);
		
		// Botão 7 e o evento de captura do numero, testa se o campo foi preenchido e seta o numero no jtextfield
		JButton button7 = new JButton("7");
		button7.setForeground(new Color(255, 255, 255));
		button7.setBackground(new Color(51, 102, 102));
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NumCandidato = txtNumeroCandidato.getText();
				if(NumCandidato == null || NumCandidato.isEmpty()) {
					txtNumeroCandidato.setText("7");
				}else {
					txtNumeroCandidato.setText(NumCandidato + "7");
				}
				// Testa se numero digitado é igual a algum candidato
				// Se nao for é redirecionado para a pagina de candidatos
				String NumCand = txtNumeroCandidato.getText();
				if(NumCand != "45" || NumCand != "25") {
					JOptionPane.showMessageDialog(null, "Candidato Inválido, abrindo tela de candidatos!", "Erro", JOptionPane.ERROR_MESSAGE);
					PaginaCandidatos2 frame = new PaginaCandidatos2();
					frame.setVisible(true);
				}
			}
		});
		button7.setFont(new Font("Tahoma", Font.PLAIN, 22));
		button7.setBounds(378, 224, 89, 48);
		contentPane.add(button7);
		
		// Botão 8 e o evento de captura do numero, testa se o campo foi preenchido e seta o numero no jtextfield
		JButton button8 = new JButton("8");
		button8.setForeground(new Color(255, 255, 255));
		button8.setBackground(new Color(51, 102, 102));
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NumCandidato = txtNumeroCandidato.getText();
				if(NumCandidato == null || NumCandidato.isEmpty()) {
					txtNumeroCandidato.setText("8");
				}else {
					txtNumeroCandidato.setText(NumCandidato + "8");
				}
				// Testa se numero digitado é igual a algum candidato
				// Se nao for é redirecionado para a pagina de candidatos
				String NumCand = txtNumeroCandidato.getText();
				if(NumCand != "45" || NumCand != "25") {
					JOptionPane.showMessageDialog(null, "Candidato Inválido, abrindo tela de candidatos!", "Erro", JOptionPane.ERROR_MESSAGE);
					PaginaCandidatos2 frame = new PaginaCandidatos2();
					frame.setVisible(true);
				}
			}
		});
		button8.setFont(new Font("Tahoma", Font.PLAIN, 22));
		button8.setBounds(477, 224, 89, 48);
		contentPane.add(button8);
		
		// Botão 9 e o evento de captura do numero, testa se o campo foi preenchido e seta o numero no jtextfield
		JButton button9 = new JButton("9");
		button9.setForeground(new Color(255, 255, 255));
		button9.setBackground(new Color(51, 102, 102));
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NumCandidato = txtNumeroCandidato.getText();
				if(NumCandidato == null || NumCandidato.isEmpty()) {
					txtNumeroCandidato.setText("9");
				}else {
					txtNumeroCandidato.setText(NumCandidato + "9");
				}
				// Testa se numero digitado é igual a algum candidato
				// Se nao for é redirecionado para a pagina de candidatos
				String NumCand = txtNumeroCandidato.getText();
				if(NumCand != "45" || NumCand != "25") {
					JOptionPane.showMessageDialog(null, "Candidato Inválido, abrindo tela de candidatos!", "Erro", JOptionPane.ERROR_MESSAGE);
					PaginaCandidatos2 frame = new PaginaCandidatos2();
					frame.setVisible(true);
				}
			}
		});
		button9.setFont(new Font("Tahoma", Font.PLAIN, 22));
		button9.setBounds(576, 224, 89, 48);
		contentPane.add(button9);
		
		// Botão 0 e o evento de captura do numero, testa se o campo foi preenchido e seta o numero no jtextfield
		JButton button0 = new JButton("0");
		button0.setForeground(new Color(255, 255, 255));
		button0.setBackground(new Color(51, 102, 102));
		button0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NumCandidato = txtNumeroCandidato.getText();
				if(NumCandidato == null || NumCandidato.isEmpty()) {
					txtNumeroCandidato.setText("0");
				}else {
					txtNumeroCandidato.setText(NumCandidato + "0");
				}
				// Testa se numero digitado é igual a algum candidato
				// Se nao for é redirecionado para a pagina de candidatos
				String NumCand = txtNumeroCandidato.getText();
				if(NumCand != "45" || NumCand != "25") {
					JOptionPane.showMessageDialog(null, "Candidato Inválido, abrindo tela de candidatos!", "Erro", JOptionPane.ERROR_MESSAGE);
					PaginaCandidatos2 frame = new PaginaCandidatos2();
					frame.setVisible(true);
				}
			}
		});
		button0.setFont(new Font("Tahoma", Font.PLAIN, 22));
		button0.setBounds(477, 286, 89, 48);
		contentPane.add(button0);
		
		// Botão Branco
		JButton btnBranco = new JButton("Branco");
		btnBranco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VotoBranco();
			}
		});
		btnBranco.setBackground(new Color(255, 255, 255));
		btnBranco.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBranco.setBounds(370, 403, 89, 48);
		contentPane.add(btnBranco);
		
		// Botão Corrige e o evento chamando o metodo que limpa os campos nome e numero
		JButton btnCorrige = new JButton("Corrige");
		btnCorrige.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparNumero();
			}
		});
		btnCorrige.setBackground(new Color(255, 153, 51));
		btnCorrige.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCorrige.setBounds(464, 403, 97, 48);
		contentPane.add(btnCorrige);
		
		// Botão Confirma chamando o metodo de insercao de votos no BD.
		JButton btnConfirma = new JButton("Confirma");
		btnConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfirmaVoto();
				dispose();
			}
		});
		btnConfirma.setBackground(new Color(51, 255, 102));
		btnConfirma.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnConfirma.setBounds(565, 403, 109, 48);
		contentPane.add(btnConfirma);
		
		// Label logo Urna Eletronica topo
		JLabel lblUrnaEletrnica = new JLabel("Presidente");
		lblUrnaEletrnica.setHorizontalAlignment(SwingConstants.CENTER);
		lblUrnaEletrnica.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 65));
		lblUrnaEletrnica.setBounds(10, 0, 655, 73);
		contentPane.add(lblUrnaEletrnica);
	}
	// Metodo que limpa os campos nome e numero do candidato
	public void limparNumero() {
		txtNumeroCandidato.setText("");
		txtNomeCandidato.setText("");
	}
	// Metodo chamado no botao confirma, verifica para qual tabela é enviado o voto
	public void ConfirmaVoto() {
		try {
		// * Driver de conexao com o MySQL.
		Class.forName("com.mysql.jdbc.Driver");
		 
		// Conexão como BD.
		Connection con = DriverManager.getConnection(
		"jdbc:mysql://localhost/urna", "root", "");
		 
		// Objeto comdo SQL.
		java.sql.Statement stmt = con.createStatement();
		 
		// Pega os votos e verifica qual é qual, para fazer a insercao no banco de dados.
		String votos = txtNumeroCandidato.getText();
		if(votos.equals("45")) {
			stmt.executeUpdate("insert into votosdir (votos) values ('" + votos + "')");
			JOptionPane.showMessageDialog(null, "Voto cadastrado com sucesso!", "Info", JOptionPane.INFORMATION_MESSAGE);
		}else if(votos.equals("25")) {
			stmt.executeUpdate("insert into votosesq (votos) values ('" + votos + "')");
			JOptionPane.showMessageDialog(null, "Voto cadastrado com sucesso!", "Info", JOptionPane.INFORMATION_MESSAGE);
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
	public void VotoBranco() {
		try {
		// * Driver de conexao com o MySQL.
		Class.forName("com.mysql.jdbc.Driver");
		 
		// Conexão como BD.
		Connection con = DriverManager.getConnection(
		"jdbc:mysql://localhost/urna", "root", "");
		 
		// Objeto comdo SQL.
		java.sql.Statement stmt = con.createStatement();
		 
		// Insere o 0 no bd, no caso de voto em branco.
		String votos = "0";
			stmt.executeUpdate("insert into votosbrancos (votos) values ('" + votos + "')");
			JOptionPane.showMessageDialog(null, "Voto cadastrado com sucesso!", "Info", JOptionPane.INFORMATION_MESSAGE);
			dispose();
		
		
		// Fecha a conexão com BD.
		con.close();
		 
		// Trata os erros de conexão.
		} catch (SQLException Erro) {
			JOptionPane.showMessageDialog(null,"Erro ao tentar se conectar com o BD MYSQL: " + Erro.getMessage());
		 
		} catch (ClassNotFoundException Erro) {
			JOptionPane.showMessageDialog(null, "Driver não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
		 
		}
	}
}
