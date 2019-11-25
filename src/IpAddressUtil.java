import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
/**
 * An ip address util class that represents an ip address and uses constructor overloading to identify if the
 * ip address  is a single ip address or a range of ip addresses.
 */
public class IpAddressUtil {
  /**
   * List to store the starting ip address of a range.
   */
  private List<Integer> ipStart;
  /**
   * List to store the ending ip address of a range.
   */
  private List<Integer> ipEnd;
  /**
   * List to store a single ip address
   */
  private List<Integer> ipAddress;

  /**
   * A constructor which stores the ip address as a string in case of a single ip address
   * @param ip the ip address as a string
   */
  IpAddressUtil(String ip){
    this.ipAddress =  Arrays
            .stream(ip.split("\\."))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

  }
  /**
   * An overloaded constructor which initializes the starting ip address as a list and
   * the ending ip address as a list of a range of ip addresses.
   * @param ipStart the starting ip address of a range
   * @param ipEnd the ending ip address of a range
   */
  IpAddressUtil(String ipStart, String ipEnd){
    this.ipStart = Arrays
            .stream(ipStart.split("\\."))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

    this.ipEnd = Arrays
            .stream(ipEnd.split("\\."))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

  }
  /**
   * A method to validate if an ip address is equal to an incoming ip address or lies between a range
   * of ip addresses.
   * For the entire implementation we take the ip addresses to be inclusive.
   * @param inputIpAddress the incoming ip address object
   * @return true if equal or lies between the range, false otherwise
   */
  public boolean validateIpRange(IpAddressUtil inputIpAddress){

    if(inputIpAddress.ipAddress == null){
      if(this.ipAddress == null){
        /**
         * The case when both the ip addresses are a range in which case the start and end ip addresses
         * of both the ip address should be same.
         */
        for (int i = 0; i < 4; i++) {
          if (inputIpAddress.ipStart.get(i) != this.ipStart.get(i) || inputIpAddress.ipEnd.get(i) != this.ipEnd.get(i)) {
            return false;
          }
        }
        return true;
      }
      else {
        /**
         * The case when this ip address is a single ip address and the incoming ip address is a range in which case
         * we check if this ip address lies in the range of the incoming ip address.
         */
        for (int i = 0; i < 4; i++) {
          if (this.ipAddress.get(i) < inputIpAddress.ipStart.get(i) || this.ipAddress.get(i) > inputIpAddress.ipEnd.get(i)) {
            return false;
          }
        }

        return true;
      }
    }
    else {
      if(this.ipAddress == null){
        /**
         * The case when the incoming ip address is a a single ip address and this ip address is a range in which case
         * we check if the incoming ip address lies in the range of this ip address. This is a classic example
         * of a packet's ip address being checked in the range of a rule's ip addresses.
         */
        for (int i = 0; i < 4; i++) {
          if (inputIpAddress.ipAddress.get(i) < this.ipStart.get(i) || inputIpAddress.ipAddress.get(i) > this.ipEnd.get(i)) {
            return false;
          }
        }

        return true;
      }
      else {
        /**
         * The case when the incoming ip address is a single ip address and this ip address is also
         * a single ip address in which case we check if the the incoming ip address is the same as this ip address.
         * This is a classic example of a packet's ip address being checked if it is same as the
         * rule's ip address.
         */
        for (int i = 0; i < 4; i++) {
          if (!inputIpAddress.ipAddress.get(i).equals(this.ipAddress.get(i))) {
            return false;
          }
        }
        return true;
      }
    }
  }

  @Override
  public String toString() {
    return "IpAddressUtil{" +
            "ipStart=" + ipStart +
            ", ipEnd=" + ipEnd +
            ", ipAddress=" + ipAddress +
            '}';
  }
}
