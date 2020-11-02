package Class.MovieList;

import java.util.ArrayList;
import java.util.List;

public class MovieList {
    private ArrayList<String> movieList = new ArrayList<>();

    public void addMovieItem(String item) {
        movieList.add(item);
    }
    public void printMovieList() {
        System.out.println("You have " + movieList.size() + " items in your Movie List");
        for(int i=0; i<movieList; i++) {
            System.out.println(i+1);
        }
    }
    public void printMovieList() {
        System.out.println("You have " + movieList.size() + "items in your Movie List");
        for (int i = 0; i < movieList.size(); i++) {
            System.out.println((i + 1) + "." + movieList.get(i));

        }
    }
    public void modifyMovieItem(int position, String newItem) {
        movieList.set(position, newItem);
        System.out.println("Move item " + (position + 1) + "has been modified");
    }
    public void removeMovieItem(int position) {
        String theItem = movieList.get(position);
        movieList.remove(position);
        System.out.println("Remove item " + theItem);
    }
    public String findItem(String searchItem) {
        int position = movieList.indexOf(searchItem);
        if(position >=0 ) {
            return movieList.get(position);
        }
        return null;
    }
    public static void main(String[] args) {
        MovieList list = new MovieList();
        list.addMovieItem("Mắt Biếc");
        list.addMovieItem("Vuh đắng tình yêu");
        list.addMovieItem("Chị trợ lý của anh");
        list.addMovieItem("hai phượng");
        list.addMovieItem();

        String search = list.findItem("Mắt buếc");
        System.out.println(search);

        list.modifyMovieItem(1,"Mắt Đen");
    }
}
