# Troubleshooting Docker Daemon Issues

## Connection Errors

- **Check Docker Host Configuration**:
  - Ensure correct IP address and port information.
- **Set Docker Host Environment Variable**:
  - Use `DOCKER_HOST` environment variable for remote access.
  - Port 2375 for unencrypted traffic, 2376 for encrypted traffic.

## Checking Docker Service Status

1. **Access Docker Host**:
   - Access the Docker host where the service is running.
2. **Check Docker Service Status**:
   - Use `systemctl status docker` command.
   - Ensure service is active and running.
3. **Inspect Service Logs**:
   - Use `journalctl` to view Docker service logs.
   - Look for error messages or warnings.

## Reviewing Docker Daemon Configuration

- **Inspect Daemon Configuration**:
  - Check `/etc/docker/daemon.json` for correct configurations.
  - Enable debug flag for additional logging if needed.

## Disk Space Issues

- **Check Disk Space**:
  - Verify disk space in `/var/lib/docker` directory.
- **Delete Unused Containers/Images**:
  - Use `docker container prune` and `docker image prune` commands.

## System Information

- **Gather System Info**:
  - Use `docker system info` command.
  - Monitor real-time events with `docker system events`.

By following these troubleshooting steps, you can effectively diagnose and resolve issues with the Docker daemon. Always ensure that Docker configurations are set correctly and monitor system resources to prevent future issues.
