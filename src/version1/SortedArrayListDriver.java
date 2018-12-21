package version1;

public class SortedArrayListDriver {

  public static void main(String[] args) {
    SortedListInterface<String> movieList = new SortedArrayList<String>();

    movieList.add("Red");
    movieList.add("The Expendables");
    movieList.add("How to Train Your Dragon");
    movieList.add("Despicable Me");
    movieList.add("The A-Team");
    movieList.add("Avatar");
    movieList.add("Inception");

    System.out.println("Movie List: \n" + movieList);
  }
}
