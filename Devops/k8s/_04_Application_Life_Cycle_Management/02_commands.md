    Containers and Process Lifecycle:
        Containers run specific tasks or processes.
        Containers exit once the task or process is complete.
        Process running within a container defined by CMD instruction.

    Default Command in Dockerfiles:
        Dockerfile specifies default command (CMD).
        E.g., NGINX uses NGINX command, MySQL uses MySQLD command.
        Ubuntu image uses bash as default command.

    Terminal Interaction and Bash Behavior:
        Bash exits if it doesn't find a terminal.
        Docker run doesn't attach a terminal by default.

    Overriding Default Command:
        Append command to Docker run command to override default.
        Create custom image with new default command.

    Using ENTRYPOINT and CMD Instructions:
        ENTRYPOINT: Specify program to run at container start.
        CMD: Additional default parameters or arguments.
        JSON array format allows for separate command and arguments.

    Combining ENTRYPOINT and CMD:
        ENTRYPOINT + CMD: Default command with optional arguments.
        Parameters passed in Docker run command appended to ENTRYPOINT.
        Default values can be specified in Dockerfile.

    Runtime Entry Point Modification:
        Override ENTRYPOINT at runtime with Docker run command option.
        Example: docker run --entrypoint sleep 2.0 ubuntu-sleeper 10.