import java.io.File;
import java.nio.file.Files;
import java.util.stream.Stream;

public class BusinessLicence {
  private final String businessName;
  private final String name;
  private final String status;
  private final String businessType;
  private final String businessSubType;
  private final String house;
  private final String street;
  private final String city;
  private final String postalCode;
  private final String area;
  private final double numberOfEmployees;
  private final double feePaid;

  public String getBusinessName() {
    return businessName;
  }

  public String getName() {
    return name;
  }

  public String getStatus() {
    return status;
  }

  public String getBusinessType() {
    return businessType;
  }

  public String getBusinessSubType() {
    return businessSubType;
  }

  public String getHouse() {
    return house;
  }

  public String getStreet() {
    return street;
  }

  public String getCity() {
    return city;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public String getArea() {
    return area;
  }

  @Override
  public String toString() {
    return "BusinessLicence{" +
        "businessName='" + businessName + '\'' +
        ", name='" + name + '\'' +
        ", status='" + status + '\'' +
        ", businessType='" + businessType + '\'' +
        ", businessSubType='" + businessSubType + '\'' +
        ", house='" + house + '\'' +
        ", street='" + street + '\'' +
        ", city='" + city + '\'' +
        ", postalCode='" + postalCode + '\'' +
        ", area='" + area + '\'' +
        ", numberOfEmployees=" + numberOfEmployees +
        ", feePaid=" + feePaid +
        '}';
  }

  public double getNumberOfEmployees() {
    return numberOfEmployees;
  }

  public double getFeePaid() {
    return feePaid;
  }

  public BusinessLicence(String line) {
    String[] fields = line.split(",");

    this.businessName = fields[3].trim();
    this.name = fields[4].trim();
    this.status = fields[5].trim();
    this.businessType = fields[8].trim();
    this.businessSubType = fields[9].trim();
    this.house = fields[12].trim();
    this.street = fields[13].trim();
    this.city = fields[14].trim();
    this.postalCode = fields[17].trim();
    this.area = fields[18].trim();
    this.numberOfEmployees = fields[19].trim().equals("") ? -1 : Double.parseDouble(fields[19]);
    this.feePaid = fields[22].trim().equals("") ? -1 : Double.parseDouble(fields[22]);

    /*
    0, LicenceRSN
    1, LicenceNumber
    2, LicenceRevisionNumber
    3, BusinessName
    4, BusinessTradeName
    5, Status
    6, IssuedDate
    7, ExpiredDate
    8, BusinessType
    9, BusinessSubType
    10, Unit
    11, UnitType
    12, House
    13, Street
    14, City
    15, Province
    16, Country
    17, PostalCode
    18, LocalArea
    19, NumberOfEmployees
    20, Latitude
    21, Longitude
    22, FeePaid
    23, ExtractDate
     */
  }
}
