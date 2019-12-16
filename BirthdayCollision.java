import java.util.*;

public class BirthdayCollision {

	Random rand = new Random();

	public int simulateRoom(int numberOfPeople) {

		HashSet<Integer> BirthdayCollision = new HashSet<Integer>();

		int count = 0;

		while (numberOfPeople != 0) {
			int day = rand.nextInt(365) + 1;
			if (BirthdayCollision.contains(day)) {
				count++;
			} else {
				BirthdayCollision.add(day);
			}
			numberOfPeople--;
		}
		return count;

	}

	public String runSimulations(int numberOfPeople, int numberOfSimulations) {

		float totalCount = 0;

		float numSimulations = (float) numberOfSimulations;

		while (numberOfSimulations != 0) {

			totalCount = totalCount + simulateRoom(numberOfPeople);

			numberOfSimulations--;

		}

		float prob = totalCount / numSimulations;

		String returnString = "For " + numberOfPeople + " people, the probability of a Birthday collision is " + prob;

		return returnString;

	}

	public static void main(String[] args) {

		BirthdayCollision test = new BirthdayCollision();

		for (int i = 2; i <= 50; i++)

			System.out.println(test.runSimulations(i, 50000));

	}

}
