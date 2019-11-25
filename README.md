This is the code for Illumio's coding assessment.

I completed the assessment in about 100 minutes and my main focus was on the design and functioning such that it is open for extension and closed for modification.

I have tested the functionality of my code using JUnit test cases and i tried to cover the general cases as well as the edge cases to the best of my ability in the limited given time period.

DESIGN

The overall design of my code is as follows:
1. I have a Firewall interface and an implementation of a Firewall Interface called FirewallImpl.
2. I have created a Rule class and a Packet class which extend the AbstractPacketRule class so that if in the future we need to extend our functionalities, we can easily use this design without modification in the existing code.
3. I am storing the rules in a Hash Set so that we do not save duplicate rules. The Set uses mny custom equals method which has been implemented in such a way that it will take care of the duplicate rules or if a rule is a subset of another rule and thus causing zero duplicacy in any way.
4. I have created two classes calles PortUtil and IpAddressUtil to represent the ports and the ip addresses. I have used constructor overloading in these classes to identify if a given rule contains single port/ip or a range of port/ip.

REFINEMENTS

If i would have had more time i would have thought more on the design of the code for instance i would have thought thoroughly of using design patterns like Builder or Factory for building and representing rules in a more efficient way such that i can save more on the space complexity. On the other hand i would have also thought about saving some time complexity and doing better than linear time by using an efficient data structure which results in faster or rather exact lookup of rules for incoming packets rather than checking packets against each and every rule which is linear time.

TEAM

I would love to work for the Platform Team or the Data Team.
