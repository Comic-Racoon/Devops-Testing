DNS (Domain Name System) is a decentralized naming system for computers, services, or any resource connected to the internet or a private network. It translates domain names, which are easy-to-remember human-readable identifiers, into IP addresses, which are numerical identifiers used by computers to locate each other on a network.

Tools for Working with DNS:

    host/nslookup: These command-line tools are used to query DNS servers to obtain domain name or IP address information. They can be used to perform forward and reverse DNS lookups.

    dig: Dig (Domain Information Groper) is a versatile command-line tool for querying DNS name servers. It can be used to retrieve DNS records, perform zone transfers, and test DNS server responses.

Types of DNS Records:

    A (Address) Record: Maps a domain name to an IPv4 address.

    AAAA (IPv6 Address) Record: Maps a domain name to an IPv6 address.

    CNAME (Canonical Name) Record: Creates an alias or canonical name for a domain. It is often used to point one domain to another domain.

    MX (Mail Exchange) Record: Specifies the mail server responsible for receiving email on behalf of a domain.

    TXT (Text) Record: Used to store arbitrary text data. It can be used for various purposes, such as domain verification, SPF records, and DKIM records.

    SRV (Service) Record: Specifies information about services available on a domain, including the hostname, port number, and protocol.

Setting up a DNS Server with CoreDNS:

CoreDNS is a lightweight and flexible DNS server that can be easily integrated with Kubernetes. It supports various DNS features and plugins, making it suitable for dynamic environments like Kubernetes clusters. Setting up a DNS server with CoreDNS involves configuring it to serve DNS records for the cluster's namespaces, services, and pods.

DNS Resolution in Kubernetes:

    Pod DNS Records: By default, Kubernetes does not create DNS records for pods. However, you can enable this feature explicitly. Each pod's IP address is converted into a DNS name by replacing dots with dashes. These DNS records are grouped by namespace and have the type set to "pod."

    Service DNS Records: When a service is created in Kubernetes, a DNS record is automatically created for it. The service name is mapped to its IP address, allowing pods within the cluster to access the service using its name. Service DNS records are grouped by namespace and have the type set to "service."

    DNS Namespace Hierarchy: DNS records for pods and services are organized into a hierarchical namespace structure. Each namespace has its subdomain, and all services within a namespace are grouped under another subdomain. The fully qualified domain name (FQDN) for a service follows the pattern: servicename.namespace.svc.cluster.local.