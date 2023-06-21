package Visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import Controle.RankingBD;
import Modelo.Ranking;


import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaInserirVotar extends JFrame {

	private JPanel contentPane;
	private JTable tabelaFilmes;
	private JTextField txtPosicao;
	private JTextField txtExcluiNome;
	private JTextField txtVotos;
	private JTextField txtInserirFilme;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaInserirVotar frame = new JanelaInserirVotar();
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
	public JanelaInserirVotar() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 2000, 1200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 207, 47);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Rank");
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				JanelaRanking frame = new JanelaRanking();
				frame.setVisible(true);
			}
		});
		mnNewMenu.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Inserir/Votar");
		mnNewMenu_1.setBorder(new MatteBorder(3, 0, 3, 3, (Color) new Color(0, 0, 0)));
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("Fechar");
		mnNewMenu_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		mnNewMenu_2.setBorder(new MatteBorder(3, 0, 3, 3, (Color) new Color(0, 0, 0)));
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnNewMenu_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(632, 70, 736, 657);
		contentPane.add(scrollPane);
		
		tabelaFilmes = new JTable();
		tabelaFilmes.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Posi\u00E7\u00E3o", "Filme", "Votos"
				}
			));
			scrollPane.setViewportView(tabelaFilmes);
			
			JLabel lblPosicao = new JLabel("Posição:");
			lblPosicao.setBounds(632, 763, 63, 14);
			contentPane.add(lblPosicao);
			
			JLabel lblExcluirFilme = new JLabel("Filme:");
			lblExcluirFilme.setBounds(810, 763, 46, 14);
			contentPane.add(lblExcluirFilme);
			
			JLabel lblVotos = new JLabel("Votos:");
			lblVotos.setBounds(1089, 763, 46, 14);
			contentPane.add(lblVotos);
			
			txtPosicao = new JTextField();
			txtPosicao.setEditable(false);
			txtPosicao.setBounds(632, 788, 86, 20);
			contentPane.add(txtPosicao);
			txtPosicao.setColumns(10);
			
			txtExcluiNome = new JTextField();
			txtExcluiNome.setEditable(false);
			txtExcluiNome.setBounds(810, 788, 188, 20);
			contentPane.add(txtExcluiNome);
			txtExcluiNome.setColumns(10);
			
			txtVotos = new JTextField();
			txtVotos.setEditable(false);
			txtVotos.setBounds(1089, 788, 86, 20);
			contentPane.add(txtVotos);
			txtVotos.setColumns(10);
			
			JButton btnExcluir = new JButton("Excluir filme");
			btnExcluir.setBounds(1262, 787, 106, 23);
			contentPane.add(btnExcluir);
			
			JLabel lbllblInserirFilme = new JLabel("Filme:");
			lbllblInserirFilme.setBounds(632, 830, 46, 14);
			contentPane.add(lbllblInserirFilme);
			
			txtInserirFilme = new JTextField();
			txtInserirFilme.setColumns(10);
			txtInserirFilme.setBounds(632, 855, 188, 20);
			contentPane.add(txtInserirFilme);
			
			JButton btnInserir = new JButton("Inserir Filme");
			btnInserir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CadastrarFilme();
					listar();
				}
			});
			btnInserir.setBounds(892, 854, 106, 23);
			contentPane.add(btnInserir);
			
			JLabel lblVotarFilme = new JLabel("Filme:");
			lblVotarFilme.setBounds(632, 905, 46, 14);
			contentPane.add(lblVotarFilme);
			
			JButton btnVotar = new JButton("Votar");
			btnVotar.setBounds(731, 901, 89, 23);
			contentPane.add(btnVotar);
			
			txtId = new JTextField();
			txtId.setEnabled(false);
			txtId.setDisabledTextColor(SystemColor.menu);
			txtId.setBackground(SystemColor.menu);
			txtId.setBorder(null);
			txtId.setEditable(false);
			txtId.setBounds(512, 788, 86, 20);
			contentPane.add(txtId);
			txtId.setColumns(10);
		
		try {
			RankingBD rankingbd = new RankingBD();

			DefaultTableModel model = (DefaultTableModel) tabelaFilmes.getModel();
			model.setNumRows(0);

			ArrayList<Ranking> lista = rankingbd.pesquisarFilmes();
			for(int num = 0 ; num < lista.size() ; num ++) {
				model.addRow(new Object [] {
						lista.get(num).getIdFilme(),
						lista.get(num).getPosicaoFilme(),
						lista.get(num).getNomeFilme(),
						lista.get(num).getVotosFilme(),			

				});
			}

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Erro no Listar Valores" + e);
		}
		tabelaFilmes.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                	int row = tabelaFilmes.getSelectedRow();
                	txtId.setText(tabelaFilmes.getValueAt(row, 0).toString());
                    txtExcluiNome.setText(tabelaFilmes.getValueAt(row, 1).toString());
                    txtPosicao.setText(tabelaFilmes.getValueAt(row, 2).toString());
                    txtVotos.setText(tabelaFilmes.getValueAt(row, 3).toString());
                }
            }
        });
		
		
	}
	public void listar() {
	try {
		RankingBD rankingbd = new RankingBD();

		DefaultTableModel model = (DefaultTableModel) tabelaFilmes.getModel();
		model.setNumRows(0);

		ArrayList<Ranking> lista = rankingbd.pesquisarFilmes();
		for(int num = 0 ; num < lista.size() ; num ++) {
			model.addRow(new Object [] {
					lista.get(num).getIdFilme(),
					lista.get(num).getPosicaoFilme(),
					lista.get(num).getNomeFilme(),
					lista.get(num).getVotosFilme(),			

			});
		}

	} catch (Exception e) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(null,"Erro no Listar Valores" + e);
	}
	}
	private void CadastrarFilme() {
		String nome;
		int posicao, votos;

		nome = txtInserirFilme.getText();
		posicao = 0;
		votos = 0;
		
		Ranking filme = new Ranking();
		filme.setNomeFilme(nome);
		filme.setPosicaoFilme(posicao);
		filme.setVotosFilme(votos);

		RankingBD rankBD = new RankingBD();
		rankBD.cadastrarFilme(filme);
	}
}
