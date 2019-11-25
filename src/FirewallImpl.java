import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * An implementation of the Firewall interface which reads the properties of the rules from a csv file
 * and stores the rules in a HashSet to avoid storing duplicate rules.
 */
public class FirewallImpl implements Firewall{

  /**
   * HashSet which stores the rules after reading them from a csv file.
   * The Set is of type Rule because it is only used to store the rules and not packets.
   */
  private Set<Rule> rules;

  /**
   * A constructor which takes the path of the input csv file as a string, initializes the rules
   * after reading them from the file and stores the rules in a HashSet.
   * @param path the path of the input file as a string
   */
  FirewallImpl(String path){
    this.rules= new HashSet<>();
    readFile(path);
  }

  /**
   * A method which reads from a csv file using a scanner, initializes the rules after reading and
   * adds the rules to a HashSet
   * @param path the path of the input file as a string
   */
  private void readFile(String path){
    try {
      Scanner scanner = new Scanner(new File(path));
      while (scanner.hasNextLine()) {
        String[] ruleAttributes = scanner.next().split(",");
        this.rules.add(new Rule(ruleAttributes[0], ruleAttributes[1], ruleAttributes[2], ruleAttributes[3]));

      }
      scanner.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  @Override
  public boolean accept_packet(String direction, String protocol, int port, String ip_address) {
    AbstractPacketRule rule = new Packet(direction,protocol,String.valueOf(port),ip_address);
    Iterator<Rule> ruleIterator = this.rules.iterator();
    while (ruleIterator.hasNext()) {
      if (rule.equals(ruleIterator.next())) {
        return true;
      }
    }

    return false;
  }
}
