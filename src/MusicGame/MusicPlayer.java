package MusicGame;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.*;


public class MusicPlayer {
	AudioPlayer MGP = AudioPlayer.player;
	private boolean isStop = true;
	private double startPosition;
	private String songPath;
	AudioStream BGM;
	AudioData MD;

	public MusicPlayer (String songPath){
		this.songPath = songPath;
	}
		
	public boolean isStop (){
		return isStop;
	}
	
	public void setPath (String songPath){
		this.songPath = songPath;
	}
	
	public boolean openFile (){
		try {
			InputStream test = new FileInputStream(songPath);
			BGM = new AudioStream(test);
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public void Start() {
		ContinuousAudioDataStream loop = null;

		if (isStop() && openFile()){
			AudioPlayer.player.start(BGM);
			this.isStop = false;
			// MD = BGM.getData();
			// loop = new ContinuousAudioDataStream(MD);	
			MGP.start(loop);
			startPosition = (double) (System.currentTimeMillis()*1.00/1000.f);
		}
	}

	public void stop() {
		MGP.stop(BGM);
		isStop = true;
	}
	
	public double currentPosition (){
		return (double) (System.currentTimeMillis()*1.00/1000.f) - startPosition;
	}
	
	public void resume (){
		MGP.start(BGM);
		isStop = false;
	}
}
