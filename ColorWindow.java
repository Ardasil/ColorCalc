package colorConvert;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorWindow extends JDialog {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JLabel RGBVal;
	private JLabel HEXConVal;
	private JLabel CMYKVal;
	private JPanel ClrDisp;
	private Color color = (Color.BLACK);
	private int RValue, GValue, BValue;
	private JSlider Red, Green, Blue;
	private JLabel RNum, GNum, BNum;
	private int R1,G1,B1;
	private float C,M,Y,K;

	public ColorWindow() {
		setTitle("Color Conversion");
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 340, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(UIManager.getColor("Button.background"));
		panel.setBounds(0, 0, 444, 271);
		contentPane.add(panel);
		panel.setLayout(null);

		ClrDisp = new JPanel();
		ClrDisp.setBorder(new LineBorder(new Color(105, 105, 105), 1, true));
		ClrDisp.setToolTipText("Picked Color Preview");
		ClrDisp.setBounds(49, 199, 145, 38);
		ClrDisp.setBackground(Color.BLACK);
		panel.add(ClrDisp);

		Red = new JSlider();
		Red.setValue(0);
		Red.setMajorTickSpacing(50);
		Red.setMaximum(255);
		Red.setBounds(39, 11, 200, 26);
		panel.add(Red);

		Green = new JSlider();
		Green.setValue(0);
		Green.setMajorTickSpacing(50);
		Green.setMaximum(255);
		Green.setBounds(39, 47, 200, 26);
		panel.add(Green);

		Blue = new JSlider();
		Blue.setValue(0);
		Blue.setMajorTickSpacing(50);
		Blue.setMaximum(255);
		Blue.setBounds(39, 83, 200, 26);
		panel.add(Blue);

		JLabel lblR = new JLabel("R");
		lblR.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblR.setHorizontalAlignment(SwingConstants.CENTER);
		lblR.setBounds(10, 11, 19, 26);
		panel.add(lblR);

		JLabel lblG = new JLabel("G");
		lblG.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblG.setHorizontalAlignment(SwingConstants.CENTER);
		lblG.setBounds(10, 47, 19, 26);
		panel.add(lblG);

		JLabel lblB = new JLabel("B");
		lblB.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblB.setHorizontalAlignment(SwingConstants.CENTER);
		lblB.setBounds(10, 83, 19, 26);
		panel.add(lblB);

		RGBVal = new JLabel();
		RGBVal.setText("RGB Color: 0,0,0");
		RGBVal.setToolTipText("RGB Values");
		RGBVal.setBounds(49, 120, 145, 20);
		panel.add(RGBVal);

		HEXConVal = new JLabel();
		HEXConVal.setText("HEX Color: #000000");
		HEXConVal.setToolTipText("HEX Converted Values");
		HEXConVal.setBounds(49, 170, 145, 20);
		panel.add(HEXConVal);

		RNum = new JLabel();
		RNum.setHorizontalAlignment(SwingConstants.CENTER);
		RNum.setText("0");
		RNum.setToolTipText("Red Color Value");
		RNum.setBounds(249, 11, 29, 20);
		panel.add(RNum);

		GNum = new JLabel();
		GNum.setHorizontalAlignment(SwingConstants.CENTER);
		GNum.setText("0");
		GNum.setToolTipText("Green Color Value");
		GNum.setBounds(249, 47, 29, 20);
		panel.add(GNum);

		BNum = new JLabel();
		BNum.setHorizontalAlignment(SwingConstants.CENTER);
		BNum.setText("0");
		BNum.setToolTipText("Blue Color Value");
		BNum.setBounds(249, 83, 29, 20);
		panel.add(BNum);
		
		CMYKVal = new JLabel();
		CMYKVal.setToolTipText("CMYK Values");
		CMYKVal.setText("CMYK Color: 0%,0%,0%,0%");
		CMYKVal.setBounds(49, 145, 229, 20);
		panel.add(CMYKVal);

		event e = new event();
		Red.addChangeListener(e);
		Green.addChangeListener(e);
		Blue.addChangeListener(e);

	}

	public class event implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			RValue = Red.getValue();
			GValue = Green.getValue();
			BValue = Blue.getValue();

			String red = Integer.toString(RValue);
			String green = Integer.toString(GValue);
			String blue = Integer.toString(BValue);

			RNum.setText(red);
			GNum.setText(green);
			BNum.setText(blue);

			color = new Color(RValue, GValue, BValue);
			ClrDisp.setBackground(color);
			RGBVal.setText("RGB Color: " + RValue + "," + GValue + "," + BValue);
			
			
			/// XDDDDDDDDDDDDDDDDDD
			
			  R1 = RValue/255;
			  G1 = GValue/255;
			  B1 = BValue/255; K =
			  1-Math.max(Math.max(R1, G1),B1);
			  C = (1-R1-K)/(1-K);
			  M = (1-G1-K)/(1-K);
			  Y = (1-B1-K)/(1-K);
			  
			  
			  CMYKVal.setText("CMYK Color: " + C + "%," + M + "%," + Y + "%," + K + "%");
			 

			
			int hexRed = RValue;
			int hexGreen = GValue;
			int hexBlue = BValue;

			String frmt1, frmt2, frmt3;

			frmt1 = String.format("%02X", hexRed);
			frmt2 = String.format("%02X", hexGreen);
			frmt3 = String.format("%02X", hexBlue);

			HEXConVal.setText("HEX Color: #" + frmt1 + "" + frmt2 + "" + frmt3);

		}
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
