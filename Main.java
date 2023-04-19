import java.util.*;

class Movie {
    String name;
    double imdbRating;
    String pgRating;

    public Movie(String name, double imdbRating, String pgRating) {
        this.name = name;
        this.imdbRating = imdbRating;
        this.pgRating = pgRating;
    }
}

class Display_Watchlist {
    ArrayList<Movie> watchlist;

    public Display_Watchlist(ArrayList<Movie> watchlist) {
        this.watchlist = watchlist;
    }

    public void display() {
        if (watchlist.isEmpty()) {
            System.out.println("Watchlist is empty");
        } else {
            for (Movie movie : watchlist) {
                System.out.println(movie.name + " - IMDB: " + movie.imdbRating + ", PG: " + movie.pgRating);
            }
        }
    }
}

class Cinema {
    ArrayList<Movie> watchlist;

    public Cinema(ArrayList<Movie> watchlist) {
        this.watchlist = watchlist;
    }

    public void chooseMovie(String name) {
        boolean found = false;
        for (Movie movie : watchlist) {
            if (movie.name.equalsIgnoreCase(name)) {
                System.out.println(movie.name + " - IMDB: " + movie.imdbRating + ", PG: " + movie.pgRating);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Movie not found");
        }
    }
}

class Add_Remove {
    ArrayList<Movie> watchlist;

    public Add_Remove(ArrayList<Movie> watchlist) {
        this.watchlist = watchlist;
    }

    public void addMovie(Movie movie) {
	 boolean found = false;
        for (Movie m : watchlist) {
            if (m.name.equalsIgnoreCase(movie.name)) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Movie already exists");
        } else {
            watchlist.add(movie);
        }
    }

    public void removeMovie(String name) {
        boolean found = false;
        for (Movie movie : watchlist) {
            if (movie.name.equalsIgnoreCase(name)) {
                watchlist.remove(movie);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Movie not found");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Movie> watchlist = new ArrayList<>();
        watchlist.add(new Movie("The Shawshank Redemption", 9.3, "R"));
        watchlist.add(new Movie("The Godfather", 9.2, "R"));
        watchlist.add(new Movie("The Dark Knight", 9.0, "PG-13"));
        watchlist.add(new Movie("The Last Of Us", 8.9, "TV-MA"));
        watchlist.add(new Movie("Top Gun: Maverick", 8.3, "M"));
        watchlist.add(new Movie("Joker", 8.4, "R"));

        Scanner scanner = new Scanner(System.in);
	    String choice;
        Display_Watchlist displayWatchlist = new Display_Watchlist(watchlist);
        Cinema cinema = new Cinema(watchlist);
        Add_Remove addRemove = new Add_Remove(watchlist);

        do{
            System.out.println("1. Display Watchlist\n2. Choose Movie\n3. Add Movie\n4. Remove Movie\n5. Exit");
 	      System.out.print("Enter your choice: ");
            choice = scanner.nextLine();
            //scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("\nThe watchlist: ");
                    displayWatchlist.display();
                    break;
                case "2":
                    System.out.print("\nEnter movie name: ");
                    String name = scanner.nextLine();
                    cinema.chooseMovie(name);
                    break;
                case "3":
                    System.out.print("\nEnter movie name: ");
                    String addName = scanner.nextLine();
                    System.out.print("\nEnter IMDB rating: ");
                    double imdbRating=0.0;
                    boolean b=true;
                    while(b){
                        String iR=scanner.nextLine();
                        try{
                            imdbRating = Double.parseDouble(iR);
                            b=false;
                        }
                        catch (NumberFormatException e) {
                            System.out.println("\nArgument must be numeric\nTry entering the IMDB rating again: ");
                        }
                    }
                    System.out.print("\nEnter PG rating: ");
                    String pgRating = scanner.nextLine();
                    addRemove.addMovie(new Movie(addName, imdbRating, pgRating));
                    System.out.println("++ADDED++");
                    break;
                case "4":
                    System.out.print("\nEnter movie name: ");
                    String removeName = scanner.nextLine();
                    addRemove.removeMovie(removeName);
                    System.out.println("--REMOVED--");
                    break;
                case "5":
                    System.out.println("\nExiting...");
                    break;
                default:
                    System.out.println("\nInvalid choice");
			  break;
            }
	   System.out.println();
        }while(!(choice.equals("5")));
    }
}
