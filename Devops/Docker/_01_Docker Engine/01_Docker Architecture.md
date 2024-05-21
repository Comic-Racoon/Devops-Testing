Docke Architecture : 
![alt text](../Assets/Images/Docker%20Architecture.png)

# Docker Architecture and Core Components

## Subtopic 1: Introduction to Docker
- Docker was first released to the public in 2013.

## Subtopic 2: Docker Engine Components
- **Docker Daemon**: Responsible for creating and managing Docker objects such as images, containers, volumes, and networks.
- **REST API**: Interface to manage Docker objects.
- **Docker CLI**: Command line interface for running commands to manage Docker objects.

## Subtopic 3: Managing Containers on a Host
- Initially, Docker used Linux Containers (LXC) to manage containers on Linux.
  - LXC utilized Linux kernel features such as namespaces and cgroups to create isolated environments.
  - Docker provided tools to simplify container management.
- **libcontainer**: Introduced in Docker version 0.9, written in Go, reduced dependency on LXC.
  - Directly interacts with Linux kernel features (namespaces and cgroups).

## Subtopic 4: Open Container Initiative (OCI)
- Formed by Docker, CoreOS, and industry leaders to create open standards for container formats and runtime.
- **Runtime Specification**: Defines the lifecycle of container technology.
- **Image Specification**: Defines container image standards.

## Subtopic 5: Refactoring Docker Architecture
- Before OCI standards, Docker daemon was monolithic.
- Post-OCI, Docker Engine was refactored into smaller components in version 1.11:
  - **runC**: First OCI-based technology, responsible for running containers.
  - **containerd**: Manages runC, uses libcontainer to create containers.
  - **containerd-shim**: Ensures containers run independently of the Docker daemon, handles container states.

## Subtopic 6: Docker Objects
- **Docker Images**: Read-only templates for creating containers. Examples include operating systems and applications.
- **Containers**: Running instances of images, managed using Docker CLI or API.
- **Networks**: Facilitate communication between containers and with the external world.
- **Volumes**: Persist data across container restarts.

## Subtopic 7: Image Registry
- **Docker Hub**: Public registry for sharing images.
- **Private Registry**: Can be set up for organizational use.
- **Docker Trusted Registry (DTR)**: Included with Docker Enterprise Edition.

## Subtopic 8: Docker Command Workflow
- Docker CLI command is converted into a RESTful API request.
- Docker daemon checks if the image is available locally; if not, downloads from the Docker registry.
- **containerd**: Converts image into an OCI-compliant bundle.
- **containerd-shim**: Uses runC to start the container.
- **runC**: Interacts with kernel namespaces and cgroups to create the container.

## Subtopic 9: Installation and Verification
- Docker installation on CentOS and Ubuntu.
- Verify installation with:
  - `docker version` command: Shows client and daemon status.
  - `docker --version` command: Shows CLI version.
  - `docker system info` command: Provides information about Docker host.