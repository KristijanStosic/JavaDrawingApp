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
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

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
	private JButton btnEdgeColor;
	private JButton btnInnerColor;
	private JTextField txtCenterX;
	private JTextField txtCenterY;
	private JTextField txtOuterRadius;
	private JTextField txtInnerRadius;
	private Donut donut;
	private Color edgeColor = new Color(0, 0, 0);
	private Color innerColor = new Color(255, 255, 255);
	private boolean isOk;

	public static void main(String[] args) {
		try {
			DlgDonutModify dialog = new DlgDonutModify();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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

		btnEdgeColor = new JButton("Edge Color");
		btnEdgeColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edgeColor = JColorChooser.showDialog(null, "Choose DONUT color", edgeColor);
				if (edgeColor != null) {
					btnEdgeColor.setBackground(edgeColor);
				}
			}
		});
		btnEdgeColor.setFont(new Font("Tahoma", Font.PLAIN, 15));

		btnInnerColor = new JButton("Inner Color");
		btnInnerColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				innerColor = JColorChooser.showDialog(null, "Choose DONUT color", innerColor);
				if (innerColor != null) {
					btnInnerColor.setBackground(innerColor);
				}
			}
		});
		btnInnerColor.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtCenterX = new JTextField();
		txtCenterX.setColumns(10);

		txtCenterY = new JTextField();
		txtCenterY.setColumns(10);

		txtOuterRadius = new JTextField();
		txtOuterRadius.setColumns(10);

		txtInnerRadius = new JTextField();
		txtInnerRadius.setColumns(10);
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup().addGap(154).addComponent(lblModifyDonut))
				.addGroup(gl_pnlCenter.createSequentialGroup().addGap(20).addComponent(lblCenterXCoordinate).addGap(117)
						.addComponent(txtCenterX, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlCenter.createSequentialGroup().addGap(20).addComponent(lblCenterYCoordinate).addGap(116)
						.addComponent(txtCenterY, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlCenter.createSequentialGroup().addGap(20).addComponent(lblOuterRadius).addGap(166)
						.addComponent(txtOuterRadius, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlCenter
						.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING,
								gl_pnlCenter.createSequentialGroup().addContainerGap().addComponent(btnInnerColor,
										GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING,
								gl_pnlCenter.createSequentialGroup().addContainerGap().addComponent(btnEdgeColor,
										GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING,
								gl_pnlCenter.createSequentialGroup().addGap(20).addComponent(lblInnerRadius).addGap(168)
										.addComponent(txtInnerRadius, GroupLayout.PREFERRED_SIZE, 130,
												GroupLayout.PREFERRED_SIZE))));
		gl_pnlCenter.setVerticalGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlCenter
				.createSequentialGroup().addGap(11).addComponent(lblModifyDonut).addGap(18)
				.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING).addComponent(lblCenterXCoordinate)
						.addGroup(gl_pnlCenter.createSequentialGroup().addGap(1).addComponent(txtCenterX,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addGap(18)
				.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING).addComponent(lblCenterYCoordinate)
						.addGroup(gl_pnlCenter.createSequentialGroup().addGap(1).addComponent(txtCenterY,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addGap(18)
				.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING).addComponent(lblOuterRadius)
						.addGroup(gl_pnlCenter.createSequentialGroup().addGap(1).addComponent(txtOuterRadius,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addGap(11)
				.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlCenter.createSequentialGroup().addGap(7).addComponent(lblInnerRadius))
						.addComponent(txtInnerRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18).addComponent(btnEdgeColor).addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(btnInnerColor).addContainerGap()));
		pnlCenter.setLayout(gl_pnlCenter);
		{
			JPanel pnlSouth = new JPanel();
			getContentPane().add(pnlSouth, BorderLayout.SOUTH);
			{
				btnModify = new JButton("Modify");
				btnModify.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							validation(txtCenterX.getText(), txtCenterY.getText(), txtOuterRadius.getText(),
									txtInnerRadius.getText());
							if (txtCenterX.getText().trim().equals("") || txtCenterY.getText().trim().equals("")
									|| txtOuterRadius.getText().trim().equals("")
									|| txtInnerRadius.getText().trim().equals("")) {
								JOptionPane.showMessageDialog(null, "Fill in all the fields!", "ERROR",
										JOptionPane.ERROR_MESSAGE, null);
								isOk = false;
								return;
							} else if (Integer.parseInt(txtOuterRadius.getText()) < 0
									|| Integer.parseInt(txtInnerRadius.getText()) < 0) {
								JOptionPane.showMessageDialog(null, "Radius(outer,inner) can't be less than 1!",
										"ERROR", JOptionPane.ERROR_MESSAGE, null);
								isOk = false;
								return;
							} else {

								int x = Integer.parseInt(txtCenterX.getText());
								int y = Integer.parseInt(txtCenterY.getText());
								int outerRadius = Integer.parseInt(txtOuterRadius.getText());
								int innerRadius = Integer.parseInt(txtInnerRadius.getText());

								donut.setCenter(new Point(x, y));

								try {
									donut.setRadius(outerRadius);
								} catch (Exception e1) {
									e1.printStackTrace();
								}

								donut.setInnerRadius(innerRadius);
								donut.setColor(edgeColor);
								donut.setInnerColor(innerColor);
								isOk = true;
								setVisible(false);
							}
						} catch (NumberFormatException exc) {
							JOptionPane.showMessageDialog(null, "Invalid data type inserted!", "ERROR",
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
					public void actionPerformed(ActionEvent e) {
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
							.addGap(146).addComponent(btnModify).addGap(18).addComponent(cancelButton).addGap(158)));
			gl_pnlSouth.setVerticalGroup(gl_pnlSouth.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnlSouth.createSequentialGroup()
							.addGroup(gl_pnlSouth.createParallelGroup(Alignment.BASELINE).addComponent(btnModify)
									.addComponent(cancelButton))
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
			pnlSouth.setLayout(gl_pnlSouth);
		}
	}

	public void fillAll(Donut donutModify) {
		this.donut = donutModify;
		txtCenterX.setText(String.valueOf(donut.getCenter().getX()));
		txtCenterY.setText(String.valueOf(donut.getCenter().getY()));
		txtOuterRadius.setText(String.valueOf(donut.getRadius()));
		txtInnerRadius.setText(String.valueOf(donut.getInnerRadius()));
		btnEdgeColor.setBackground(donut.getColor());
		btnInnerColor.setBackground(donut.getInnerColor());
		edgeColor = donut.getColor();
		innerColor = donut.getInnerColor();
	}

	public void validation(String x, String y, String radius, String innerRadius) {

		String supp2 = "^(([+-])?([1-9]{1})([0-9]+)?)$";
		if (x.matches("") || y.matches("") || radius.matches("") || innerRadius.matches("")) {

		} else if (!x.matches(supp2) || !y.matches(supp2) || !radius.matches(supp2) || !innerRadius.matches(supp2)) {
			throw new NumberFormatException();
		}
	}

	public boolean isOk() {
		return isOk;
	}
}
