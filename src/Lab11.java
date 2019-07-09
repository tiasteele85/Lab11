
import java.util.*;

public class Lab11 {

	public static void main(String[] args) {
		// Variables
		Scanner in = new Scanner(System.in);// accepts user input
		// create list to store available movies
		ArrayList<Movie> movieList = new ArrayList<>();
		// obtain list of available movies
		String category = "";// store user input
		char choice = 'Y';

		movieList = makeMoviesList();

		// Print Welcome message
		System.out.println("Welcome to the Movie List Application");
		System.out.println("There are 10 movies in this list.");

		// Menu
		do {
			//print out menu by using static method
			for(int i = 0; i < 4; i++)
			{
				System.out.println((i + 1) + ") " + Movie.menuToCategory(i));
			}
			System.out.println("What category are you interested in?");
			try {
				int menu = in.nextInt();
				//use same static method to convert menu number to category
				category = Movie.menuToCategory(menu - 1);
			} catch (InputMismatchException ex) {
				System.out.println("Invalid Choice. Please enter a numeric number");
				in.nextLine();// clear scanner object
				continue;
			}

			while (!Movie.hasCategory(category)) {

				System.out.println("That category doesn't exist. Select again.");
				category = in.nextLine();
			}

			// display the list of movies in category
			getMoviesTheyWant(category.toLowerCase(), movieList);

			// prompt the user to continue
			System.out.println("Continue (y/n)?");
			in.nextLine();//clear scanner object
			choice = in.nextLine().toUpperCase().charAt(0);

		} while (choice == 'Y');

		System.out.println("Goodbye!");
		// close scanner object
		in.close();

	}

	// Method to print out movies that match the category
	public static void getMoviesTheyWant(String category, ArrayList<Movie> queue) {

		Set<String> sortOrder = new TreeSet<>();

		for (int i = 0; i < queue.size(); i++) {
			if (queue.get(i).getCategory().toLowerCase().equals(category)) {
				sortOrder.add(queue.get(i).getTitle());
			}
		}

		// Print sorted List
		for (String titles : sortOrder) {
			System.out.println(titles);
		}

	}

	// Method to create list of available movies
	// must enter category as lower case
	public static ArrayList<Movie> makeMoviesList() {

		// create new List to store data
		ArrayList<Movie> movieType = new ArrayList<>();

		movieType.add(new Movie("Star Wars", "scifi"));
		movieType.add(new Movie("Dune", "scifi"));
		movieType.add(new Movie("Howls Moving Castle", "animated"));
		movieType.add(new Movie("Coco", "animated"));
		movieType.add(new Movie("Avatar", "animated"));
		movieType.add(new Movie("Pretty Woman", "drama"));
		movieType.add(new Movie("Boys don't cry", "drama"));
		movieType.add(new Movie("Scream", "horror"));
		movieType.add(new Movie("Alien", "horror"));
		movieType.add(new Movie("Puppet Master", "horror"));

		return movieType;
	}

}
