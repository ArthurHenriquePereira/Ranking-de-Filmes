package Visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controle.RankingBD;
import Modelo.Ranking;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class JanelaRanking extends JFrame {

	private JPanel contentPane;
	private JTable tabelaFilmes;
	private JMenuBar menuBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaRanking frame = new JanelaRanking();
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
	public JanelaRanking() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 2000, 1200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(600, 109, 799, 847);
		contentPane.add(scrollPane);
		
		tabelaFilmes = new JTable();
		tabelaFilmes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Posi\u00E7\u00E3o", "Filme", "Votos"
			}
		));
		scrollPane.setViewportView(tabelaFilmes);
		
		try {
			RankingBD rankingbd = new RankingBD();

			DefaultTableModel model = (DefaultTableModel) tabelaFilmes.getModel();
			model.setNumRows(0);

			ArrayList<Ranking> lista = rankingbd.pesquisarFilmes();
			for(int num = 0 ; num < lista.size() ; num ++) {
				model.addRow(new Object [] {
						lista.get(num).getPosicaoFilme(),
						lista.get(num).getNomeFilme(),
						lista.get(num).getVotosFilme(),			

				});
			}

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Erro no Listar Valores" + e);
		}
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 207, 47);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Rank");
		mnNewMenu.setBorder(new MatteBorder(4, 4, 3, 3, (Color) new Color(0, 0, 0)));
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Inserir/Votar");
		mnNewMenu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				JanelaInserirVotar frame = new JanelaInserirVotar();
				frame.setVisible(true);
			}
		});
		mnNewMenu_1.setBorder(new MatteBorder(3, 0, 3, 3, (Color) new Color(0, 0, 0)));
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("Fechar");
		mnNewMenu_2.setBorder(new MatteBorder(3, 0, 3, 3, (Color) new Color(0, 0, 0)));
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnNewMenu_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		menuBar.add(mnNewMenu_2);
		
	}
}
