package programUrnaEletronica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PaginaPrincipal extends JFrame {

	/**
	 * @autor Carlos Rhedney
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaginaPrincipal frame = new PaginaPrincipal();
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
	public PaginaPrincipal() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("Acesso Rápido");
		setBounds(100, 100, 690, 530);
		
		// Jmenu topo
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		// JmenuItem Arquivo topo menu
		JMenu BtnArquivo = new JMenu("Arquivo");
		menuBar.add(BtnArquivo);
		
		// JmenuSubItem Sair topo menu
		JMenuItem BtnSairSubMenu = new JMenuItem("Sair");
		BtnSairSubMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		BtnSairSubMenu.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/programUrnaImg/sair-menu.png")));
		BtnArquivo.add(BtnSairSubMenu);
		
		// JmenuItem Partido topo menu
		JMenuItem btnPartidoMenu = new JMenuItem("Partido");
		btnPartidoMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaginaPartido frame = new PaginaPartido();
				frame.setVisible(true);
			}
		});
		btnPartidoMenu.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/programUrnaImg/partido-menu.png")));
		menuBar.add(btnPartidoMenu);
		
		// JmenuItem Candidato topo menu
		JMenuItem BtnCandidatoMenu = new JMenuItem("Candidatos");
		BtnCandidatoMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaginaCandidatos2 frame = new PaginaCandidatos2();
				frame.setVisible(true);
			}
		});
		BtnCandidatoMenu.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/programUrnaImg/candidatos-menu-2.png")));
		menuBar.add(BtnCandidatoMenu);
		
		// JmenuItem Eleitor topo menu
		JMenuItem BtnEleitorMenu = new JMenuItem("Eleitor");
		BtnEleitorMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaginaEleitor frame = new PaginaEleitor();
				frame.setVisible(true);
			}
		});
		BtnEleitorMenu.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/programUrnaImg/eleitor-menu.png")));
		menuBar.add(BtnEleitorMenu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Panel com logo Acesso Rapido topo
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 153, 153));
		panel.setBounds(0, 0, 684, 168);
		contentPane.add(panel);
		panel.setLayout(null);
		
		// Label logo Acesso Rapido topo
		JLabel lblAcessoRpido = new JLabel("Acesso R\u00E1pido");
		lblAcessoRpido.setForeground(new Color(255, 255, 255));
		lblAcessoRpido.setHorizontalAlignment(SwingConstants.CENTER);
		lblAcessoRpido.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblAcessoRpido.setBounds(229, 112, 225, 45);
		panel.add(lblAcessoRpido);
		
		// Label logo icone Acesso Rapido topo
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/programUrnaImg/acesso-rapido.png")));
		label.setBounds(294, 28, 92, 73);
		panel.add(label);
		
		// Botão Eleitor parte Central Esquerda
		JButton BtnEleitor = new JButton("Eleitor");
		BtnEleitor.setToolTipText("Cadastro Eleitor");
		BtnEleitor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaginaCadastroEleitor frame = new PaginaCadastroEleitor();
				frame.setVisible(true);
			}
		});
		BtnEleitor.setBackground(new Color(153, 153, 153));
		BtnEleitor.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/programUrnaImg/eleitor.png")));
		BtnEleitor.setBounds(42, 275, 165, 96);
		contentPane.add(BtnEleitor);
		
		// Botão Urna parte Central
		JButton btnUrna = new JButton("Urna");
		btnUrna.setToolTipText("Urna Eleitoral");
		btnUrna.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PaginaUrnaEletronica2 frame2 = new PaginaUrnaEletronica2();
				frame2.setVisible(true);
				PaginaUrnaEletronica frame = new PaginaUrnaEletronica();
				frame.setVisible(true);
			}
		});
		btnUrna.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/programUrnaImg/urna.png")));
		btnUrna.setBackground(new Color(153, 153, 153));
		btnUrna.setBounds(259, 275, 165, 96);
		contentPane.add(btnUrna);
		
		// Botão Candidatos parte Central Direita
		JButton btnCandidatos = new JButton("Votos");
		btnCandidatos.setToolTipText("Apuracao dos Votos");
		btnCandidatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaginaCandidatos frame = new PaginaCandidatos();
				frame.setVisible(true);
			}
		});
		btnCandidatos.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/programUrnaImg/candidatos.png")));
		btnCandidatos.setBackground(new Color(153, 153, 153));
		btnCandidatos.setBounds(468, 275, 172, 96);
		contentPane.add(btnCandidatos);
	}
}
