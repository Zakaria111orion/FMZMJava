package model;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Son {
	public Son(){
		
		
		
	}
	
public void Consomable(){
		
		File Clap = new File("C:\\Users\\charm\\Desktop\\NEW 1\\model\\src\\main\\resources\\Sounds\\Consomable.wav");
		PlaySound(Clap);
	
		
	} 
	
public void Port(){
		
		File Clap = new File("C:\\Users\\charm\\Desktop\\NEW 1\\model\\src\\main\\resources\\Sounds\\Port.wav");
		PlaySound(Clap);
	
		
	} 

public void Death(){
	
	File Clap = new File("C:\\Users\\charm\\Desktop\\NEW 1\\model\\src\\main\\resources\\Sounds\\Death.wav");
	PlaySound(Clap);
	
	
} 

public void Crystal(){
	
	File Clap = new File("C:\\Users\\charm\\Desktop\\NEW 1\\model\\src\\main\\resources\\Sounds\\Opendor.wav");
	PlaySound(Clap);
	
	
} 
	static void PlaySound(File Sound){
		
		try{
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Sound));
			clip.start();
			
		}catch(Exception e){
			
		}
	}

}

