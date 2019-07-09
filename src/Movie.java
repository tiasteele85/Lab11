
public class Movie {

	private String title;//store a movie title
	private String category;//store a category

	//default constructor
	public Movie() {
	}

	//Constructor with parameters
	public Movie(String title, String category) {
		this.title = title;
		this.category = category.toLowerCase();
	}
	
	//Method to input title
	public void setTitle(String title) {
		this.title = title;
	}
	
	//Method to retrieve title
	public String getTitle() {
		return title;
	}
	
	//Method to input category
	public void setCategory(String category) {
		this.category = category.toLowerCase();
	}
	
	//Method to retrieve category
	public String getCategory() {
		return category;
	}
	
	//Method to check current categories available
	public static boolean hasCategory(String category)
	{
		switch(category.toLowerCase())
		{
			case "animated":
			case "drama":
			case "horror":
			case "scifi":
				return true;
			default:
				return false;			
		}		
	}
	
	//Method to convert new menu selection
	public static String menuToCategory(int num) {
		switch(num) {
		case 0:
			return "animated";
		case 1:
			return "drama";
		case 2:
			return "horror";
		case 3:
			return "scifi";
		default:
			return "bad choice";
		}
		
	}
	
}
