package programUrnaEletronica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class PaginaPartido extends JFrame {

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
					PaginaPartido frame = new PaginaPartido();
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
	public PaginaPartido() {
		setTitle("Partidos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 692, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Panel contendo o logo Partidos
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 153, 153));
		panel.setBounds(0, 0, 676, 155);
		contentPane.add(panel);
		panel.setLayout(null);
		
		// Label icone partidos
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PaginaPartido.class.getResource("/programUrnaImg/partidos.png")));
		label.setBounds(300, 27, 74, 69);
		panel.add(label);
		
		// Label Partidos
		JLabel lblPartidos = new JLabel("Partidos");
		lblPartidos.setForeground(new Color(255, 255, 255));
		lblPartidos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblPartidos.setBounds(284, 107, 122, 29);
		panel.add(lblPartidos);
		
		// Panel contendo o Partido da Esquerda
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 153, 153));
		panel_1.setBounds(0, 160, 337, 303);
		panel_1.setBorder(BorderFactory.createTitledBorder("Partido da Esquerda"));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JTextArea txtrWhatIsLorem = new JTextArea();
		txtrWhatIsLorem.setForeground(new Color(0, 0, 0));
		txtrWhatIsLorem.setBackground(new Color(153, 153, 153));
		txtrWhatIsLorem.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 12));
		txtrWhatIsLorem.setEditable(false);
		txtrWhatIsLorem.setRows(30);
		txtrWhatIsLorem.setText("What is Lorem Ipsum?\r\nLorem Ipsum is simply,remainingessentiallyun.\r\ndummy text of the printingand typesetting.\r\nLorem Ipsum has been theindustry's stand acse\r\ntext ever since the 1500s, whenan unknow desc\r\na galley of type and scrambled it to make fre\r\nbook. It has survived not only five centuries, \r\nleap into electronic typesetting,remainingess \r\nIt was popularised in the 1960s with the release \r\nof Letraset sheets containing Lorem Ipsum pas\r\nand more recently with desktop publishing  \r\nAldus PageMaker including versions of Lorem.\r\ntext ever since the 1500s, whenan unknown p\r\na galley of type and scrambled it to make a \r\nbook. It has survived not only five centuries,\r\nleap into electronic typesetting,remaininges. ");
		txtrWhatIsLorem.setBounds(10, 21, 317, 278);
		panel_1.add(txtrWhatIsLorem);
		
		// Panel contendo o Partido da Direita
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(153, 153, 153));
		panel_2.setLayout(null);
		panel_2.setBounds(339, 160, 337, 303);
		panel_2.setBorder(BorderFactory.createTitledBorder("Partido da Direita"));
		contentPane.add(panel_2);
		
		JTextArea txtrWhatIsLorem_1 = new JTextArea();
		txtrWhatIsLorem_1.setForeground(new Color(0, 0, 0));
		txtrWhatIsLorem_1.setBackground(new Color(153, 153, 153));
		txtrWhatIsLorem_1.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 12));
		txtrWhatIsLorem_1.setEditable(false);
		txtrWhatIsLorem_1.setText("What is Lorem Ipsum?\r\nLorem Ipsum is simply,remainingessenindustry.\r\ndummy text of the printingand typesetting in\r\nLorem Ipsum has been theindustry's standard\r\ntext ever since the 1500s, whenan unknown p\r\na galley of type and scrambled it to make a \r\nbook. It has survived not only five centuries, \r\nleap into electronic typesetting,remainingess\r\nIt was popularised in the 1960s with the release \r\nof Letraset sheets containing Lorem Ipsum passs,\r\nand more recently with desktop publishing soft \r\nAldus PageMaker including versions of Lorem\r\ntext ever since the 1500s, whenan unknown pri\r\na galley of type and scrambled it to make a ty\r\nbook. It has survived not only five centuries, \r\nleap into electronic typesetting,remaininges.");
		txtrWhatIsLorem_1.setRows(30);
		txtrWhatIsLorem_1.setBounds(10, 21, 317, 278);
		panel_2.add(txtrWhatIsLorem_1);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBackground(new Color(102, 102, 102));
		btnSair.setForeground(new Color(255, 255, 255));
		btnSair.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnSair.setBounds(298, 468, 89, 23);
		contentPane.add(btnSair);
	}
}
