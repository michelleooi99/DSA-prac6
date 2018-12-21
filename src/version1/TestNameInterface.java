package version1;

public class TestNameInterface {

  public static void main(String[] args) {
    SortedListInterface<NameInterface> nameList = new SortedArrayList<NameInterface>();

    nameList.add(new WesternName("Johann", "Sebastian", "Bach"));
    nameList.add(new ChineseName("Tan", "Kheng Hua"));
    nameList.add(new ChineseName("Phua", "Chu Beng"));
    nameList.add(new WesternName("Cate", "Blanchett"));
    nameList.add(new ChineseName("Cheng", "Ho"));
    nameList.add(new WesternName("Mary", "Louise", "Parker"));
    nameList.add(new ChineseName("Lee", "Siew Lian"));
    nameList.add(new WesternName("Andy", "Serkis"));
    nameList.add(new ChineseName("Gong", "Li"));

    System.out.println("Name List: \n" + nameList);
    System.out.println("Total names: " + nameList.getLength());

    System.out.println("\nPrinting short names of nameList: ");
    System.out.printf("%-30s %-20s\n", "Full name", "Short Name");
    System.out.printf("%-30s %-20s\n", "---------", "----------");
    for (int pos = 1; pos <= nameList.getLength(); ++pos) {
      System.out.printf("%-30s %-20s\n", nameList.getEntry(pos), nameList.getEntry(pos).getShortName());
    }

    System.out.println();
  }
}
