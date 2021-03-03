package sort;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;
import geometry.Rectangle;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

public class FrmSort extends JFrame {

	private JPanel contentPane;
	private  DefaultListModel<Rectangle> dlm = new DefaultListModel<Rectangle>();
	private ArrayList<Rectangle> listRectangles=new ArrayList<Rectangle>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSort frame = new FrmSort();
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
	public FrmSort() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("IT79-2018 Stosic Kristijan");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlNorth = new JPanel();
		contentPane.add(pnlNorth, BorderLayout.NORTH);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				DlgRectangle add = new DlgRectangle();
				add.isOk = false;
				add.setVisible(true);
				if(add.isOk){
					try {
						String[] option = { "OK" };
						int x = Integer.parseInt(add.getTxtCoordinateX().getText());
						int y = Integer.parseInt(add.getTxtCoordinateY().getText());
						int width = Integer.parseInt(add.getTxtWidth().getText());
						int height = Integer.parseInt(add.getTxtHeight().getText());
						if(x<1 || y<1 || width<1 || height <1){
							getToolkit().beep();
							JOptionPane.showOptionDialog(null, "Insert positive values!", "Error", JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null, option, option[0]);
							return;
						}
								Rectangle rec = new Rectangle(new Point(x,y), width, height);
								dlm.add(0, rec);	
								
					} catch(Exception NumberFormatException) {
						getToolkit().beep();
						JOptionPane.showMessageDialog(null, "Insert Numbers!");		
					}
					
				}
			}
		});
		btnAdd.setFont(new Font("Rockwell", Font.PLAIN, 27));
		pnlNorth.add(btnAdd);
		
		JLabel lblSortRectangles = new JLabel("Sort Rectangles");
		lblSortRectangles.setFont(new Font("Rockwell", Font.PLAIN, 25));
		pnlNorth.add(lblSortRectangles);
		
		JButton btnSort = new JButton("Sort");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rectangle rec;
				if(dlm.isEmpty()){
					JOptionPane.showMessageDialog(null, "List is EMPTY!");
				}else{
					for(int i = 0;i<dlm.getSize();i++){
						listRectangles.add(dlm.getElementAt(i));
					}
					for(int i = listRectangles.size();i > 0;i--){
						for(int j = 0;j<i-1;j++){
							if((listRectangles.get(j)).compareTo(listRectangles.get(j+1))>0)
							{
								rec=listRectangles.get(j);
								listRectangles.set(j,listRectangles.get(j+1));
								listRectangles.set(j+1, rec);
							}
						}
					}
					
				}
				dlm.removeAllElements();
				for(int i = 0; i<listRectangles.size(); i++)
				{
					dlm.addElement(listRectangles.get(i));
				}
				
			listRectangles.clear();
			}
			
		});
		btnSort.setFont(new Font("Rockwell", Font.PLAIN, 27));
		pnlNorth.add(btnSort);
		
		JPanel pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		
		JScrollPane scrollPaneRectangle = new JScrollPane();
		JList listRectangle = new JList();
		scrollPaneRectangle.setViewportView(listRectangle);
		listRectangle.setModel(dlm);
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGap(25)
					.addComponent(scrollPaneRectangle, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGap(7)
					.addComponent(scrollPaneRectangle, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		
		
		pnlCenter.setLayout(gl_pnlCenter);
		
		JPanel pnlSouth = new JPanel();
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
		
		JButton btnClearList = new JButton("Clear list");
		btnClearList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dlm.isEmpty()){
					JOptionPane.showMessageDialog(null, "List is EMPTY!");
				}else{
					dlm.clear();
				}
			}
		});
		btnClearList.setFont(new Font("Rockwell", Font.PLAIN, 27));
		pnlSouth.add(btnClearList);
		
		
	}
}
