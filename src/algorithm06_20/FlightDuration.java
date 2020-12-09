package algorithm06_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightDuration {
	private static int END_TIME = 30;

	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	PairInt IDsOfmovies(int flightDuration, int numMovies, List<Integer> movieDuration) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		int maxDuration = 0;
		PairInt pairInt = new PairInt(-1, -1);
		for (int i = 0; i < numMovies; i++) {
			int num = movieDuration.get(i);
			int diff = flightDuration - num - 30;
			if (map.containsKey(num)) {
				int j = map.get(num);
				int value = flightDuration- (num + diff) ;
				if (value <= 30 && maxDuration < value) {
					maxDuration = value;
					pairInt = new PairInt(i, j);
				}
			} else {				
				map.put(diff, i);
			}
		}

		return pairInt;
	}

	public static void main(String[] args) {
			FlightDuration flight  = new FlightDuration();
			Integer[] movies = new Integer[]{20,70,90,30,60,110};
			List<Integer> list = new ArrayList<Integer>();
			for(int i =0; i< movies.length; i++) {
				list.add(movies[i]);
			}
			PairInt pair = flight.IDsOfmovies(110, 6, list);
			System.out.println("Piar "+pair);
		}
}
