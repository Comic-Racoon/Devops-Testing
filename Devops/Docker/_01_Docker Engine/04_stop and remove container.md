# Basic Linux Commands and Docker Container Management

## Managing Processes in Linux
### Sending Signals to Processes
- **Pause a Process**: 
  - Command: `kill -SIGSTOP <process_id>`
  - Example: `kill -SIGSTOP 11663`
  - **Alternative**: Use `pgrep` to find the process ID and send the signal.
    - Example: `kill -SIGSTOP $(pgrep httpd)`

- **Resume a Process**:
  - Command: `kill -SIGCONT <process_id>`
  - Example: `kill -SIGCONT 11663`
  - **Alternative**: `kill -SIGCONT $(pgrep httpd)`

- **Terminate a Process Politely**:
  - Command: `kill -SIGTERM <process_id>`
  - Example: `kill -SIGTERM 11663`

- **Forcefully Kill a Process**:
  - Command: `kill -SIGKILL <process_id>`
  - Example: `kill -SIGKILL 11663`

## Docker Container Commands
### Running a Web Server in Docker
- **Command**: `docker container run --name web httpd`

### Pausing and Unpausing Containers
- **Pause a Container**:
  - Command: `docker container pause <container_name>`
  - Example: `docker container pause web`

- **Unpause a Container**:
  - Command: `docker container unpause <container_name>`
  - Example: `docker container unpause web`

### Stopping and Removing Containers
- **Stop a Container**:
  - Command: `docker container stop <container_name>`
  - Example: `docker container stop web`
  - **Details**: Docker sends SIGTERM followed by SIGKILL after a grace period.

- **Remove a Stopped Container**:
  - Command: `docker container rm <container_name>`
  - Example: `docker container rm web`
  - **Error**: Cannot remove a running container.

### Sending Signals to Containers
- **Sending Specific Signals**:
  - Command: `docker container kill --signal <signal_name> <container_name>`
  - Example: `docker container kill --signal SIGTERM web`

### Removing Containers Efficiently
- **Stop All Running Containers**:
  - Command: `docker container stop $(docker container ls -q)`

- **Remove All Containers**:
  - Command: `docker container rm $(docker container ls -aq)`

- **Prune Stopped Containers**:
  - Command: `docker container prune`
  - **Output**: Deletes all stopped containers and reclaims space.

### Automatic Removal of Containers
- **Auto-Remove After Execution**:
  - Command: `docker container run --rm <image_name>`
  - Example: `docker container run --rm ubuntu`

## File Structure and Cleanup
### Docker Directory Structure
- **Location**: `/var/lib/docker`
  - **Containers Directory**: Stores individual container directories.

- **Cleanup**:
  - **Stopping a Container**: Keeps directory structure intact.
  - **Removing a Container**: Deletes directory and frees space.

## Conclusion
- **Signals**: Use `kill` with appropriate signals for process management.
- **Docker Commands**: Utilize `docker container` commands for managing container lifecycle and resources.
- **Efficiency**: Use combined commands and prune options for efficient management.
- **Automatic Cleanup**: Leverage `--rm` option for transient containers.

That's it for this lecture. I will see you in the next one.
