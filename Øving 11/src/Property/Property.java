package Property;

import java.util.Objects;

public class Property {
  /** Kommunenummer */
  private int municipalityNumber;
  /** Kommunenavn */
  private String municipalityName;
  /** Gårdsnummer */
  private int lotNumber;
  /** Bruksnavn */
  private String name;
  /** Eier */
  private String ownerName;
  /** Areal */
  private double area;
  /** Bruk */
  private int sectionNumber;
  public Property(String municipalityName, int municipalityNumber, int lotNumber, int sectionNumber, String name, double area, String ownerName) {
    setMunicipalityName(municipalityName);
    setMunicipalityNumber(municipalityNumber);
    setLotNumber(lotNumber);
    setSectionNumber(sectionNumber);
    setName(name);
    setArea(area);
    setOwnerName(ownerName);
    municipalityNumber = 0;
  }
  public String getMunicipalityName() {
    return municipalityName;
  }
  public void setMunicipalityName(String municipalityName) {
    this.municipalityName = municipalityName;
  }
  public int getMunicipalityNumber() {
    return municipalityNumber;
  }
  public void setMunicipalityNumber(int municipalityNumber) {
    if (101 > municipalityNumber || municipalityNumber > 5054) {
      throw new IllegalArgumentException("Municipality number must be between 101 and 5054");
    }
    this.municipalityNumber = municipalityNumber;
  }
  public int getLotNumber() {
    return lotNumber;
  }
  public void setLotNumber(int lotNumber) {
    if (lotNumber < 0) throw new IllegalArgumentException("Lot number must be a positive integer");
    this.lotNumber = lotNumber;
  }
  public int getSectionNumber() {
    return sectionNumber;
  }
  public void setSectionNumber(int sectionNumber) {
    if (sectionNumber < 0) throw new IllegalArgumentException("Lot number must be a positive integer");
    this.sectionNumber = sectionNumber;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    if (name != null && name.isEmpty()) {
      throw new IllegalArgumentException("Name cannot be empty");
    }
    this.name = name;
  }
  public double getArea() {
    return area;
  }
  public void setArea(double area) {
    if (area < 0) throw new IllegalArgumentException("Area must be a positive number");
    this.area = area;
  }
  public String getOwnerName() {
    return ownerName;
  }
  public void setOwnerName(String ownerName) {
    if (ownerName == null || ownerName.isEmpty()) throw new IllegalArgumentException("Owner name must be a string with length");
    this.ownerName = ownerName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Property property = (Property) o;
    return municipalityNumber == property.municipalityNumber && lotNumber == property.lotNumber && sectionNumber == property.sectionNumber;
  }

  @Override
  public int hashCode() {
    return Objects.hash(municipalityNumber, lotNumber, sectionNumber);
  }

  public String toString() {
    return String.format("%s-%s/%s",
      municipalityNumber,
      lotNumber,
      sectionNumber
    );
  }
}
