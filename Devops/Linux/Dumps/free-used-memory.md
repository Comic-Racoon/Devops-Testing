# Note: Memory Information Commands Explanation

This document provides explanations for various commands used in Linux to check memory usage, including how to redirect their outputs to a file named `memory_info.txt`.

## Command Details and Usage

### `free`
- **Purpose**: Displays the total amount of free and used physical and swap memory in the system, as well as the buffers used by the kernel.
- **Command**: `free > memory_info.txt`
- **Note**: Using `>` will overwrite the existing contents of `memory_info.txt`. Use `>>` to append to the file instead.

### `top`
- **Purpose**: Provides a real-time view of the running system. Shows system summary information and a list of processes managed by the kernel.
- **Options**:
  - `-n 1`: Updates just once.
  - `-b`: Batch mode for better compatibility with redirection.
- **Command**: `top -n 1 -b > memory_info.txt`

### `vmstat`
- **Purpose**: Reports on processes, memory, paging, block IO, traps, disks, and CPU activity.
- **Command**: `vmstat > memory_info.txt`

### `ps aux`
- **Purpose**: Shows detailed information about all running processes, including their memory and CPU usage.
- **Command**: `ps aux > memory_info.txt`

### `cat /proc/meminfo`
- **Purpose**: Provides detailed information on the system's memory usage from the `/proc/meminfo` file.
- **Command**: `cat /proc/meminfo > memory_info.txt`

### `sar`
- **Purpose**: Collects, reports, or saves system activity information.
- **Note**: Ensure `sar` is installed (part of `sysstat` package). There may be a typo in the command; it should be `sar`, not `sarsar`.
- **Command**: `sar > memory_info.txt`

## Conclusion

These commands are crucial for system monitoring and diagnostics in a Linux environment. For continuous documentation without overwriting each previous output, use the append operator (`>>`), like so:
