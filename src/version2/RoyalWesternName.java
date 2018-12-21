package version2;

import java.util.Objects;

public class RoyalWesternName extends WesternName {

  private String title;

  public RoyalWesternName(String title, String first, String middle, String last) {
    super(first, middle, last);
    this.title = title;
  }

  public RoyalWesternName(String title, String first, String last) {
    super(first, last);
    this.title = title;
  }

  public String getFullName() {
    return title + " " + super.getFullName();
  }

  public String getShortName() {
    return title + " " + super.getShortName();
  }
  
  public int compareTo(WesternName other) {
    return this.getFullName().compareTo(other.getFullName());
  }

  @Override
  public int hashCode() {
    int hash = 7;
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final RoyalWesternName other = (RoyalWesternName) obj;
    if (!super.equals(obj) && !Objects.equals(this.title, other.title)) {
      return false;
    }
    return true;
  }
  
  

  public String toString() {
    return getFullName();
  }
}
