package MusicGame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class BackGroundMusicDemonstrate extends JPanel implements ActionListener{
	private MusicPlayer musicplayer;
	JButton nextbutton;
	JButton startbutton;
	JButton stopbutton;
	JButton resumebutton;
	
	public BackGroundMusicDemonstrate (){
		super ();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setLayout(new FlowLayout ());

		musicplayer = new MusicPlayer ("AudioFile/startdash.wav");
		startbutton = new JButton ("Start");
		stopbutton = new JButton ("Stop");
		resumebutton = new JButton ("Resume");
		nextbutton = new JButton ("Next");
		startbutton.addActionListener(this);
		stopbutton.addActionListener(this);
		resumebutton.addActionListener(this);
		nextbutton.addActionListener(this);
		this.add(startbutton);
		this.add(stopbutton);
		this.add(resumebutton);
		this.add(nextbutton);
	}
	
	public static void main (String []arg0){
		JFrame frame = new JFrame ("Demonstrate");
		frame.add(new BackGroundMusicDemonstrate());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() == startbutton){
			musicplayer.Start();
		}else if (arg0.getSource() == stopbutton){
			musicplayer.stop();
		}else if (arg0.getSource() == resumebutton){
			musicplayer.resume();
		}else if (arg0.getSource() == nextbutton){
			musicplayer.stop();
			musicplayer.setPath("AudioFile/bip.wav");
			musicplayer.Start();
		}
	}
}
