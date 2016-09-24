package JUniteTest;

import static org.junit.Assert.*;
import org.junit.Test;
import MusicGame.*;

public class MusicPlayerTest {

	@Test
	public void testOpenAudioFile (){

		MusicPlayer player = new MusicPlayer ("AudioFile/startdash.ogg");
		boolean result = false;
		assertEquals(result,player.openFile());
		player.setPath("AudioFile/startdash.wav");
		result = true;
		assertEquals(result,player.openFile());
	}
	
	@Test
	public void testStopMusic (){
		MusicPlayer player = new MusicPlayer ("AudioFile/startdash.wav");
		player.Start();
		player.stop();
		boolean result = true;
		assertEquals(result,player.isStop());
	}
	
	@Test
	public void testResumeMusic (){
		MusicPlayer player = new MusicPlayer ("AudioFile/startdash.wav");
		player.Start();
		player.resume();
		boolean result = false;
		assertEquals(result,player.isStop());
	}	
}
