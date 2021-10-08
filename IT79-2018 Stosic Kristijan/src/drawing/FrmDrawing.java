package drawing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import dialogues.DlgDrawCircle;
import dialogues.DlgDrawDonut;
import dialogues.DlgDrawRectangle;
import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;
import modifyDlg.DlgCircleModify;
import modifyDlg.DlgDonutModify;
import modifyDlg.DlgLineModify;
import modifyDlg.DlgPointModify;
import modifyDlg.DlgRectangleModify;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class FrmDrawing extends JFrame {

	private JPanel contentPane;
	PnlDrawing pnlDrawing = new PnlDrawing();
	private Color edgeColor = new Color(0, 0, 0);
	private Color innerColor = new Color(255, 255, 255);
	private final ButtonGroup btnGroup = new ButtonGroup();
	private int lastSelected = -1;
	private Point startPoint, endPoint;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDrawing frame = new FrmDrawing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmDrawing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1120, 650);
		setTitle("IT79-2018 Stosic Kristijan");
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		pnlDrawing.setBackground(Color.WHITE);

		JPanel panelShapes = new JPanel();
		panelShapes.setBorder(new TitledBorder(
				new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null),
						new BevelBorder(BevelBorder.LOWERED, null, null, null, null)),
				"Shapes", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));

		JPanel panelActions = new JPanel();
		panelActions.setBorder(new TitledBorder(
				new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null),
						new BevelBorder(BevelBorder.LOWERED, null, null, null, null)),
				"Actions", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));

		JPanel panelEdgeColor = new JPanel();
		panelEdgeColor.setBorder(new TitledBorder(
				new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null),
						new BevelBorder(BevelBorder.LOWERED, null, null, null, null)),
				"Edge color", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));

		JPanel panelMode = new JPanel();
		panelMode.setBorder(new TitledBorder(
				new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null),
						new BevelBorder(BevelBorder.LOWERED, null, null, null, null)),
				"Mode", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));

		JLabel lblMouseCursor = new JLabel("Mouse Position: ");
		lblMouseCursor.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMouseCursor.setForeground(Color.WHITE);
		
		JPanel pnlString = new JPanel();

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panelShapes, GroupLayout.PREFERRED_SIZE, 583, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
							.addComponent(panelActions, GroupLayout.PREFERRED_SIZE, 463, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(8)
							.addComponent(pnlDrawing, GroupLayout.PREFERRED_SIZE, 827, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(pnlString, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
								.addComponent(lblMouseCursor)
								.addComponent(panelMode, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
								.addComponent(panelEdgeColor, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(panelActions, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelShapes, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panelEdgeColor, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(panelMode, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(lblMouseCursor)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(pnlString, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
						.addComponent(pnlDrawing, GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE))
					.addGap(20))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_pnlString = new GroupLayout(pnlString);
		gl_pnlString.setHorizontalGroup(
			gl_pnlString.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
		);
		gl_pnlString.setVerticalGroup(
			gl_pnlString.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
		);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		pnlString.setLayout(gl_pnlString);
		GroupLayout gl_pnlDrawing = new GroupLayout(pnlDrawing);
		gl_pnlDrawing.setHorizontalGroup(
				gl_pnlDrawing.createParallelGroup(Alignment.LEADING).addGap(0, 10, Short.MAX_VALUE));
		gl_pnlDrawing
				.setVerticalGroup(gl_pnlDrawing.createParallelGroup(Alignment.LEADING).addGap(0, 10, Short.MAX_VALUE));
		pnlDrawing.setLayout(gl_pnlDrawing);

		JToggleButton tglBtnSelect = new JToggleButton("Select");
		GroupLayout gl_panelMode = new GroupLayout(panelMode);
		gl_panelMode.setHorizontalGroup(gl_panelMode.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMode.createSequentialGroup().addContainerGap()
						.addComponent(tglBtnSelect, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE).addContainerGap()));
		gl_panelMode.setVerticalGroup(gl_panelMode.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMode.createSequentialGroup().addContainerGap()
						.addComponent(tglBtnSelect, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE).addContainerGap()));
		panelMode.setLayout(gl_panelMode);

		JButton btnEdgeColor = new JButton("EdgeColor");
		btnEdgeColor.setIcon(new ImageIcon(FrmDrawing.class.getResource("/images/paint-palette.png")));
		btnEdgeColor.setToolTipText("Edge color");
		btnEdgeColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color temp = JColorChooser.showDialog(null, "BACKGROUND COLOR", edgeColor);
				if (temp != null) {
					edgeColor = temp;
					btnEdgeColor.setBackground(edgeColor);
				}
			}
		});
		btnEdgeColor.setFont(new Font("Tahoma", Font.BOLD, 15));

		JButton btnInnerColor = new JButton("InnerColor");
		btnInnerColor.setIcon(new ImageIcon(FrmDrawing.class.getResource("/images/paint-palette.png")));
		btnInnerColor.setToolTipText("Inner Color");
		btnInnerColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color temp = JColorChooser.showDialog(null, "FILL COLOR", innerColor);
				if (temp != null) {
					innerColor = temp;
					btnInnerColor.setBackground(innerColor);
				}
			}
		});
		btnInnerColor.setFont(new Font("Tahoma", Font.BOLD, 15));
		GroupLayout gl_panelEdgeColor = new GroupLayout(panelEdgeColor);
		gl_panelEdgeColor.setHorizontalGroup(gl_panelEdgeColor.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelEdgeColor.createSequentialGroup().addContainerGap()
						.addGroup(gl_panelEdgeColor.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnInnerColor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 193,
										Short.MAX_VALUE)
								.addComponent(btnEdgeColor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 193,
										Short.MAX_VALUE))
						.addContainerGap()));
		gl_panelEdgeColor.setVerticalGroup(gl_panelEdgeColor.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEdgeColor.createSequentialGroup().addContainerGap()
						.addComponent(btnEdgeColor, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnInnerColor, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelEdgeColor.setLayout(gl_panelEdgeColor);

		JButton btnModify = new JButton("");
		btnModify.setIcon(new ImageIcon(FrmDrawing.class.getResource("/images/pencil.png")));
		btnModify.setToolTipText("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lastSelected == -1) {
					getToolkit().beep();
					JOptionPane.showMessageDialog(null, "Nothing is selected!", "INFO!", JOptionPane.ERROR_MESSAGE,
							null);
					return;
				}
				Shape modifyShape = pnlDrawing.getShapes().get(lastSelected);
				if (modifyShape instanceof Point) {
					DlgPointModify pointModify = new DlgPointModify();
					pointModify.fillAll((Point) modifyShape);
					pointModify.setVisible(true);
				} else if (modifyShape instanceof Line) {
					DlgLineModify lineModify = new DlgLineModify();
					lineModify.fillAll((Line) modifyShape);
					lineModify.setVisible(true);
				} else if (modifyShape instanceof Rectangle) {
					DlgRectangleModify rectangleModify = new DlgRectangleModify();
					rectangleModify.fillAll((Rectangle) modifyShape);
					rectangleModify.setVisible(true);
				} else if (modifyShape instanceof Donut) {
					DlgDonutModify donutModify = new DlgDonutModify();
					donutModify.fillAll((Donut) modifyShape);
					donutModify.setVisible(true);
				} else if (modifyShape instanceof Circle) {
					DlgCircleModify circleModify = new DlgCircleModify();
					circleModify.fillAll((Circle) modifyShape);
					circleModify.setVisible(true);
				}
				pnlDrawing.repaint();
			}
		});
		btnModify.setFont(new Font("Tahoma", Font.BOLD, 15));

		JButton btnDelete = new JButton("");
		btnDelete.setIcon(new ImageIcon(FrmDrawing.class.getResource("/images/delete.png")));
		btnDelete.setToolTipText("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lastSelected == -1) {
					getToolkit().beep();
					JOptionPane.showMessageDialog(null, "Nothing is selected!", "INFO!", JOptionPane.ERROR_MESSAGE,
							null);
					return;
				}
				int question = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this shape?",
						"CONFIRM", JOptionPane.YES_NO_OPTION);
				if (question == 0 && pnlDrawing.getShapes().size() > lastSelected) {
					pnlDrawing.getShapes().remove(lastSelected);
					pnlDrawing.repaint();
					lastSelected = -1;
				}
			}
		});

		JButton btnDeleteAll = new JButton("");
		btnDeleteAll.setIcon(new ImageIcon(FrmDrawing.class.getResource("/images/deleteAll.png")));
		btnDeleteAll.setToolTipText("Delete all");
		btnDeleteAll.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDeleteAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (pnlDrawing.getShapes().isEmpty()) {
					getToolkit().beep();
					JOptionPane.showMessageDialog(null, "There is nothing on the PANEL!", "INFO!",
							JOptionPane.ERROR_MESSAGE, null);
					return;
				} else {
					pnlDrawing.getShapes().clear();
					pnlDrawing.repaint();
				}

			}
		});
		GroupLayout gl_panelActions = new GroupLayout(panelActions);
		gl_panelActions.setHorizontalGroup(gl_panelActions.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelActions.createSequentialGroup().addContainerGap()
						.addComponent(btnModify, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnDeleteAll, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
						.addGap(18)));
		gl_panelActions.setVerticalGroup(gl_panelActions.createParallelGroup(Alignment.LEADING)
				.addComponent(btnModify, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
				.addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
				.addComponent(btnDeleteAll, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE));
		panelActions.setLayout(gl_panelActions);

		JToggleButton tglbtnPoint = new JToggleButton("");
		tglbtnPoint.setIcon(new ImageIcon(FrmDrawing.class.getResource("/images/cross-shaped-target.png")));
		tglbtnPoint.setToolTipText("Point");
		tglbtnPoint.setFont(new Font("Tahoma", Font.BOLD, 15));

		JToggleButton tglbtnRectangle = new JToggleButton("");
		tglbtnRectangle.setIcon(
				new ImageIcon(FrmDrawing.class.getResource("/images/rectangular-geometrical-shape-outline.png")));
		tglbtnRectangle.setToolTipText("Rectangle");
		tglbtnRectangle.setFont(new Font("Tahoma", Font.BOLD, 15));

		JToggleButton tglbtnCircle = new JToggleButton("");
		tglbtnCircle.setIcon(new ImageIcon(FrmDrawing.class.getResource("/images/dry-clean.png")));
		tglbtnCircle.setToolTipText("Circle");
		tglbtnCircle.setFont(new Font("Tahoma", Font.BOLD, 15));

		JToggleButton tglbtnDonut = new JToggleButton("");
		tglbtnDonut.setIcon(new ImageIcon(FrmDrawing.class.getResource("/images/rec (3).png")));
		tglbtnDonut.setToolTipText("Donut");
		tglbtnDonut.setFont(new Font("Tahoma", Font.BOLD, 15));

		JToggleButton tglbtnLine = new JToggleButton("");
		tglbtnLine.setIcon(new ImageIcon(FrmDrawing.class.getResource("/images/diagonal-line.png")));
		tglbtnLine.setToolTipText("Line");
		tglbtnLine.setFont(new Font("Tahoma", Font.BOLD, 15));
		GroupLayout gl_panelShapes = new GroupLayout(panelShapes);
		gl_panelShapes.setHorizontalGroup(gl_panelShapes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelShapes.createSequentialGroup().addContainerGap()
						.addComponent(tglbtnPoint, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(tglbtnLine, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(tglbtnRectangle, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(tglbtnCircle, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(tglbtnDonut, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_panelShapes.setVerticalGroup(gl_panelShapes.createParallelGroup(Alignment.LEADING).addGroup(gl_panelShapes
				.createSequentialGroup()
				.addGroup(gl_panelShapes.createParallelGroup(Alignment.LEADING)
						.addComponent(tglbtnDonut, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
						.addGroup(gl_panelShapes.createParallelGroup(Alignment.BASELINE)
								.addComponent(tglbtnPoint, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
								.addComponent(tglbtnLine, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
								.addComponent(tglbtnRectangle, GroupLayout.PREFERRED_SIZE, 47,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(tglbtnCircle, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)))
				.addGap(268)));
		panelShapes.setLayout(gl_panelShapes);
		contentPane.setLayout(gl_contentPane);

		btnGroup.add(tglbtnPoint);
		btnGroup.add(tglbtnRectangle);
		btnGroup.add(tglbtnCircle);
		btnGroup.add(tglbtnLine);
		btnGroup.add(tglbtnDonut);
		btnGroup.add(tglbtnLine);
		btnGroup.add(tglBtnSelect);

		pnlDrawing.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				lblMouseCursor
						.setText("Mouse position: " + Integer.toString(e.getX()) + ", " + Integer.toString(e.getY()));
			}
		});

		pnlDrawing.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				Point center = new Point(e.getX(), e.getY());
				for (int i = 0; i < pnlDrawing.getShapes().size(); i++) {
					lastSelected = -1;
					pnlDrawing.getShapes().get(i).setSelected(false);
					pnlDrawing.repaint();
				}
				if (tglBtnSelect.isSelected()) {
					for (int i = 0; i < pnlDrawing.getShapes().size(); i++) {
						if (pnlDrawing.getShapes().get(i).contains(e.getX(), e.getY())) {
							lastSelected = i;
						}
						if (lastSelected != -1) {
							pnlDrawing.getShapes().get(lastSelected).setSelected(true);
						}
					}
				} else {
					if (tglbtnPoint.isSelected()) {
						Point p = new Point(e.getX(), e.getY());
						p.setColor(edgeColor);
						pnlDrawing.getShapes().add(p);
						textArea.append(p.toString() + "\n");
					} else if (tglbtnLine.isSelected()) {
						if (startPoint == null) {
							startPoint = new Point(e.getX(), e.getY());
							return;
						}
						endPoint = new Point(e.getX(), e.getY());
						Line l = new Line(startPoint, endPoint, false);
						l.setColor(edgeColor);
						pnlDrawing.getShapes().add(l);
						textArea.append(l.toString() + "\n");
						startPoint = null;
					} else if (tglbtnRectangle.isSelected()) {
						DlgDrawRectangle drawRectangle = new DlgDrawRectangle();
						drawRectangle.setVisible(true);

						if (drawRectangle.isOk()) {
							Rectangle r = new Rectangle(center,
									Integer.parseInt(drawRectangle.getTxtHeightRectangle().getText()),
									Integer.parseInt(drawRectangle.getTxtWidthRectangle().getText()));
							r.setColor(edgeColor);
							r.setInnerColor(innerColor);
							pnlDrawing.getShapes().add(r);
							textArea.append(r.toString() + "\n");
						}
					} else if (tglbtnCircle.isSelected()) {
						DlgDrawCircle drawCircle = new DlgDrawCircle();
						drawCircle.setVisible(true);

						if (drawCircle.isOk()) {
							Circle c = new Circle(center, Integer.parseInt(drawCircle.getTxtRadius().getText()));
							c.setColor(edgeColor);
							c.setInnerColor(innerColor);
							pnlDrawing.getShapes().add(c);
							textArea.append(c.toString() + "\n");
						}
					} else if (tglbtnDonut.isSelected()) {
						DlgDrawDonut drawDonut = new DlgDrawDonut();
						drawDonut.setVisible(true);

						if (drawDonut.isOk()) {
							Donut d = new Donut(center, Integer.parseInt(drawDonut.getTxtDonutRadius().getText()),
									Integer.parseInt(drawDonut.getTxtDonutInnerRadius().getText()));
							d.setColor(edgeColor);
							d.setInnerColor(innerColor);
							pnlDrawing.getShapes().add(d);
							textArea.append(d.toString() + "\n");
						}
					}
				}
				pnlDrawing.repaint();
			}
		});
	}
}
