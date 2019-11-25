
/**
 * A representation of a Packet which extends the Abstract Packet Rule class.
 */
public class Packet extends AbstractPacketRule{
  /**
   * A constructor to initialize the direction, protocol, port and ip address of a packet.
   * @param direction direction of a packet
   * @param protocol protocol of a packet
   * @param port port of a packet
   * @param ipAddress ip address of a packet as a string
   */
   Packet(String direction, String protocol, String port, String ipAddress){
   super(direction,protocol);
    portCreation(port);
    ipAddressCreation(ipAddress);
  }

  /**
   * A method which initializes an object of the port of a packet.
   * @param port the port number of a packet as a string
   */
  protected void portCreation(String port) {
      this.port = new PortUtil(port);
  }
  /**
   * A method which initializes an object of the ip address of a packet.
   * @param ipAddress the ip address of a packet as a string
   */
  protected void ipAddressCreation(String ipAddress) {
      this.ipAddress = new IpAddressUtil(ipAddress);
  }

  @Override
  public String toString() {
    return "Packet{" +
            "direction='" + direction + '\'' +
            ", protocol='" + protocol + '\'' +
            ", port=" + port +
            ", ipAddress=" + ipAddress +
            '}';
  }
}
