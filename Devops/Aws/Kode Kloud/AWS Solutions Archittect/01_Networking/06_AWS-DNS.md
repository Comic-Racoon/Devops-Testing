* AWS DNS in VPCs
    - Overview
        - Purpose
            - Resolve domain names within a VPC.
            - Assign domain names to private IP addresses for EC2 instances.

    - Domain Name Assignment
        - Default Behavior
            - Private IP addresses assigned to EC2 instances get a domain name by default.
            - Applies to both private and public subnets.
        - Example
            - Instance with IP address 10.0.100.10 gets a domain name with the IP embedded.
            - Resources can communicate via the IP address or the domain name.

    - DNS Servers
        - AWS DNS Servers
            - Provided by AWS for DNS resolution.
            - Accessible via:
                - IP: 169.254.169.253
                - Second IP address of the VPC's CIDR block
                    - Example: For VPC 10.10.0.0/16, DNS server is 10.10.0.2
                    - Example: For VPC 10.20.0.0/16, DNS server is 10.20.0.2

    - Custom VPC DNS Settings
        - Enable DNS Hostnames
            - Determines if the VPC supports assigning public DNS hostnames to instances with public IP addresses.
            - Default is false unless the VPC is a default VPC.
        - Enable DNS Support
            - Determines if the VPC supports DNS resolution through Amazon provided DNS servers.
            - Must be set to true for DNS queries to succeed.

    - Key Points to Remember
        - Private IPs
            - Automatically assigned a DNS entry.
        - AWS DNS Access
            - Accessible via the second IP address of the VPC CIDR block and IP 169.254.169.253.
        - DNS Settings
            - Enable DNS Hostnames: Assigns public DNS hostnames to instances with public IPs.
            - Enable DNS Support: Allows DNS resolution through Amazon provided DNS servers.

    - Summary
        - Device private IPs automatically get DNS entries.
        - AWS DNS servers are accessible on specific IPs.
        - Enable DNS Hostnames: Determines support for public DNS hostnames.
        - Enable DNS Support: Determines support for DNS resolution.
        - Without Enable DNS Support, no DNS resolution occurs.
