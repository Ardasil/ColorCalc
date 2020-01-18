package colorConvert;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import colorConvert.ColorWindow;

public class Main extends JFrame {

	private JPanel contentPane;
	private ColorWindow cWindow;


	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTtip = new JLabel("Aplikacja przeliczaj\u0105ca warto\u015Bci kolor\u00F3w RGB na HEX oraz CMYK");
		lblTtip.setHorizontalAlignment(SwingConstants.CENTER);
		lblTtip.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTtip.setBounds(10, 11, 414, 80);
		contentPane.add(lblTtip);
		
		JButton btnClick = new JButton("Kalkulator");
		btnClick.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					if (cWindow == null)
						cWindow = new ColorWindow();
					cWindow.setVisible(true);
				}
			}
		);
		btnClick.setBounds(150, 130, 89, 23);
		contentPane.add(btnClick);
		
		


		
		
}
	  
	 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
}
