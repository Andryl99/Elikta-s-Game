package tools;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

//classe stockant et distribuant tout les données indispensables aux jeux
public class GameData {
	
	Properties prop = new Properties();
	InputStream input = null;{
	
	try {
		
		input = new FileInputStream("config.properties");
		prop.load(input);
	}catch(IOException e) {
		e.printStackTrace();
	}
	}
	
	protected int lifeCount = Integer.parseInt(prop.getProperty("lifeCount"));
	protected int casesLenght = Integer.parseInt(prop.getProperty("casesLenght"));
	protected int nbAllowed = Integer.parseInt(prop.getProperty("nbAllowed"));
	protected boolean devMode = Boolean.parseBoolean(prop.getProperty("devMode"));
	
	public int getLifeCount() {
		return lifeCount;
	}
	
	public int getCasesLenght() {
		return casesLenght;
	}
	
	public int getNbAllowed() {
		return nbAllowed;
	}
	
	public boolean getDevMode() {
		return devMode;
	}

}
