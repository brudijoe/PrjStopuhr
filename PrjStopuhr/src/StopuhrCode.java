import edu.princeton.cs.introcs.StdIn;

public class StopuhrCode {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		//Eingabe Zeit
		System.out.print("Bitte Stunden eingeben: ");
		int hours = StdIn.readInt();
		System.out.print("Bitte Minuten eingeben: ");
		int minutes = StdIn.readInt();
		System.out.print("Bitte Sekunden eingeben: ");
		int seconds = StdIn.readInt();
		
		//Schleife Zeit Sekunden
		for(int count = 0; count <= seconds + (minutes*60) + (hours*3600); count++) {
			System.out.println(count);
			Thread.sleep(1000);		
		}
		
	}
	
}
