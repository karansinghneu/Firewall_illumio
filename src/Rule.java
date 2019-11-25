/**
 * A representation of a Rule which extends the Abstract Packet Rule class.
 */
public class Rule extends AbstractPacketRule {

  /**
   * A constructor to initialize the direction, protocol, port and ip address of a rule.
   * @param direction direction of a rule
   * @param protocol protocol of a rule
   * @param port port of a rule
   * @param ipAddress ip address of a rule as a string
   */
  Rule(String direction, String protocol, String port, String ipAddress){
    super(direction,protocol);
    portCreation(port);
    ipAddressCreation(ipAddress);
  }

  /**
   * A method which initializes an object of the ip address of a rule by using constructor overloading
   * after identifying if the rule consists of a single ip address or a range of ip addresses
   * @param ipAddress the ip address of a rule as a string
   */
  protected void ipAddressCreation(String ipAddress) {
    if(ipAddress.indexOf('-')!=-1){
      String[] ipDivisionArray = ipAddress.split("-");
      this.ipAddress = new IpAddressUtil(ipDivisionArray[0], ipDivisionArray[1]);
    }
    else {
      this.ipAddress = new IpAddressUtil(ipAddress);
    }
  }

  /**
   * A method which initializes an object of the port of a rule by using constructor overloading
   * after identifying if the rule consists of a single port number or a range of port numbers
   * @param port the port number of a rule as a string
   */
  protected void portCreation(String port) {
    if(port.indexOf('-')!=-1){
      String[] portDivisionArray = port.split("-");
        this.port = new PortUtil(portDivisionArray[0], portDivisionArray[1]);
    }
    else {
      this.port = new PortUtil(port);
    }
  }

  @Override
  public String toString() {
    return "Rule{" +
            "direction='" + direction + '\'' +
            ", protocol='" + protocol + '\'' +
            ", port=" + port +
            ", ipAddress=" + ipAddress +
            '}';
  }
}
