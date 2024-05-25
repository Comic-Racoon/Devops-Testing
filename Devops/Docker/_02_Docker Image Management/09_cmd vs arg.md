# Docker Commands, Arguments, and Entry Points

## Introduction
- Explains the behavior of running a Docker container from an image like Ubuntu.
- Highlights that containers are designed for specific tasks and exit once the task is complete.

## CMD Instruction
- Describes how the CMD instruction in Dockerfile specifies the default program to run within the container.
- Examples include Nginx running the Nginx command and MySQL running the MySQLD command.

## Default Command with Ubuntu Image
- Explains that the default command in the Ubuntu image is Bash.
- Bash exits if it doesn't find a terminal, causing the container to exit when run without a specified command.

## Overriding Default Command
- Discusses appending a command to the docker run command to override the default command temporarily.
- Shows an example with `docker run ubuntu sleep 5` to make the container sleep for five seconds.

## Permanent Command Change
- Proposes creating a new image based on the base Ubuntu image with a different default command.
- Demonstrates specifying the command in both shell form and JSON array format.

## Dynamic Command Configuration
- Addresses the need to change the number of seconds the container sleeps.
- Discusses using the entry point instruction to specify the program to run at startup.
- Explains the difference between CMD and entry point in how they handle command line parameters.

## Default Value Configuration
- Suggests using both entry point and command instructions to set a default value if no command is specified.
- Emphasizes the necessity of specifying instructions in JSON format for dynamic configuration.

## Runtime Entry Point Modification
- Describes how to override the entry point during runtime using the entry point option in the docker run command.
- Provides an example of modifying the entry point from "sleep" to "sleep 2.0".

## Conclusion
- Summarizes the lecture content and hints at the next lecture's topic.
