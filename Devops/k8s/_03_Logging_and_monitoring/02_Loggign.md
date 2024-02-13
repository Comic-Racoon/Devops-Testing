Logging in Docker:
    Run Docker container named event-simulator, generating random events.
    Events streamed to standard output.
    Viewing logs:
        Detached mode (-d): Use docker logs command followed by container id.
        Live log trail: -f option.

Logging in Kubernetes:
    Create pod with same Docker image using pod definition file.
    View logs using kubectl logs command with pod name.
        -f option for live logs.
    Logs specific to container inside pod.

Pods with Multiple Containers:
    Pods can have multiple Docker containers.
    Modify pod definition file to include additional container (e.g., image-processor).
    Specifying container name:
        Use kubectl logs command with pod name.
        If multiple containers, specify container name explicitly.
        Failure to specify name prompts for explicit name.
    Example: kubectl logs pod_name container_name to view relevant log messages.

