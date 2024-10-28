package Dialog;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooseDemo extends JFrame implements ActionListener {

	JLabel imageLabel;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileChooseDemo app = new FileChooseDemo();
	}
	
	public FileChooseDemo()
	{
		super("test");
		initializeComponents();
	}

	private void initializeComponents()
	{
		Container c = getContentPane();
		
		createMenu();
		imageLabel = new JLabel();
		c.add(imageLabel);
		
		setSize(500, 500);
		setLocation(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void createMenu() {
		// TODO Auto-generated method stub
		JMenuBar mb = new JMenuBar();
		JMenu fmenu = new JMenu("파일");
		JMenuItem openItem = new JMenuItem("열기");
		openItem.addActionListener(this);
		
		fmenu.add(openItem);
		mb.add(fmenu);
		this.setJMenuBar(mb);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFileChooser jfc = new JFileChooser();
		FileNameExtensionFilter defaultFilter;
		jfc.addChoosableFileFilter(new FileNameExtensionFilter("비트맵 파일(*.bmp)","bmp"));
		jfc.addChoosableFileFilter(defaultFilter = new FileNameExtensionFilter("JPG 파일(*.jpg)","jpg"));
		jfc.addChoosableFileFilter(new FileNameExtensionFilter("GIF 파일(*.gif)","gif"));
		jfc.setFileFilter(defaultFilter);
		int response = jfc.showOpenDialog(null);
		
		if(response != JFileChooser.APPROVE_OPTION)
		{
			JOptionPane.showMessageDialog(this, "파일을 선택하지 않았습니다.","경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		File f= jfc.getSelectedFile();
		imageLabel.setIcon(new ImageIcon(f.getPath()));
		pack();
		
		
	}
}
