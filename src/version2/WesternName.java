package version2;

public class WesternName implements Comparable<WesternName> {

  private String firstName;
  private String middleName;
  private String lastName;

  public WesternName(String firstName, String lastName) {
    this(firstName, "", lastName);
  }

  public WesternName(String firstName, String middleName, String lastName) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
  }

  public String getFullName() {
    return firstName + " " + middleName + " " + lastName;
  }

  public String getShortName() {
    return firstName;
  }

  public String toString() {
    return getFullName();
  }

  public int compareTo(WesternName other) {
    return this.getFullName().compareTo(other.getFullName());
  }

  public boolean equals(Object other) {
    if (other instanceof WesternName) {
      WesternName otherName = (WesternName) other;
      return (this.firstName.equals(otherName.firstName)
              && this.middleName.equals(otherName.middleName) && this.lastName.equals(otherName.lastName));
    }
    return false;
  }
}
