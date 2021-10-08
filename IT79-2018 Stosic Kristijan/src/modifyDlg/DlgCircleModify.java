package modifyDlg;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class DlgCircleModify extends JDialog {

	private final JPanel pnlCenter = new JPanel();
	private JButton btnModify;
	private JButton cancelButton;
	private JLabel lblCenterOfX;
	private JLabel lblCenterYCoordinate;
	private JLabel lblRadius;
	private JTextField txtXcoordinate;
	private JTextField txtYcoordinate;
	private JTextField txtRadius;

	private Circle circle;
	private Color edgeColor = new Color(0, 0, 0);
	private Color innerColor = new Color(255, 255, 255);
	private JButton btnEdgeColor;
	private JButton btnInnerColor;
	private boolean isOk;

	public static void main(String[] args) {
		try {
			DlgCircleModify dialog = new DlgCircleModify();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DlgCircleModify() {
		setBounds(100, 100, 400, 370);
		setTitle("Modify Circle");
		setModal(true);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		pnlCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlCenter, BorderLayout.CENTER);

		JLabel lblCircleModify = new JLabel("Circle Modify");
		lblCircleModify.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCenterOfX = new JLabel("Center X coordinate:");
		lblCenterOfX.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCenterYCoordinate = new JLabel("Center Y coordinate:");
		lblCenterYCoordinate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRadius = new JLabel("Radius:");
		lblRadius.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtXcoordinate = new JTextField();
		txtXcoordinate.setColumns(10);

		txtYcoordinate = new JTextField();
		txtYcoordinate.setColumns(10);

		txtRadius = new JTextField();
		txtRadius.setColumns(10);

		btnEdgeColor = new JButton("Edge Color");
		btnEdgeColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edgeColor = JColorChooser.showDialog(null, "SELECT CIRCLE COLOR", edgeColor);
				if (edgeColor != null) {
					btnEdgeColor.setBackground(edgeColor);
				}
			}
		});
		btnEdgeColor.setFont(new Font("Tahoma", Font.PLAIN, 15));

		btnInnerColor = new JButton("Inner Color");
		btnInnerColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				innerColor = JColorChooser.showDialog(null, "SELECT CIRCLE COLOR", innerColor);
				if (innerColor != null) {
					btnInnerColor.setBackground(innerColor);
				}
			}
		});
		btnInnerColor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnInnerColor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnEdgeColor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_pnlCenter.createSequentialGroup()
							.addGap(142)
							.addComponent(lblCircleModify))
						.addGroup(Alignment.LEADING, gl_pnlCenter.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCenterOfX)
								.addComponent(lblCenterYCoordinate)
								.addComponent(lblRadius))
							.addGap(106)
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtRadius)
								.addComponent(txtYcoordinate)
								.addComponent(txtXcoordinate, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCircleModify)
					.addGap(18)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCenterOfX)
						.addComponent(txtXcoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCenterYCoordinate)
						.addComponent(txtYcoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRadius)
						.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addComponent(btnEdgeColor)
					.addGap(35)
					.addComponent(btnInnerColor)
					.addGap(32))
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
							validation(txtXcoordinate.getText(), txtYcoordinate.getText(), txtRadius.getText());
							if (txtXcoordinate.getText().trim().equals("") || txtYcoordinate.getText().trim().equals("")
									|| txtRadius.getText().trim().equals("")) {
								JOptionPane.showMessageDialog(null, "Fields are empty!", "ERROR",
										JOptionPane.ERROR_MESSAGE, null);
								isOk = false;
								return;
							} else if (Integer.parseInt(txtRadius.getText()) < 1) {
								JOptionPane.showMessageDialog(null, "Radius can't be less than 1!", "ERROR",
										JOptionPane.ERROR_MESSAGE, null);
								isOk = false;
								return;
							} else {
								int x = Integer.parseInt(txtXcoordinate.getText());
								int y = Integer.parseInt(txtYcoordinate.getText());
								int radius = Integer.parseInt(txtRadius.getText());

								circle.getCenter().setX(x);
								circle.getCenter().setY(y);
								try {
									circle.setRadius(radius);
								} catch (Exception e1) {

									e1.printStackTrace();
								}
								circle.setColor(edgeColor);
								circle.setInnerColor(innerColor);
								isOk = true;
								setVisible(false);
							}
						} catch (NumberFormatException exc) {
							JOptionPane.showMessageDialog(null, "Invalid data inserted!", "ERROR",
									JOptionPane.ERROR_MESSAGE, null);
							return;
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
					public void actionPerformed(ActionEvent arg0) {
						isOk = false;
						dispose();
					}
				});
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
				cancelButton.setActionCommand("Cancel");
			}
			GroupLayout gl_pnlSouth = new GroupLayout(pnlSouth);
			gl_pnlSouth.setHorizontalGroup(
					gl_pnlSouth.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlSouth.createSequentialGroup()
							.addGap(126).addComponent(btnModify).addGap(27).addComponent(cancelButton).addGap(91)));
			gl_pnlSouth.setVerticalGroup(gl_pnlSouth.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnlSouth.createSequentialGroup()
							.addGroup(gl_pnlSouth.createParallelGroup(Alignment.BASELINE).addComponent(cancelButton)
									.addComponent(btnModify))
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
			pnlSouth.setLayout(gl_pnlSouth);
		}
	}

	public void fillAll(Circle circleModify) {
		this.circle = circleModify;
		txtXcoordinate.setText(String.valueOf(circle.getCenter().getX()));
		txtYcoordinate.setText(String.valueOf(circle.getCenter().getY()));
		txtRadius.setText(String.valueOf(circle.getRadius()));
		btnEdgeColor.setBackground(circle.getColor());
		btnInnerColor.setBackground(circle.getInnerColor());
		edgeColor = circle.getColor();
		innerColor = circle.getInnerColor();
	}

	public void validation(String x, String y, String radius) {
		String exp2 = "^(([+-])?([1-9]{1})([0-9]+)?)$";
		if (x.matches("") || y.matches("") || radius.matches("")) {

		} else if (!x.matches(exp2) || !y.matches(exp2) || !radius.matches(exp2)) {
			throw new NumberFormatException();
		}
	}

	public boolean isOk() {
		return isOk;
	}
}
