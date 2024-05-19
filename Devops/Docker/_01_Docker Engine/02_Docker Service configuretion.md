# Docker Daemon Configuration

## Managing Docker Service with systemctl
### Starting Docker Service
- Use `systemctl start` command to start Docker service.

### Checking Docker Service Status
- Use `systemctl status` command to check the status of Docker service.

### Stopping Docker Service
- Use `systemctl stop` command to stop Docker service.
- Note: Commands might differ based on operating system and Docker installation method.

### Linux and systemctl Configuration
- Docker configured as a service to run daemon in the background.
- Automatically starts on system boot.
- Use `dockerd` command to run Docker daemon in the foreground for troubleshooting.

## Running Docker Daemon
### Running in Foreground
- Useful for troubleshooting and debugging.
- Use `dockerd` command to print daemon logs on screen.
- Add `--debug` flag for detailed output.

### Unix Socket Communication
- Docker daemon listens on internal Unix socket at `/var/run/docker.sock`.
- Unix socket used for inter-process communication (IPC).
- Docker CLI interacts with Docker daemon through this socket.

## External Connectivity to Docker Daemon
### Setting up TCP Interface
- Docker daemon not accessible outside host by default.
- To access from another host, make Docker daemon listen on a TCP interface.
- Example: Use `--host` option with `dockerd` command.

### Example Configuration
- Interface: `192.168.1.10`
- Port: `2375`
- Docker daemon now accessible via `192.168.1.10:2375`.

### Configuring Docker CLI on Remote Host
- Set `DOCKER_HOST` environment variable to target Docker host IP.
- Example: `export DOCKER_HOST=tcp://192.168.1.10:2375`

## Security Considerations
### Risks of External Access
- Default setting allows unencrypted, unauthenticated access.
- Public-facing hosts are vulnerable to attacks (e.g., unauthorized container deployment).

### Enabling Encryption
- Create TLS certificates.
- Enable TLS by setting `--tls=true` and providing certificate paths.
- Encrypted traffic standard port: `2376`.

### Using Configuration File
- Configuration options can be specified in `/etc/docker/daemon.json`.
- Format: JSON key-value pairs.
- Example for multiple listeners:

```json
{
  "hosts": ["unix:///var/run/docker.sock", "tcp://192.168.1.10:2376"],
  "tls": true,
  "tlsverify": true,
  "tlscacert": "/path/to/ca.pem",
  "tlscert": "/path/to/server-cert.pem",
  "tlskey": "/path/to/server-key.pem"
}
```
```
Conflict Resolution
Handling Conflicting Options

    Configuration file values can conflict with command line flags.
    Example conflict: debug flag set differently in command line and daemon.json.
    Conflict causes Docker service to fail.
    Ensure consistency between configuration file and command line options.

