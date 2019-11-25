import java.util.Objects;


/**
 * An abstract class for the rules and the packets
 */
public abstract class AbstractPacketRule {

  protected String direction;
  protected String protocol;
  protected PortUtil port;
  protected IpAddressUtil ipAddress;


  /**
   * A constructor of the abstract class which initializes the direction and the protocol
   * @param direction the direction of the rule or the packet
   * @param protocol the protocol of the rule or the packet
   */
   AbstractPacketRule(String direction, String protocol){
     this.direction= direction;
     this.protocol=protocol;
   }

  /**
   * An abstract method for initialising an object of ip address which is implementation
   * specific to a rule or a packet.
   * @param ipAddress the ip address as a string
   */
  abstract protected void ipAddressCreation(String ipAddress);

  /**
   * An abstract method for initialising an object of port which is implementation specific to
   * a rule or a packet.
   * @param port the port number as a string
   */
   abstract protected void portCreation(String port);

   /**
    * An overriden equals method to check if a packet is equal to a rule or a rule is equal to
    * a packet.
    */
  @Override
  public boolean equals(Object o) {
    if (o == null) return false;
    if (this == o) return true;
    AbstractPacketRule inputPacket = (AbstractPacketRule) o;
    return (
            this.direction.equals(inputPacket.direction) &&
                    this.protocol.equals(inputPacket.protocol) &&
                    this.port.validatePortRange(inputPacket.port) &&
                    this.ipAddress.validateIpRange(inputPacket.ipAddress)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(direction, protocol, port, ipAddress);
  }
  abstract public String toString();
}
