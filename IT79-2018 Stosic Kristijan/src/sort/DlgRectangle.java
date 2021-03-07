package sort;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;
import geometry.Rectangle;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class DlgRectangle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCoordinateX;
	private JTextField txtCoordinateY;
	private JTextField txtWidth;
	private JTextField txtHeight;
	private JButton btnConfirm;
	private JButton btnCancel;
	private Rectangle rec;
	public  boolean isOk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRectangle dialog = new DlgRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRectangle() {
		setBounds(100, 100, 450, 350);
		setModal(true);
		setTitle("Add a Rectangle!");
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblXCoordinate = new JLabel("X coordinate:");
			lblXCoordinate.setFont(new Font("Rockwell", Font.PLAIN, 15));
			GridBagConstraints gbc_lblXCoordinate = new GridBagConstraints();
			gbc_lblXCoordinate.insets = new Insets(0, 0, 5, 5);
			gbc_lblXCoordinate.gridx = 1;
			gbc_lblXCoordinate.gridy = 1;
			contentPanel.add(lblXCoordinate, gbc_lblXCoordinate);
		}
		{
			txtCoordinateX = new JTextField();
			GridBagConstraints gbc_txtCoordinateX = new GridBagConstraints();
			gbc_txtCoordinateX.insets = new Insets(0, 0, 5, 0);
			gbc_txtCoordinateX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtCoordinateX.gridx = 6;
			gbc_txtCoordinateX.gridy = 1;
			contentPanel.add(txtCoordinateX, gbc_txtCoordinateX);
			txtCoordinateX.setColumns(10);
		}
		{
			JLabel lblYCoordinate = new JLabel("Y coordinate:");
			lblYCoordinate.setFont(new Font("Rockwell", Font.PLAIN, 15));
			GridBagConstraints gbc_lblYCoordinate = new GridBagConstraints();
			gbc_lblYCoordinate.insets = new Insets(0, 0, 5, 5);
			gbc_lblYCoordinate.gridx = 1;
			gbc_lblYCoordinate.gridy = 3;
			contentPanel.add(lblYCoordinate, gbc_lblYCoordinate);
		}
		{
			txtCoordinateY = new JTextField();
			GridBagConstraints gbc_txtCoordinateY = new GridBagConstraints();
			gbc_txtCoordinateY.insets = new Insets(0, 0, 5, 0);
			gbc_txtCoordinateY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtCoordinateY.gridx = 6;
			gbc_txtCoordinateY.gridy = 3;
			contentPanel.add(txtCoordinateY, gbc_txtCoordinateY);
			txtCoordinateY.setColumns(10);
		}
		{
			JLabel lblWidth = new JLabel("Width:");
			lblWidth.setFont(new Font("Rockwell", Font.PLAIN, 15));
			GridBagConstraints gbc_lblWidth = new GridBagConstraints();
			gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
			gbc_lblWidth.gridx = 1;
			gbc_lblWidth.gridy = 5;
			contentPanel.add(lblWidth, gbc_lblWidth);
		}
		{
			txtWidth = new JTextField();
			GridBagConstraints gbc_txtWidth = new GridBagConstraints();
			gbc_txtWidth.insets = new Insets(0, 0, 5, 0);
			gbc_txtWidth.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtWidth.gridx = 6;
			gbc_txtWidth.gridy = 5;
			contentPanel.add(txtWidth, gbc_txtWidth);
			txtWidth.setColumns(10);
		}
		{
			JLabel lblHeight = new JLabel("Height:");
			lblHeight.setFont(new Font("Rockwell", Font.PLAIN, 15));
			GridBagConstraints gbc_lblHeight = new GridBagConstraints();
			gbc_lblHeight.insets = new Insets(0, 0, 0, 5);
			gbc_lblHeight.gridx = 1;
			gbc_lblHeight.gridy = 7;
			contentPanel.add(lblHeight, gbc_lblHeight);
		}
		{
			txtHeight = new JTextField();
			GridBagConstraints gbc_txtHeight = new GridBagConstraints();
			gbc_txtHeight.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtHeight.gridx = 6;
			gbc_txtHeight.gridy = 7;
			contentPanel.add(txtHeight, gbc_txtHeight);
			txtHeight.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnConfirm = new JButton("Confirm");
				btnConfirm.setFont(new Font("Rockwell", Font.PLAIN, 20));
				btnConfirm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
								isOk = true;
								dispose();
					}
				});
				btnConfirm.setActionCommand("OK");
				getRootPane().setDefaultButton(btnConfirm);
			}
			{
				btnCancel = new JButton("Cancel");
				btnCancel.setFont(new Font("Rockwell", Font.PLAIN, 20));
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancel.setActionCommand("Cancel");
			}
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addGap(71)
						.addComponent(btnConfirm)
						.addGap(55)
						.addComponent(btnCancel)
						.addGap(104))
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_buttonPane.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnConfirm)
							.addComponent(btnCancel))
						.addContainerGap())
			);
			buttonPane.setLayout(gl_buttonPane);
		}
	}

	

	

	public Rectangle getRec() {
		return rec;
	}

	public void setRec(Rectangle rec) {
		this.rec = rec;
	}

	

	public JTextField getTxtCoordinateX() {
		return txtCoordinateX;
	}

	public void setTxtCoordinateX(JTextField txtCoordinateX) {
		this.txtCoordinateX = txtCoordinateX;
	}

	public JTextField getTxtCoordinateY() {
		return txtCoordinateY;
	}

	public void setTxtCoordinateY(JTextField txtCoordinateY) {
		this.txtCoordinateY = txtCoordinateY;
	}

	public JTextField getTxtWidth() {
		return txtWidth;
	}

	public void setTxtWidth(JTextField txtWidth) {
		this.txtWidth = txtWidth;
	}

	public JTextField getTxtHeight() {
		return txtHeight;
	}

	public void setTxtHeight(JTextField txtHeight) {
		this.txtHeight = txtHeight;
	}

}
