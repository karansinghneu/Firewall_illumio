/**
 * A port util class that represents a port and uses constructor overloading to identify if the
 * port is a single port number or a range of port numbers.
 */
public class PortUtil {
  private Integer portNumber;
  private Integer portStart;
  private Integer portEnd;

  /**
   * A constructor which initializes the port number
   * @param portNumber the port number as a string
   */
   PortUtil(String portNumber){
    this.portNumber = Integer.parseInt(portNumber);

  }

  /**
   * An overloaded constructor which initializes the starting port number and
   * the ending port number of a range of port numbers.
   * @param portStart the starting port number of a range
   * @param portEnd the ending port number of a range
   */
   PortUtil(String portStart, String portEnd){
    this.portStart = Integer.parseInt(portStart);
    this.portEnd = Integer.parseInt(portEnd);
  }

  /**
   * A method to validate if a port is equal to a port number or lies between a range of port numbers.
   * For the entire implementation we take the port numbers to be inclusive.
   * @param port the port object
   * @return true if equal or lies between the range, false otherwise
   */
  public boolean validatePortRange(PortUtil port){
    if(port.portNumber == null){
      if(this.portNumber == null){
        /**
         * The case when both the ports are a range in which case the start and end port numbers
         * of both the ports should be same
         */
        return this.portStart.equals(port.portStart) && this.portEnd.equals(port.portEnd);
      }
      else {
        /**
         * The case when this port is a port number and the incoming port is a range in which case
         * we check if this port number lies in the range of the incoming port.
         */
        return this.portNumber>=port.portStart && this.portNumber<=port.portEnd;
      }
    }
    else {
      if(this.portNumber == null){
        /**
         * The case when the incoming port is a port number and this port is a range in which case
         * we check if the incoming port lies in the range of this port. This is a classic example
         * of a packet's port number being checked in the range of a rule's port numbers.
         */
        return port.portNumber>=this.portStart && port.portNumber<=this.portEnd;
      }
      else {
        /**
         * The case when the incoming port is a port number and this port is also a port number in
         * which case we check if the the incoming port number is the same as this port number.
         * This is a classic example of a packet's port number being checked if it is same as the
         * rule's port number.
         */
        return (port.portNumber.equals(this.portNumber));
      }
    }
  }

  @Override
  public String toString() {
    return "PortUtil{" +
            "portNumber=" + portNumber +
            ", portStart=" + portStart +
            ", portEnd=" + portEnd +
            '}';
  }
}
