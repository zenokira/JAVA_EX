package 그림판;


import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main그림판 extends JFrame implements ActionListener{
	static enum BtnType {
		색상, 도형, 도구
	};
	static enum DiagramType {
		직선, 원, 사각형, 삼각형
	};
	
	private MyLabel colorLabel;
	private MyButton test = new MyButton();
	private ArrayList<ArrayList<MyButton>> arrBtn = new ArrayList<ArrayList<MyButton>>();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main그림판 app = new Main그림판();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MyButton btn = (MyButton) e.getSource();
		
		if(btn.getBtnType() == BtnType.색상)
		{
			test.setColor(btn.getColor());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Main그림판()
	{
		super("그림판");
		initialize();
	}
	
	private void initialize()
	{
		colorLabel = new MyLabel(Color.black);
		initButton();
		initializeComponents();
	}
	
	private void initButton()
	{
		ArrayList<MyButton> color = new ArrayList<MyButton>();
		
		for(int i = 0; i < 10; i++)
		{
			MyButton btn = new MyButton(BtnType.색상);
			color.add(btn);
		}
		color.get(0).setColor(Color.black);		color.get(1).setColor(Color.white);
		color.get(2).setColor(Color.red);		color.get(3).setColor(Color.orange);
		color.get(4).setColor(Color.yellow);	color.get(5).setColor(Color.green);
		color.get(6).setColor(Color.blue);		color.get(7).setColor(Color.pink);
		color.get(8).setColor(Color.magenta);	color.get(9).setColor(Color.gray);
		
		arrBtn.add(color);
		
		ArrayList<MyButton> dia = new ArrayList<MyButton>();
		for(int i = 0; i < 5; i++)
		{
			MyButton btn = new MyButton(BtnType.도형);
			dia.add(btn);
		}
		
		arrBtn.add(dia);
		
		ArrayList<MyButton> tool = new ArrayList<MyButton>();
		for(int i = 0; i < 3; i++)
		{
			MyButton btn = new MyButton(BtnType.도구);
			tool.add(btn);
		}
		arrBtn.add(tool);
	}
	

	private void initializeComponents()
	{
		Container c = getContentPane();
		c.setLayout(new GridBagLayout());
				
		JPanel northPanel = new JPanel(new GridBagLayout());
		JPanel mainPanel = new JPanel();
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0; gbc.gridy = 0;
		gbc.weighty = 0.1;
		c.add(northPanel,gbc);
		
		gbc.gridx = 0; gbc.gridy = 1;
		gbc.weighty = 0.6;
		c.add(mainPanel,gbc);
		
		JPanel tPanel =  new JPanel();
		JPanel dPanel =  new JPanel();
		JPanel cPanel =  new JPanel();
		JPanel pPanel =  new JPanel();
		
		northPanel.add(tPanel);
		northPanel.add(dPanel);
		northPanel.add(cPanel);
		
		northPanel.add(pPanel);
		
		
		mainPanel.add(test);
		
		for(int i = 0; i < 10; i++)
		{
			MyButton btn = arrBtn.get(0).get(i);
			btn.addActionListener(this);
			cPanel.add(btn);
		}
		
		
		
		
		
		
		
		
		
		
		pack();
		this.setSize(1280, 800);
		setResizable(false);
		setLocation(200,0);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
}

