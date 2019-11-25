public interface Firewall {
  /**
   * Method to check if the Firewall should accept a packet with the following properties.
   * @param direction the direction of the packet
   * @param protocol the protocol used by the packet
   * @param port the port number at which the packet arrives
   * @param ip_address the ip address associated
   * @return true if there exists a rule that satisfies the packet, false otherwise
   */
  boolean accept_packet(String direction, String protocol, int port, String ip_address);
}
