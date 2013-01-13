
public class ParserMediator {
	
	private Logfile usedFile = null;
	
	
	public void test() {
		System.out.println("hallo");
	}
	
	public boolean parseLogFile(String path) {
		
		usedFile = new Logfile(path);
		usedFile.setPm(this);
		System.out.println(usedFile.readLine());
		return false;
	}
	
	
	

}
