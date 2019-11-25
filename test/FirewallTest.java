import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * A test class for checking the implementation of our Firewall
 */
public class FirewallTest {
  private Firewall firewallObj;

  /**
   * Initializing the firewall object by passing a csv file with rules.
   */
  @Before
  public void setUp() throws IOException {
    firewallObj = new FirewallImpl("input.csv");
  }

  @Test
  public void testPositiveSinglePortRangeIp() {
    assertEquals(true, firewallObj.accept_packet("inbound", "udp", 53, "192.168.2.1"));
  }

  @Test
  public void testPositiveRangePortSingleIp() {
    assertEquals(true, firewallObj.accept_packet("outbound", "tcp", 10234, "192.168.10.11"));
  }

  @Test
  public void testNegativeIncorrectSinglePort() {
    assertEquals(false, firewallObj.accept_packet("inbound", "tcp", 81, "192.168.1.2"));
  }

  @Test
  public void testNegativeIncorrectRangePort() {
    assertEquals(false, firewallObj.accept_packet("inbound", "udp", 24, "52.12.48.92"));
  }

  @Test
  public void testPositiveSinglePortSingleIp() {
    assertEquals(true, firewallObj.accept_packet("inbound", "tcp", 80, "192.168.1.2"));
  }
  @Test
  public void testPositiveStartPortRangeSingleIp() {
    assertEquals(true, firewallObj.accept_packet("outbound", "tcp", 10000, "192.168.10.11"));
  }
  @Test
  public void testNegativeIncorrectDirection() {
    assertEquals(false, firewallObj.accept_packet("inbound", "tcp", 10000, "192.168.10.11"));
  }
  @Test
  public void testPositiveEndPortSingleIp() {
    assertEquals(true, firewallObj.accept_packet("outbound", "tcp", 20000, "192.168.10.11"));
  }
  @Test
  public void testNegativeIncorrectProtocol() {
    assertEquals(false, firewallObj.accept_packet("outbound", "udp", 20000, "192.168.10.11"));
  }
  @Test
  public void testNegativeIncorrectSingleIp() {
    assertEquals(false, firewallObj.accept_packet("outbound", "udp", 2000, "192.168.10.11"));
  }
  @Test
  public void testPositiveSinglePortRangeIpStart() {
    assertEquals(true, firewallObj.accept_packet("inbound", "udp", 53, "192.168.1.2"));
  }
  @Test
  public void testNegativeOutOfRangeIp() {
    assertEquals(false, firewallObj.accept_packet("inbound", "udp", 53, "192.168.3.5"));
  }
  @Test
  public void testPositiveSinglePortEndRangeIp() {
    assertEquals(true, firewallObj.accept_packet("inbound", "udp", 53, "192.168.2.5"));
  }
}
