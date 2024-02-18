Understanding Docker Networking Options and Relating to Network Namespaces

    Basic Docker Networking Options:
        None Network:
            Containers not attached to any network.
            Isolated from the outside world and other containers.
        Host Network:
            Containers share the host network.
            No network isolation between host and containers.
            Services within containers accessible on host ports directly.
        Bridge Network:
            Default internal private network created by Docker.
            Each container gets its own IP address on this network.
            Provides network isolation between containers and host.

    Creating and Managing Bridge Network:
        Docker creates an internal private network named "Bridge" (Docker0 on the host).
        Network is managed internally by Docker using techniques similar to network namespaces.
        Containers are attached to this network via virtual interfaces.

    Attaching Containers to Bridge Network:
        Docker creates a network namespace for each container.
        Interfaces within the container's namespace are connected to Docker0 bridge network.
        IP addresses are assigned to container interfaces within the bridge network.

    Port Mapping and Publishing:
        Containers within the bridge network are accessible only within the host.
        Port mapping allows forwarding traffic from host ports to container ports.
        Docker maps host port 8080 to container port 80 using port publishing option.
        External users access the application via the Docker host IP and mapped port.

    Implementation with IP Tables:
        Docker uses IP tables to implement port forwarding for port mapping.
        NAT rules are added to prerouting chain to change destination port from 8080 to 80.
        Additional rules ensure traffic is forwarded to the correct container IP.

Understanding Docker's networking options provides insights into network namespaces and how containers are isolated and connected within Docker environments. The use of internal bridge networks, port mapping, and IP tables for traffic forwarding mirrors concepts discussed in network namespace management.