package modifyDlg;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Donut;
import geometry.Point;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class DlgDonutModify extends JDialog {

	private final JPanel pnlCenter = new JPanel();
	private JButton btnModify;
	private JButton cancelButton;
	private JLabel lblModifyDonut;
	private JLabel lblCenterXCoordinate;
	private JLabel lblCenterYCoordinate;
	private JLabel lblOuterRadius;
	private JLabel lblInnerRadius;
	private JButton btnChooseEdgeColor;
	private JButton btnChooseInnerColor;
	private JTextField txtCenterX;
	private JTextField txtCenterY;
	private JTextField txtOuterRadius;
	private JTextField txtInnerRadius;
	private JTextField txtEdgeColor;
	private JTextField txtInnerColor;
	private Donut donut;
	private Color edgeColorDonut;
	private Color innerColorDonut;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDonutModify dialog = new DlgDonutModify();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDonutModify() {
		setBounds(100, 100, 450, 350);
		setTitle("Modify donut");
		setModal(true);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		pnlCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlCenter, BorderLayout.CENTER);
		lblModifyDonut = new JLabel("Donut Modify ");
		lblModifyDonut.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCenterXCoordinate = new JLabel("Center X coordinate:");
		lblCenterXCoordinate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCenterYCoordinate = new JLabel("Center Y coordinate:");
		lblCenterYCoordinate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOuterRadius = new JLabel("Outer radius:");
		lblOuterRadius.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInnerRadius = new JLabel("Inner radius:");
		lblInnerRadius.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnChooseEdgeColor = new JButton("Choose edge color:");
		btnChooseEdgeColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edgeColorDonut=JColorChooser.showDialog(null, "Choose DONUT color", edgeColorDonut);
				if(edgeColorDonut==null){
					edgeColorDonut = donut.getColor();
				}
				txtEdgeColor.setBackground(edgeColorDonut);
			}
		});
		btnChooseEdgeColor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnChooseInnerColor = new JButton("Choose inner color:");
		btnChooseInnerColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				innerColorDonut=JColorChooser.showDialog(null, "Choose DONUT color", innerColorDonut);
				if(innerColorDonut==null){
					innerColorDonut=donut.getInnerColor();
				}
				txtInnerColor.setBackground(innerColorDonut);
			}
		});
		btnChooseInnerColor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtCenterX = new JTextField();
		txtCenterX.setColumns(10);
		
		txtCenterY = new JTextField();
		txtCenterY.setColumns(10);
		
		txtOuterRadius = new JTextField();
		txtOuterRadius.setColumns(10);
		
		txtInnerRadius = new JTextField();
		txtInnerRadius.setColumns(10);
		
		txtEdgeColor = new JTextField();
		txtEdgeColor.setEditable(false);
		txtEdgeColor.setColumns(10);
		
		txtInnerColor = new JTextField();
		txtInnerColor.setEditable(false);
		txtInnerColor.setColumns(10);
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGap(154)
					.addComponent(lblModifyDonut))
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGap(20)
					.addComponent(lblCenterXCoordinate)
					.addGap(117)
					.addComponent(txtCenterX, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGap(20)
					.addComponent(lblCenterYCoordinate)
					.addGap(116)
					.addComponent(txtCenterY, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGap(20)
					.addComponent(lblOuterRadius)
					.addGap(166)
					.addComponent(txtOuterRadius, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGap(20)
					.addComponent(lblInnerRadius)
					.addGap(168)
					.addComponent(txtInnerRadius, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGap(10)
					.addComponent(btnChooseEdgeColor)
					.addGap(104)
					.addComponent(txtEdgeColor, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGap(10)
					.addComponent(btnChooseInnerColor)
					.addGap(104)
					.addComponent(txtInnerColor, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGap(11)
					.addComponent(lblModifyDonut)
					.addGap(18)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCenterXCoordinate)
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addGap(1)
							.addComponent(txtCenterX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCenterYCoordinate)
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addGap(1)
							.addComponent(txtCenterY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
						.addComponent(lblOuterRadius)
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addGap(1)
							.addComponent(txtOuterRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(11)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addGap(7)
							.addComponent(lblInnerRadius))
						.addComponent(txtInnerRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
						.addComponent(btnChooseEdgeColor)
						.addComponent(txtEdgeColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
						.addComponent(btnChooseInnerColor)
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addGap(3)
							.addComponent(txtInnerColor, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))))
		);
		pnlCenter.setLayout(gl_pnlCenter);
		{
			JPanel pnlSouth = new JPanel();
			getContentPane().add(pnlSouth, BorderLayout.SOUTH);
			{
				btnModify = new JButton("Modify");
				btnModify.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							validation(txtCenterX.getText(), txtCenterY.getText(), txtOuterRadius.getText(), txtInnerRadius.getText());
						} catch (NumberFormatException exc) {
							JOptionPane.showMessageDialog(null, "Invalid data type inserted!", "ERROR", JOptionPane.ERROR_MESSAGE, null);
							return;
						}
						if(txtCenterX.getText().trim().equals("") || txtCenterY.getText().trim().equals("") ||
								txtOuterRadius.getText().trim().equals("") || txtInnerRadius.getText().trim().equals("")){
							JOptionPane.showMessageDialog(null, "Fill in all the fields!", "ERROR", JOptionPane.ERROR_MESSAGE, null);
							return;
						}else if(Integer.parseInt(txtOuterRadius.getText()) < 0 || Integer.parseInt(txtInnerRadius.getText())< 0){
							JOptionPane.showMessageDialog(null, "Radius(outer,inner) can't be less than 1!", "ERROR", JOptionPane.ERROR_MESSAGE, null);
							return;
						}else{
							
							int x = Integer.parseInt(txtCenterX.getText());
							int y = Integer.parseInt(txtCenterY.getText());
							int outerRadius = Integer.parseInt(txtOuterRadius.getText());
							int innerRadius = Integer.parseInt(txtInnerRadius.getText());
							
							donut.setCenter(new Point(x,y));
							
							
									try {
										donut.setRadius(outerRadius);
									} catch (Exception e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
							
							
								
							
							donut.setInnerRadius(innerRadius);
							donut.setColor(edgeColorDonut);
							donut.setInnerColor(innerColorDonut);
							dispose();
						}
					}
				});
				btnModify.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnModify.setActionCommand("OK");
				getRootPane().setDefaultButton(btnModify);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
				cancelButton.setActionCommand("Cancel");
			}
			GroupLayout gl_pnlSouth = new GroupLayout(pnlSouth);
			gl_pnlSouth.setHorizontalGroup(
				gl_pnlSouth.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnlSouth.createSequentialGroup()
						.addGap(146)
						.addComponent(btnModify)
						.addGap(18)
						.addComponent(cancelButton)
						.addGap(158))
			);
			gl_pnlSouth.setVerticalGroup(
				gl_pnlSouth.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnlSouth.createSequentialGroup()
						.addGroup(gl_pnlSouth.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnModify)
							.addComponent(cancelButton))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			pnlSouth.setLayout(gl_pnlSouth);
		}
	}
	public void fillAll(Donut donutModify) {
		this.donut = donutModify;
		txtCenterX.setText(String.valueOf(donut.getCenter().getX()));
		txtCenterY.setText(String.valueOf(donut.getCenter().getY()));
		txtOuterRadius.setText(String.valueOf(donut.getRadius()));
		txtInnerRadius.setText(String.valueOf(donut.getInnerRadius()));
		txtEdgeColor.setBackground(donut.getColor());
		txtInnerColor.setBackground(donut.getInnerColor());
		edgeColorDonut = donut.getColor();
		innerColorDonut = donut.getInnerColor();
	}
	public void validation(String x, String y, String radius, String innerRadius) {
		
		String supp2 = "^(([+-])?([1-9]{1})([0-9]+)?)$";
		if(x.matches("") || y.matches("") || radius.matches("") || innerRadius.matches("")) {
			
		}
		else if(!x.matches(supp2) || !y.matches(supp2) || !radius.matches(supp2) || !innerRadius.matches(supp2)){
        	throw new NumberFormatException();
        }
	}
}
