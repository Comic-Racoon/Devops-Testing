Introduction to Security in Docker:
    Host Environment:
        Docker runs on a host with its own set of processes.
        Processes include OS processes, Docker daemon, SSH server, etc.
    Container Isolation:
        Containers share the host kernel but have their own namespaces.
        Processes within containers are isolated in their own namespace.
        Docker isolates containers using Linux namespaces.

User Security in Docker:
    Default User:
        By default, Docker runs processes within containers as the root user.
        Processes run with root privileges within containers.
    Setting User ID:
        User ID can be set using the user option in the docker run command.
        Specify a new user ID to run the process with.
    User Security in Docker Images:
        User ID can also be defined in the Docker image itself using the USER instruction.
        Build custom images with specific user IDs to enforce user security.

Root User Limitations:
    Root User Privileges:
        The root user within a container doesn't have the same privileges as the root user on the host.
        Docker limits root user capabilities within containers.
    Linux Capabilities:
        Docker uses Linux capabilities to restrict root user privileges.
        Default containers run with a limited set of capabilities.
    Controlling Privileges:
        Use cap add option to add specific capabilities.
        Use cap drop option to drop specific capabilities.
        Use privileged flag to run containers with all privileges enabled.

Security Considerations:
    Running processes as the root user within containers can pose security risks.
    Docker implements security features to mitigate risks and limit root user privileges.
    Understanding user security and capabilities is essential for maintaining container security.

Further Exploration:
    Explore Docker documentation for more details on user security and capabilities.
    Experiment with setting user IDs and manipulating capabilities to understand their effects on container behavior.

