# Comprehensive Unix/Linux Command Guide

### Basic Information and Commands

- **Name and UID of the Administrator User**
  - Typically, the administrator's username is `root` and the UID is `0`.

- **Listing All Files, Including Hidden Ones**
  - Command: `ls -a`

- **Removing a Directory and Its Contents**
  - Command: `rm -rf /path/to/directory`

- **Showing Free/Used Memory**
  - Command: `free`
  - Yes, Linux does report free memory in its output.

- **Search for a String in Files Recursively**
  - Command: `grep -r "my konfu is the best" /path/to/directory`

- **Connecting to a Remote Server with SSH**
  - Command: `ssh username@hostname`

- **Listing All Environment Variables**
  - Command: `env` or `printenv`

- **Handling 'command not found' for ifconfig**
  - Possible Issue: `net-tools` not installed or `ifconfig` not in PATH.

- **Effect of Typing TAB-TAB**
  - Triggers command and file name auto-completion in most shells.

- **Checking Disk Space Usage**
  - Command: `df -h`

- **DNS Record Checking Commands**
  - Commands: `dig`, `nslookup`

### File Permissions and User Management

- **Changing File Ownership and Permissions**
  - Ownership: `chown user:group filename`
  - Permissions: `chmod permissions filename`

- **What Does `chmod +x FILENAME` Do?**
  - Adds execute permission for the file.

- **Understanding Permission 0750 on Files and Directories**
  - On a file: Owner can read, execute; Group can execute; Others have no permission.
  - On a directory: Owner can read, write, execute; Group can read, execute; Others have no permission.

- **Adding a New System User Without Login Permissions**
  - Command: `useradd -M -s /sbin/nologin username`

- **Adding/Removing a Group from a User**
  - Add: `usermod -aG groupname username`
  - Remove: Use `gpasswd -d username groupname` or manually edit `/etc/group`.

- **What is a Bash Alias?**
  - A shorthand for a command or a series of commands, defined typically in `.bashrc`.

- **Setting the Mail Address of Root/A User**
  - Edit `/etc/aliases` and run `newaliases`.

### Control Commands and System Files

- **What Does CTRL-C, CTRL-D, and CTRL-Z Do?**
  - CTRL-C: Terminates the current command.
  - CTRL-D: Sends an EOF marker, which can exit the current shell.
  - CTRL-Z: Suspends the current foreground process.

- **What is in /etc/services?**
  - A file mapping service names to port numbers and protocols.

- **Redirecting STDOUT and STDERR**
  - Syntax: `command > /dev/null 2>&1`

### Advanced Concepts and Comparisons

- **Difference Between UNIX and Linux**
  - UNIX is proprietary and has multiple versions. Linux is open-source and UNIX-like.

- **Difference Between Telnet and SSH**
  - Telnet is insecure as it transmits data in clear text. SSH encrypts the communication.

- **Understanding Load Averages**
  - Indicates the average number of active tasks over 1, 5, and 15 minutes. Viewable via `uptime` or `top`.

- **Invalid `ls` Option Example**
  - Most single lowercase letters are valid options; an example of an invalid option might be `ls -y`.

- **What is a Linux Kernel Module?**
  - A piece of code that can be loaded into the Linux kernel to extend its capabilities, typically used for device drivers.

- **Booting into Single User Mode to Troubleshoot**
  - Typically involves editing boot parameters to include `single` or `1`.

- **Troubleshooting a 404 Error on a Web Application**
  - Check file paths, permissions, server configurations, and relevant logs.

### Network Protocols

- **What is ICMP Protocol and Its Use?**
  - Used for sending error messages and operational info; "ping" uses ICMP to test connectivity.
