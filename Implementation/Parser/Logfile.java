import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class Logfile {

	private String path;
	
	private int lines;
	
	private File file;
	
	private ParserMediator pm;
	
	private FileInputStream fstream = null;
	
	private DataInputStream in = null;
	
	private BufferedReader br = null;
	
	public ParserMediator getPm() {
		return pm;
	}

	public void setPm(ParserMediator pm) {
		this.pm = pm;
	}

	public String getPath() {
		return path;
	}

	public int getLines() {
		return lines;
	}

	public File getFile() {
		return file;
	}

	public Logfile(String path) {
		this.lines = 0;
		this.path = path;
		this.file = new File(path);
		try {
			fstream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		in = new DataInputStream(fstream);
		br = new BufferedReader(new InputStreamReader(in));
		try {
			br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public String readLine() {
		String str = null;
		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		lines++;
		
		return str;
	}
	
}
