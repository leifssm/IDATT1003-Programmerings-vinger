package PropertyRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Property.Property;

public class PropertyRegister {
  private ArrayList<Property> properties = new ArrayList<Property>();
  public PropertyRegister() {}
  public void addProperty(Property property) {
    if (!properties.contains(property)) {
      properties.add(property);
    }
  }
  public Property findProperty(int municipalityNumber, int lotNumber, int sectionNumber) {
    for (Property property : properties) {
      if (property.getMunicipalityNumber() == municipalityNumber &&
        property.getLotNumber() == lotNumber &&
        property.getSectionNumber() == sectionNumber) return property;
    }
    return null;
  }
  public boolean removeProperty(Property property) {
    //if (property == null) return false;
    return properties.remove(property);
  }
  public int size() {
    return properties.size();
  }
  public double getAveragePropertyArea() {
    if (properties.isEmpty()) return 0;
    double totalArea = 0;
    for (Property property : properties) {
      totalArea += property.getArea();
    }
    return totalArea / properties.size();
  }
  public List<Property> findPropertiesByLotNumber(int lotNumber) {
    return this.properties
        .stream()
        .filter(p -> p.getLotNumber() == lotNumber)
        .collect(Collectors.toList());
  }
  public String toString() {
    // sout should only exist on interface
    StringBuilder s = new StringBuilder("-- Properties --");
    for (Property property : properties) {
      s.append(property);
    }
    return s.toString();
  }
}
