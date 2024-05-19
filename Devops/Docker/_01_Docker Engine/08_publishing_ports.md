# Docker Port Mapping

## Introduction to Port Mapping in Docker

Port mapping, also known as port publishing, in Docker allows for the mapping of ports between the Docker container and the host system. Understanding port mapping is essential for enabling communication with Dockerized applications.

### Accessing Dockerized Applications

When a web application runs within a Docker container, users need a way to access it. This is achieved by mapping ports between the container and the host.

### Mapping Ports

- **Internal Docker IP**: Each Docker container is assigned an internal IP address. Accessing the application via this IP is restricted to the Docker host.
- **Host IP**: By mapping container ports to host ports, users can access the application using the host's IP address.
  - Example: Mapping port 5000 of the container to port 80 on the host (`-p 80:5000`) allows access via `http://192.168.1.5:80`.

### Multiple Instances and Networks

- **Multiple Instances**: You can run multiple instances of applications, each mapped to different ports on the Docker host.
- **Network Limitations**: You can restrict access to specific networks or interfaces by specifying the IP address during port mapping.

## Underlying Mechanisms

Docker relies on Linux kernel's IP tables rules for port mapping. These rules dictate how traffic is routed between container and host ports.

- **IP Tables**: A tool for managing packet filtering rules in the Linux kernel firewall.
- **Docker Chains**: Docker creates its own IP tables chains (`Docker` and `Docker-user`) to manage port mappings.

### Viewing IP Tables Rules

To view the IP tables rules created by Docker for port mapping, you can use the following command:

```bash
iptables -L -n --line-numbers | grep DOCKER
