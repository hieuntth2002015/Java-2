package ss2.ex1;

import java.util.ArrayList;
import java.util.List;


public class MovieList {
    List<String> favmovies = new ArrayList<>();
    public void addMovie(String movie){
        if(favmovies.contains(movie)){
            System.out.println("Already added");
        }else{
            favmovies.add(movie);}
    }
    public List<String> display(){
        for(int i=0;i<favmovies.size();i++){
            System.out.println(favmovies.get(i));
        }
        return favmovies;
    }
    public void removeMovie(String movie){
        if(favmovies.contains(movie)){
            favmovies.remove(movie);
        }else
            System.out.println(movie + " film doesn't exist");
    }
    public void change(String oldname,String newname){
        if(favmovies.contains(oldname)) {
            int x = favmovies.indexOf(oldname);
            favmovies.set(x, newname);
        }else
            System.out.println(oldname + " film doesn't exist");
    }
    public void search(String movie){
        boolean search = favmovies.contains(movie);
        if(search){
            System.out.println("There is \""+ movie + "\" in the favourite list" );
        }else{
            System.out.println("No found");
        }
    }
    public static void main(String[] args) {
        MovieList favmovie = new MovieList();
        favmovie.addMovie("Free");
        favmovie.addMovie("freedom");
        System.out.println("List of favourite movies: ");
        favmovie.display();
        favmovie.removeMovie("freedom");
        System.out.println("After remove: ");
        favmovie.display();
        favmovie.change("Free","Break");
        System.out.println("After change:");
        favmovie.display();
    }
}
