package PropertyInterface;

import InputParser.InputParser;
import Property.Property;
import PropertyRegister.PropertyRegister;

import java.util.ArrayList;
import java.util.List;

public class PropertyRegisterInterface {
  private static final PropertyRegister propertyRegister = new PropertyRegister();
  public static void main(String[] args) {
    propertyRegister.addProperty(new Property("Gloppen", 1445, 77, 631, null, 1017.6, "Jens Olsen"));
    propertyRegister.addProperty(new Property("Gloppen", 1445, 77, 131, "Syningom", 661.3, "Nicolay Madsen"));
    propertyRegister.addProperty(new Property("Gloppen", 1445, 75, 19, "Fugletun", 650.6, "Evilyn Jensen"));
    propertyRegister.addProperty(new Property("Gloppen", 1445, 74, 188, null, 1457.2, "Karl Ove Bråten"));
    propertyRegister.addProperty(new Property("Gloppen", 1445, 69, 47, "Høiberg", 1339.4, "Elsa Indregård"));
    
    while (true) {
      System.out.println(propertyRegister);
      System.out.println(
        "1. Legg til eiendom\n" +
        "2. Finn eiendom\n" +
        "3. Fjern eiendom\n" +
        "4. Gjennomsnittlig areal\n" +
        "5. Finn eiendommer med gitt gårdsnummer\n" +
        "6. Avslutt"
      );
      int input = InputParser.getInt("Valg: ", n -> 1 <= n && n <= 6 );
      System.out.println(input);
      switch (input) {
        case 1 -> {
          String municipalityName = InputParser.getString("Kommunenavn: ");
          int municipalityNumber = InputParser.getInt("Kommunenummer: ", a -> 101 <= a && a <= 5054);



          int lotNumber = InputParser.getInt("Gårdsnummer: ", n -> 0 <= n );
          int sectionNumber = InputParser.getInt("Bruksnummer: ", n -> 0 <= n );
          String name = InputParser.getString("Bruksnavn: ");
          double area = InputParser.getDouble("Areal: ", n -> 0 <= n);
          String ownerName = InputParser.getString("Eier: ", s -> !s.isEmpty());

          Property property = new Property(municipalityName, municipalityNumber, lotNumber, sectionNumber, name, area, ownerName);
          propertyRegister.addProperty(property);

          System.out.println("La til eiendom " + property);
        }
        case 2 -> {
          Property property = askForProperty();
          if (property != null) {
            System.out.println(property);
          } else {
            System.out.println("Fant ingen eiendommer med gitt kommunenummer og gårdsnummer");
          }
        }
        case 3 -> {
          Property property = askForProperty();
          boolean removed = propertyRegister.removeProperty(property);
          if (removed) {
            System.out.println("Eiendom fjernet");
          } else {
            System.out.println("Fant ingen eiendom med gitt kommunenummer, gårdsnummer og bruksnummer");
          }
        }
        case 4 -> {
          double averageArea = propertyRegister.getAveragePropertyArea();
          System.out.println("Gjennomsnittlig areal: " + averageArea);
        }
        case 5 -> {
          int lotNumber = InputParser.getInt("Gårdsnummer: ", n -> { return 0 <= n; });
          // use list as return type

          List<Property> properties = propertyRegister.findPropertiesByLotNumber(lotNumber);
          if (!properties.isEmpty()) {
            for (Property property : properties) {
              System.out.println(property);
            }
          } else {
            System.out.println("Fant ingen eiendommer med gitt gårdsnummer");
          }
        }
        case 6 -> {
          System.exit(0);
        }
      }
    }
  }
  private static Property askForProperty() {
    int municipalityNumber = InputParser.getInt("Kommunenummer: ", n -> 101 <= n && n <= 5054 );
    int lotNumber = InputParser.getInt("Gårdsnummer: ", n -> 0 <= n );
    int sectionNumber = InputParser.getInt("Bruksnummer: ", n -> 0 <= n );

    return propertyRegister.findProperty(municipalityNumber, lotNumber, sectionNumber);
  }
}

