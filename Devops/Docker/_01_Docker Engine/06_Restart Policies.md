# Docker Container Management: Restart Policies and Live Restore

## Understanding Docker Restart Policies

Docker containers can stop for various reasons, and Docker provides several options to control how containers should restart. Understanding these options helps in ensuring that services remain available even if the container encounters issues.

### Reasons for Container Stoppage

- **Successful Completion**: Containers may stop when the task they were executing completes successfully. For instance, a container performing a mathematical calculation may stop when the calculation finishes, resulting in an exit code of zero.
- **Failure**: Containers can also stop due to failures, such as encountering errors in the application or incorrect parameters. In such cases, the container exits with a non-zero exit code.
- **Manual Stoppage**: Administrators can manually stop containers using the `docker container stop` command, which sends a SIGTERM signal followed by a SIGKILL signal to force termination.

### Configuring Restart Policies

- **Using the `--restart` Option**: Docker provides the `--restart` option to configure automatic container restarts.
  - **Default Setting (`no`)**: Containers are never automatically restarted.
  - **`on-failure`**: Restarts the container only when it fails, determined by a non-zero exit code.
  - **`always`**: Restarts the container regardless of the exit status (success or failure) or manual stoppage.
  - **`unless-stopped`**: Restarts the container unless it was manually stopped by an administrator.

### Considerations for Manual Stoppage

- **Delayed Restart**: Containers set to restart `always` do not immediately restart when manually stopped. They restart only when the Docker daemon restarts.
- **Administrator Intervention**: Automatic restart policies should consider the reasons for manual stoppage, as administrators may stop containers intentionally.

### Initial Startup Considerations

- **Successful Startup Requirement**: Restart policies apply only if the container starts successfully in the first place and remains up for at least 10 seconds. This prevents containers from entering a restart loop if they fail to start initially.

## Implementing Live Restore

When the Docker daemon stops, it typically takes down all running containers. However, administrators can configure the Docker engine to keep containers running even when the daemon is stopped or during planned outages using a feature called live restore.

### Configuring Live Restore

- **Live Restore Option**: Live restore can be enabled by adding a `live-restore` property with a value of `true` to the Docker daemon configuration file (`/etc/docker/daemon.json`).
- **Daemon Restart**: After updating the configuration, restart the Docker service to apply the changes.

### Benefits of Live Restore

- **Continuity of Service**: Live restore ensures that containers remain running even when the Docker daemon stops, reducing downtime and ensuring continuous availability of services.

