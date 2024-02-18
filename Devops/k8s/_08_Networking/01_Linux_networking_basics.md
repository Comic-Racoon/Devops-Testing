Networking Basics and Configuration in Linux

    Introduction to Networking Concepts
        Understanding switching, routing, gateways, and DNS.
        Introduction to CoreDNS and configuring DNS settings on Linux.
        Basics of network namespaces in Linux.

    Networking from a Linux Perspective
        Exploring networking concepts from both a system admin's and an application developer's perspective.
        Focus on practical configuration and troubleshooting rather than theoretical knowledge.

    Connecting Systems in a Network
        Systems communicate through switches within a network.
        Each system needs an interface, physical or virtual, connected to the switch.
        Example: Using ip link and ip addr commands to view and configure interfaces and IP addresses.

    Communication between Networks
        Routers connect different networks.
        Configuring routes and gateways to enable communication between networks.
        Example: Using route command to view routing table and ip route add command to add routing entries.

    Setting Up a Linux Host as a Router
        Enabling packet forwarding between interfaces on a Linux host.
        Editing /proc/sys/net/ipv4/ip_forward to enable packet forwarding temporarily.
        Editing /etc/sysctl.conf to persist changes across reboots.

    Key Commands
        ip link: List and modify interfaces.
        ip addr: View and set IP addresses.
        ip route or route: View routing table.
        ip route add: Add entries to the routing table.
        Checking IP forwarding status: cat /proc/sys/net/ipv4/ip_forward.