# Docker CLI Basics and Container Operations

## Introduction to Docker CLI
- **Docker Command**: `docker`
- **Syntax**: `docker <object> <operation> [options]`
  - Example: `docker image ls`

## Managing Docker Objects
### Docker Image Commands
- **List Images**: `docker image ls`
- **Build Image**: `docker image build`

### Docker Container Commands
- **Run Container**: `docker container run`
- **Create Container**: `docker container create`
- **Start Container**: `docker container start`
- **Attach to Running Container**: `docker container attach`
- **Stop Container**: `docker container stop`
- **Kill Container**: `docker container kill`

## Docker Command Syntax
- **New Syntax**: Groups commands by object
  - Example: `docker container run`
- **Old Syntax**: Commands without grouping
  - Example: `docker run`
- Both syntaxes are valid and functional.

## Creating and Managing Containers
### Create a Docker Container
- **Command**: `docker container create <image>`
  - Example: `docker container create httpd`
- **Behavior**: Pulls image from Docker Hub if not available locally.
- **Output**: 64-character unique container ID (first 12 characters are used as a shorter ID).

### Docker Storage Directory
- **Default Path**: `/var/lib/docker`
- **Structure**: Separate directories for each Docker object (e.g., containers, images).

### Listing Containers
- **List Running Containers**: `docker container ls`
- **List All Containers**: `docker container ls -a`
- **Useful Options**:
  - `-l`: Shows last created container.
  - `-q`: Displays short container IDs for running containers.
  - `-aq`: Displays short container IDs for all containers.

### Starting and Running Containers
- **Start Created Container**: `docker container start <container_id|name>`
- **Combined Create and Start**: `docker container run <image>`
  - Example: `docker container run ubuntu`

### Understanding Container Lifecycle
- **Process-Based Lifecycle**: Containers run a specific task/process.
  - Example: Running `docker container run ubuntu` exits immediately because no process is specified.
- **Interactive Mode**: Use `-i` (interactive) and `-t` (terminal) flags to run a container with an interactive shell.
  - Example: `docker container run -it ubuntu`

### Naming Containers
- **Custom Names**: Use `--name` flag to assign a custom name.
  - Example: `docker container run --name mycontainer httpd`
- **Renaming Containers**: Use `docker container rename <old_name> <new_name>`
  - Example: `docker container rename oldname newname`

### Running Containers in Detached Mode
- **Detached Mode**: Use `-d` flag to run containers in the background.
  - Example: `docker container run -d httpd`
- **Re-attaching to Containers**: Use `docker container attach <container_id|name>`
  - Example: `docker container attach 11cb`

## Conclusion
- **Syntax Reminder**: Always specify Docker-related options before the image name.
- **Stopping Containers**: Running `exit` inside the container shell stops the container.

---
# Advanced Docker Container Commands

## Recap
- **Exit Behavior**: Typing `exit` inside a container shell stops the container.
- **Listing Containers**: Use `docker container ls` to see container states.

## Detaching from a Running Container
### Creating an Interactive Ubuntu Container
- **Command**: `docker container run -it ubuntu`

### Detaching Without Exiting
- **Escape Sequence**: `CTRL + P + Q`
  - Detaches from the container while keeping it running in the background.

## Executing Commands in a Running Container
### Using `docker container exec`
- **Purpose**: Run commands inside a running container.
- **Example**: Print the hostname of the container.
  - Command: `docker container exec <container_id|name> hostname`
  - Output: Prints the unique ID set as the container's hostname.

### Accessing the Container Shell
- **Command**: `docker container exec -it <container_id|name> /bin/bash`
  - Enters the shell inside the running container.
  - Allows running commands and inspecting output as if on a regular host.

### Use Cases
- **Troubleshooting**: Inspect logs or configuration files inside a running container.
- **Maintenance**: Execute maintenance tasks or updates without stopping the container.

## Attaching to a Running Container
### Using `docker container attach`
- **Command**: `docker container attach <container_id|name>`
  - Re-attaches to the terminal of the running container.
  - Useful for continuing work from a previously detached state.

## Summary
- **Escape Sequence**: Use `CTRL + P + Q` to detach without stopping.
- **Executing Commands**: Use `docker container exec` for running commands inside a running container.
- **Re-attaching**: Use `docker container attach` to re-attach to the terminal of a running container.

# Inspecting Docker Containers

## Overview
- **Basic Container Details**: Use `docker container ls` to obtain basic details like names and IDs.
- **Detailed Container Information**: Use `docker container inspect` for comprehensive details.

## Inspecting a Specific Container
### Using `docker container inspect`
- **Command**: `docker container inspect <container_id|name>`
- **Output**: Returns container details in JSON format.
  - **Includes**: State, mounts, configuration data, network settings, etc.

## Monitoring Resource Usage
### Using `docker container stats`
- **Command**: `docker container stats`
- **Output**: Displays real-time resource consumption for all running containers.
  - **Metrics**: CPU, memory, network, and disk usage.

### Identifying High Resource Consumption
- **Example**: If a container uses 50% of CPU, investigate further.

## Examining Container Processes
### Using `docker container top`
- **Command**: `docker container top <container_id|name>`
- **Output**: Lists processes and their IDs within the container.
  - **Use Case**: Identifying processes causing high resource usage.
  - **Example**: Identifying `stress` process with PID 17001.

## Viewing Container Logs
### Using `docker container logs`
- **Command**: `docker container logs <container_id|name>`
- **Output**: Displays logs from the container's STDOUT.
- **Streaming Logs**: Use `-f` option for live log streaming.
  - **Command**: `docker container logs -f <container_id|name>`

## Monitoring Docker Events
### Using `docker system events`
- **Command**: `docker system events`
- **Output**: Real-time events from the Docker server.
  - **Includes**: All changes made to containers or networks.
  - **Use Case**: Monitoring events like starting or stopping of containers.
  - **Example**: Events related to a container named `webapp`.

## Conclusion
- **Inspect Containers**: Use `docker container inspect` for detailed information.
- **Monitor Resources**: Use `docker container stats` to track resource usage.
- **Investigate Processes**: Use `docker container top` to identify problematic processes.
- **View Logs**: Use `docker container logs` for log output and `-f` for live streaming.
- **Track Events**: Use `docker system events` for real-time server events.

That's it for this lecture. I will see you in the next one.

