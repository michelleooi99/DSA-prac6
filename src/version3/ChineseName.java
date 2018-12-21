package version3;

public class ChineseName implements NameInterface {

  private String surName;
  private String givenName;

  public ChineseName(String surName, String givenName) {
    this.surName = surName;
    this.givenName = givenName;
  }

  public String getFullName() {
    return surName + " " + givenName;
  }

  public String getShortName() {
    String[] nameParts = givenName.split("\\s");

    return "Ah " + nameParts[nameParts.length - 1];
  }

  public String toString() {
    return getFullName();
  }

  public int compareTo(NameInterface other) {
    return this.getFullName().compareTo(other.getFullName());
  }

  public boolean equals(Object other) {
    if (other instanceof ChineseName) {
      ChineseName otherName = (ChineseName) other;
      return (this.surName.equals(otherName.surName) && this.givenName.equals(otherName.givenName));
    }
    return false;
  }
}
