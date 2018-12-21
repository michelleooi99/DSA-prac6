package version2;

public class TestComparable {

  public static void main(String[] args) {
    SortedListInterface<WesternName> nameList = new SortedArrayList<WesternName>();

    nameList.add(new WesternName("Meg", "Ryan"));
    nameList.add(new WesternName("Mary", "Louise", "Parker"));
    nameList.add(new WesternName("Zoe", "Saldana"));
    nameList.add(new RoyalWesternName("Prince", "Philip", "Rainier"));
    System.out.println("\nName List: \n" + nameList);
  }
}
