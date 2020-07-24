package taschenrechner;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	Expression expr= new Expression();
	String problem= "";
	String history[]= new String[50];
	int current_h_pos= 0;
	char mode= 'd';
	String ans= "0.0";
	int current_cur_pos= 0;
	double mem= 0.0;
	double mem_x=0.0, mem_y=0.0, mem_z=0.0;
	JLabel var_display, var_res_display;
	Num_Convertor num_conv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setResizable(false);
					frame.setTitle("Taschenrechner");
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
	public MainFrame() {
		for(int i=0; i<history.length; i++) {
			history[i]= "";
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		var_display = new JLabel("Anfrage", SwingConstants.RIGHT);
		var_display.setFont(new Font("DialogInput", Font.BOLD, 16));
		var_display.setToolTipText("Das ist die Anzeige des Rechners...");
		var_display.setBackground(new Color(176, 224, 230));
		var_display.setBounds(39, 38, 723, 39);
		contentPane.add(var_display);
		
		var_res_display = new JLabel("Ergebnis", SwingConstants.CENTER);
		var_res_display.setToolTipText("Anzeige des Rech...");
		var_res_display.setFont(new Font("Dialog", Font.BOLD, 20));
		
		var_res_display.setBounds(399, 89, 363, 39);
		contentPane.add(var_res_display);
		
		JButton var_btn_0 = new JButton("0");
		var_btn_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				problem=problem+ '0';
				update_display();
			}
		});
		var_btn_0.setBounds(391, 503, 132, 30);
		contentPane.add(var_btn_0);
		
		JButton var_btn_dot = new JButton(".");
		var_btn_dot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				problem=problem+ '.';
				update_display();
			}
		});
		var_btn_dot.setBounds(319, 503, 60, 30);
		contentPane.add(var_btn_dot);
		
		JButton var_btn_3 = new JButton("3");
		var_btn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				problem=problem+ '3';
				update_display();
			}
		});
		var_btn_3.setBounds(463, 461, 60, 30);
		contentPane.add(var_btn_3);
		
		JButton var_btn_2 = new JButton("2");
		var_btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				problem=problem+ '2';
				update_display();
			}
		});
		var_btn_2.setBounds(391, 461, 60, 30);
		contentPane.add(var_btn_2);
		
		JButton var_btn_1 = new JButton("1");
		var_btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				problem=problem+ '1';
				update_display();
			}
		});
		var_btn_1.setBounds(319, 461, 60, 30);
		contentPane.add(var_btn_1);
		
		JButton var_btn_6 = new JButton("6");
		var_btn_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				problem=problem+ '6';
				update_display();
			}
		});
		var_btn_6.setBounds(463, 417, 60, 30);
		contentPane.add(var_btn_6);
		
		JButton var_btn_5 = new JButton("5");
		var_btn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				problem=problem+ '5';
				update_display();
			}
		});
		var_btn_5.setBounds(391, 417, 60, 30);
		contentPane.add(var_btn_5);
		
		JButton var_btn_4 = new JButton("4");
		var_btn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				problem=problem+ '4';
				update_display();
			}
		});
		var_btn_4.setBounds(319, 417, 60, 30);
		contentPane.add(var_btn_4);
		
		JButton var_brn_7 = new JButton("7");
		var_brn_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				problem=problem+ '7';
				update_display();
			}
		});
		var_brn_7.setBounds(319, 375, 60, 30);
		contentPane.add(var_brn_7);
		
		JButton var_btn_8 = new JButton("8");
		var_btn_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				problem=problem+ '8';
				update_display();
			}
		});
		var_btn_8.setBounds(391, 375, 60, 30);
		contentPane.add(var_btn_8);
		
		JButton var_btn_9 = new JButton("9");
		var_btn_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				problem=problem+ '9';
				update_display();
			}
		});
		var_btn_9.setBounds(463, 375, 60, 30);
		contentPane.add(var_btn_9);
		
		JButton buttvar_btn_pluson = new JButton("+");
		buttvar_btn_pluson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				problem=problem+ '+';
				update_display();
			}
		});
		buttvar_btn_pluson.setFont(new Font("Dialog", Font.BOLD, 20));
		buttvar_btn_pluson.setBackground(new Color(224, 255, 255));
		buttvar_btn_pluson.setBounds(535, 461, 60, 72);
		contentPane.add(buttvar_btn_pluson);
		
		JButton var_btn_subtr = new JButton("-");
		var_btn_subtr.setBackground(new Color(224, 255, 255));
		var_btn_subtr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				problem=problem+ '-';
				update_display();
			}
		});
		var_btn_subtr.setBounds(607, 461, 60, 30);
		contentPane.add(var_btn_subtr);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 140, 776, 16);
		contentPane.add(separator);
		
		JButton var_btn_div = new JButton("/");
		var_btn_div.setBackground(new Color(224, 255, 255));
		var_btn_div.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				problem=problem+ '/';
				update_display();
			}
		});
		var_btn_div.setBounds(607, 417, 60, 30);
		contentPane.add(var_btn_div);
		
		JButton var_btn_mul = new JButton("x");
		var_btn_mul.setBackground(new Color(224, 255, 255));
		var_btn_mul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				problem=problem+ '*';
				update_display();
			}
		});
		var_btn_mul.setBounds(535, 417, 60, 30);
		contentPane.add(var_btn_mul);
		
		JButton var_btn_brace1 = new JButton("(");
		var_btn_brace1.setBackground(new Color(220, 220, 220));
		var_btn_brace1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				problem=problem+ '(';
				update_display();
			}
		});
		var_btn_brace1.setBounds(535, 375, 60, 30);
		contentPane.add(var_btn_brace1);
		
		JButton var_btn_brace2 = new JButton(")");
		var_btn_brace2.setBackground(new Color(220, 220, 220));
		var_btn_brace2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				problem=problem+ ')';
				update_display();
			}
		});
		var_btn_brace2.setBounds(607, 375, 60, 30);
		contentPane.add(var_btn_brace2);
		
		JButton var_btn_eval = new JButton("=");
		var_btn_eval.setBackground(new Color(245, 222, 179));
		var_btn_eval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update_display();
				set_history(problem);
				expr.set(format_problem());
				ans= expr.evaluate();
				var_res_display.setText(ans);
				problem= "";
				current_h_pos= 0;
			}
		});
		var_btn_eval.setFont(new Font("Dialog", Font.BOLD, 24));
		var_btn_eval.setBounds(607, 503, 132, 30);
		contentPane.add(var_btn_eval);
		
		JButton var_btn_clear = new JButton("Del");
		var_btn_clear.setToolTipText("Letzte Zahl löschen");
		var_btn_clear.setIcon(null);
		var_btn_clear.setForeground(new Color(0, 0, 0));
		var_btn_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					problem= problem.substring(0, (problem.length()-current_cur_pos-1)) + problem.substring(problem.length()-current_cur_pos);
				}
				catch(Exception exc) {
					
				}
				update_display();
			}
		});
		var_btn_clear.setFont(new Font("Dialog", Font.BOLD, 10));
		var_btn_clear.setBackground(new Color(250, 128, 114));
		var_btn_clear.setBounds(679, 375, 60, 72);
		contentPane.add(var_btn_clear);
		
		JButton var_btn_ans = new JButton("ANT");
		var_btn_ans.setToolTipText("Die Letzte Antwort benutzen");
		var_btn_ans.setBackground(new Color(245, 222, 179));
		var_btn_ans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				problem= problem+ "Ant";
				update_display();
			}
		});
		var_btn_ans.setFont(new Font("Dialog", Font.BOLD, 10));
		var_btn_ans.setBounds(679, 461, 60, 30);
		contentPane.add(var_btn_ans);
		
		JButton var_btn_ac = new JButton("AC");
		var_btn_ac.setForeground(new Color(255, 0, 0));
		var_btn_ac.setFont(new Font("Dialog", Font.BOLD, 26));
		var_btn_ac.setToolTipText("Alles löschen (Nicht X, Y, Z)");
		var_btn_ac.setBackground(new Color(175, 238, 238));
		var_btn_ac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				problem= "";
				var_res_display.setText("");
				current_h_pos=0;
				update_display();
			}
		});
		var_btn_ac.setBounds(607, 291, 132, 72);
		contentPane.add(var_btn_ac);
		
		JButton var_btn_tan = new JButton("Tan");
		var_btn_tan.setBackground(new Color(176, 196, 222));
		var_btn_tan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				problem= problem+ "Tan";
				update_display();
			}
		});
		var_btn_tan.setFont(new Font("Dialog", Font.BOLD, 10));
		var_btn_tan.setBounds(201, 461, 60, 30);
		contentPane.add(var_btn_tan);
		
		JButton var_btn_cos = new JButton("Cos");
		var_btn_cos.setBackground(new Color(176, 196, 222));
		var_btn_cos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				problem= problem+ "Cos";
				update_display();
			}
		});
		var_btn_cos.setFont(new Font("Dialog", Font.BOLD, 10));
		var_btn_cos.setBounds(129, 461, 60, 30);
		contentPane.add(var_btn_cos);
		
		JButton var_btn_sin = new JButton("Sin");
		var_btn_sin.setBackground(new Color(176, 196, 222));
		var_btn_sin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				problem= problem+ "Sin";
				update_display();
			}
		});
		var_btn_sin.setFont(new Font("Dialog", Font.BOLD, 10));
		var_btn_sin.setBounds(57, 461, 60, 30);
		contentPane.add(var_btn_sin);
		
		JButton var_btn_atan = new JButton("aTan");
		var_btn_atan.setToolTipText("Tan Inv");
		var_btn_atan.setBackground(new Color(173, 216, 230));
		var_btn_atan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				problem= problem+ "aTan";
				update_display();
			}
		});
		var_btn_atan.setFont(new Font("Dialog", Font.BOLD, 9));
		var_btn_atan.setBounds(201, 503, 60, 30);
		contentPane.add(var_btn_atan);
		
		JButton var_btn_acos = new JButton("aCos");
		var_btn_acos.setToolTipText("Cos Inv");
		var_btn_acos.setBackground(new Color(173, 216, 230));
		var_btn_acos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				problem= problem+ "aCos";
				update_display();
			}
		});
		var_btn_acos.setFont(new Font("Dialog", Font.BOLD, 9));
		var_btn_acos.setBounds(129, 503, 60, 30);
		contentPane.add(var_btn_acos);
		
		JButton var_btn_asin = new JButton("aSin");
		var_btn_asin.setToolTipText("Sin Inv");
		var_btn_asin.setBackground(new Color(173, 216, 230));
		var_btn_asin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				problem= problem+ "aSin";
				update_display();
			}
		});
		var_btn_asin.setFont(new Font("Dialog", Font.BOLD, 9));
		var_btn_asin.setBounds(57, 503, 60, 30);
		contentPane.add(var_btn_asin);
		
		
		JButton var_btn_mode = new JButton("Modus - Grad");
		var_btn_mode.setBackground(Color.LIGHT_GRAY);
		var_btn_mode.setToolTipText("Trigonometrische Modus wählen...");
		var_btn_mode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mode== 'd') {
					expr.setMode('r');
					mode= 'r';
					var_btn_mode.setText("Modus - Radian");
				}
				else if(mode== 'r') {
					expr.setMode('g');
					mode= 'g';
					var_btn_mode.setText("Modus - Gradian");
				}
				else if(mode== 'g') {
					expr.setMode('d');
					mode= 'd';
					var_btn_mode.setText("Modus - Grad");
				}
			}
		});
		var_btn_mode.setFont(new Font("Dialog", Font.BOLD, 10));
		var_btn_mode.setBounds(57, 400, 204, 30);
		contentPane.add(var_btn_mode);
			
		
		JButton var_btn_pi = new JButton("π");
		var_btn_pi.setToolTipText("Die größte PI");
		var_btn_pi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				problem= problem+ "π";
				update_display();
			}
		});
		var_btn_pi.setBackground(new Color(255, 192, 203));
		var_btn_pi.setFont(new Font("Dialog", Font.BOLD, 14));
		var_btn_pi.setBounds(201, 291, 60, 30);
		contentPane.add(var_btn_pi);
		
		JButton var_btn_eu = new JButton("e");
		var_btn_eu.setBackground(new Color(250, 240, 230));
		var_btn_eu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				problem= problem+ "e";
				update_display();
			}
		});
		var_btn_eu.setFont(new Font("Dialog", Font.BOLD, 12));
		var_btn_eu.setBounds(57, 248, 60, 30);
		contentPane.add(var_btn_eu);
		
		JButton var_btn_pow = new JButton("^");
		var_btn_pow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				problem= problem+ "^";
				update_display();
			}
		});
		var_btn_pow.setBackground(new Color(250, 235, 215));
		var_btn_pow.setFont(new Font("Dialog", Font.BOLD, 14));
		var_btn_pow.setBounds(201, 206, 60, 30);
		contentPane.add(var_btn_pow);
		
		JButton var_btn_log = new JButton("log");
		var_btn_log.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				problem= problem+ "log";
				update_display();
			}
		});
		var_btn_log.setBackground(new Color(250, 235, 215));
		var_btn_log.setFont(new Font("Dialog", Font.BOLD, 10));
		var_btn_log.setBounds(201, 248, 60, 30);
		contentPane.add(var_btn_log);
		
		JButton var_btn_ln = new JButton("ln");
		var_btn_ln.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				problem= problem+ "ln";
				update_display();
			}
		});
		var_btn_ln.setBackground(new Color(250, 240, 230));
		var_btn_ln.setFont(new Font("Dialog", Font.BOLD, 10));
		var_btn_ln.setBounds(129, 248, 60, 30);
		contentPane.add(var_btn_ln);
		
		JButton var_btn_sq = new JButton("^2");
		var_btn_sq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				problem= problem+ "^2";
				update_display();
			}
		});
		var_btn_sq.setBackground(new Color(250, 235, 215));
		var_btn_sq.setFont(new Font("Dialog", Font.BOLD, 10));
		var_btn_sq.setBounds(57, 206, 60, 30);
		contentPane.add(var_btn_sq);
		
		JButton var_btn_sqrt = new JButton("√");
		var_btn_sqrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				problem= problem+ "√";
				update_display();
			}
		});
		var_btn_sqrt.setBackground(new Color(250, 235, 215));
		var_btn_sqrt.setFont(new Font("Dialog", Font.BOLD, 10));
		var_btn_sqrt.setBounds(129, 206, 60, 30);
		contentPane.add(var_btn_sqrt);
		
		JButton var_btn_cube = new JButton("^3");
		var_btn_cube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				problem= problem+ "^3";
				update_display();
			}
		});
		var_btn_cube.setFont(new Font("Dialog", Font.BOLD, 10));
		var_btn_cube.setBackground(new Color(250, 235, 215));
		var_btn_cube.setBounds(57, 164, 60, 30);
		contentPane.add(var_btn_cube);
		
		
		
		
		JToggleButton var_btn_str = new JToggleButton("STO");
		var_btn_str.setToolTipText("In A variable speichern(X, Y, Z)");
		var_btn_str.setFont(new Font("Dialog", Font.BOLD, 10));
		var_btn_str.setBackground(new Color(152, 251, 152));
		var_btn_str.setBounds(535, 333, 60, 30);
		contentPane.add(var_btn_str);
		
		JButton var_btn_mem_x = new JButton("X");
		var_btn_mem_x.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(var_btn_str.isSelected()) {
					if(problem.length()>0) {
						expr.set(format_problem());
						String tmp_ans= expr.evaluate();
						var_res_display.setText(tmp_ans);
						mem_x= Double.parseDouble(tmp_ans);
					}
					else {
						mem_x= Double.parseDouble(ans);
					}
				}
				else {
					problem= problem+'X';
				}
				var_btn_str.setSelected(false);
				update_display();
			}
		});
		var_btn_mem_x.setFont(new Font("Dialog", Font.BOLD, 14));
		var_btn_mem_x.setBackground(new Color(173, 255, 47));
		var_btn_mem_x.setBounds(319, 333, 60, 30);
		contentPane.add(var_btn_mem_x);
		
		JButton var_btn_mem_y = new JButton("Y");
		var_btn_mem_y.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(var_btn_str.isSelected()) {
					if(problem.length()>0) {
						expr.set(format_problem());
						String tmp_ans= expr.evaluate();
						var_res_display.setText(tmp_ans);
						mem_y= Double.parseDouble(tmp_ans);
					}
					else {
						mem_y= Double.parseDouble(ans);
					}
				}
				else {
					problem= problem+'Y';
				}
				var_btn_str.setSelected(false);
				update_display();
			}
		});
		var_btn_mem_y.setFont(new Font("Dialog", Font.BOLD, 14));
		var_btn_mem_y.setBackground(new Color(173, 255, 47));
		var_btn_mem_y.setBounds(391, 333, 60, 30);
		contentPane.add(var_btn_mem_y);
		
		JButton var_btn_mem_z = new JButton("Z");
		var_btn_mem_z.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(var_btn_str.isSelected()) {
					if(problem.length()>0) {
						expr.set(format_problem());
						String tmp_ans= expr.evaluate();
						var_res_display.setText(tmp_ans);
						mem_z= Double.parseDouble(tmp_ans);
					}
					else {
						mem_z= Double.parseDouble(ans);
					}
				}
				else {
					problem= problem+'Z';
				}
				var_btn_str.setSelected(false);
				update_display();
			}
		});
		var_btn_mem_z.setFont(new Font("Dialog", Font.BOLD, 14));
		var_btn_mem_z.setBackground(new Color(173, 255, 47));
		var_btn_mem_z.setBounds(463, 333, 60, 30);
		contentPane.add(var_btn_mem_z);
		
		
		JButton var_btn_fact = new JButton("n!");
		var_btn_fact.setToolTipText("Die Fakultät");
		var_btn_fact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				problem= problem+ "!";
				update_display();
			}
		});
		var_btn_fact.setFont(new Font("Dialog", Font.BOLD, 12));
		var_btn_fact.setBackground(new Color(255, 222, 173));
		var_btn_fact.setBounds(57, 291, 60, 30);
		contentPane.add(var_btn_fact);
		
		JButton var_btn_inv = new JButton("⅟x");
		var_btn_inv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				problem= problem+ "^-1";
				update_display();
			}
		});
		var_btn_inv.setFont(new Font("Dialog", Font.BOLD, 14));
		var_btn_inv.setBackground(new Color(250, 235, 215));
		var_btn_inv.setBounds(201, 164, 60, 30);
		contentPane.add(var_btn_inv);
		
		JButton var_btn_numconv = new JButton("Num_Conv.");
		var_btn_numconv.setToolTipText("Der Zahlabhängige Konvertor...");
		var_btn_numconv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(num_conv!= null)
						num_conv.dispose();
					num_conv = new Num_Convertor();
					num_conv.setVisible(true);
					num_conv.setResizable(false);
					num_conv.setTitle("*** Der Zahlabhängige Konvertor...  ***");
					num_conv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		var_btn_numconv.setForeground(Color.WHITE);
		var_btn_numconv.setFont(new Font("Dialog", Font.BOLD, 10));
		var_btn_numconv.setBackground(Color.DARK_GRAY);
		var_btn_numconv.setBounds(607, 164, 132, 30);
		contentPane.add(var_btn_numconv);
		
	}
	
	private void update_display() {
		var_display.setText(problem);
	}
	
	private String format_problem() {
		String tmp_problem= new String(problem);
		tmp_problem= tmp_problem.replace("Ant", ans+"");
		tmp_problem= tmp_problem.replace("M", mem+"");
		tmp_problem= tmp_problem.replace("X", mem_x+"");
		tmp_problem= tmp_problem.replace("Y", mem_y+"");
		tmp_problem= tmp_problem.replace("Z", mem_z+"");
		tmp_problem= tmp_problem.replace("π", "PI");
		return tmp_problem;
	}
	
	private String format_problem_graph() {
		String tmp_problem= new String(problem);
		tmp_problem= tmp_problem.replace("Ant", ans+"");
		tmp_problem= tmp_problem.replace("M", mem+"");
		tmp_problem= tmp_problem.replace("Y", mem_y+"");
		tmp_problem= tmp_problem.replace("Z", mem_z+"");
		tmp_problem= tmp_problem.replace("π", "PI");
		
		return tmp_problem;
	}
	
	private void set_history(String p) {
		for(int i=history.length-1; i>0; i--) {
			history[i]= history[i-1];
		}
		history[0]= p;
	}
}





