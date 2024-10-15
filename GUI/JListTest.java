package GUI;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class JListTest extends JFrame implements ActionListener{
	
	JList leftList, rightList;
	DefaultListModel leftListModel, rightListModel;
	JButton next, previous;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JListTest app = new JListTest();
	}
	
	public JListTest() {
		super("test");
		initializeComponents();
	}

	private void initializeComponents() {
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		leftListModel = new DefaultListModel();
		rightListModel = new DefaultListModel();
		
		for(int i = 1; i < 10; i++) leftListModel.addElement(Integer.toString(i));
		
		leftList = new JList(leftListModel);
		rightList = new JList(rightListModel);
		
		leftList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		rightList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		leftList.setLayoutOrientation(JList.VERTICAL);
		rightList.setLayoutOrientation(JList.VERTICAL);
		leftList.setVisibleRowCount(5);
		
		rightList.setVisibleRowCount(5);
		JScrollPane lscrollList = new JScrollPane(leftList);
		JScrollPane rscrollList = new JScrollPane(rightList);
		lscrollList.setPreferredSize(new Dimension(50, 100));
		rscrollList.setPreferredSize(new Dimension(50, 100));
		
		next = new JButton("Next");
		previous = new JButton("Previous");
		next.addActionListener(this);
		previous.addActionListener(this);
		
		c.add(lscrollList);
		c.add(next);
		c.add(previous);
		c.add(rscrollList);
		
		pack();
		setSize(800,800);
		setLocation(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == next)
		{
			if(leftList.isSelectionEmpty()) return;
			
			int i = leftList.getSelectedIndex();
			rightListModel.addElement(leftListModel.getElementAt(i));
			leftListModel.remove(i);
		}
		else if(e.getSource() == previous)
		{
			if(rightList.isSelectionEmpty()) return;
			int i = rightList.getSelectedIndex();
			leftListModel.addElement(rightListModel.getElementAt(i));
			rightListModel.remove(i);
		}
	}
}
