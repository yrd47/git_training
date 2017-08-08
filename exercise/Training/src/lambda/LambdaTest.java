package lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaTest {
	
	public static void main(String[] args) {
		String[] atp = {"Rafael Nadal", "Novak Djokovic",  
			       "Stanislas Wawrinka",  
			       "David Ferrer","Roger Federer",  
			       "Andy Murray","Tomas Berdych",  
			       "Juan Martin Del Potro"};
		List<String> players = Arrays.asList(atp);
		
		for(String player : players) {
			System.out.println(player + "");
		}
		
		players.forEach((player) -> System.out.println(player + ";"));
		
		players.forEach(System.out::println);
 	}

}
