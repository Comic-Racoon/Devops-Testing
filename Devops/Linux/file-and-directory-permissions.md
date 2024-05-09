### https://www.linode.com/docs/guides/modify-file-permissions-with-chmod/

# Understanding and Using the `chmod` Command

## Overview
The `chmod` command in Unix is essential for changing file permissions, allowing systems administrators to control access to files on a system among multiple users. This guide provides an understanding of Unix file permissions and practical applications of the `chmod` command.

### Unix File Permissions
Unix-like systems attribute three main types of permissions to files and directories:
- **Read (r)**
- **Write (w)**
- **Execute (x)**

These permissions can be applied to three different classes:
- **Owner**
- **Group**
- **Others**

To view permissions, use the command:
```bash
ls -lha

The output displays permissions in a symbolic notation showing the access level for the owner, group, and others.

**Key chmod Commands**

- Basic Command Structure: `chmod [options] mode[,mode] file1 [file2 ...]`
- Adding Permissions: `chmod g+w filename` (Adds write permission to the group)
- Removing Permissions: `chmod o-r filename` (Removes read permission from others)
- Using Numeric (Octal) Notation: `chmod 755 filename` (Sets rwx for owner, rx for group, and rx for others)

**Common Permissions and Examples**

- `600` (Owner can read and write; no access for others): `chmod 600 filename`
- `644` (Owner can read and write; others can only read): `chmod 644 filename`
- `755` (Owner can read, write, and execute; others can only read and execute): `chmod 755 filename`
- `777` (Everyone can read, write, and execute - not recommended for sensitive files): `chmod 777 filename`

**Special Uses**

- Making Files Executable: `chmod +x filename`
- Recursive Permission Change: `chmod -R mode directory` (Applies mode to all files and directories within the specified directory recursively)

**Directory Permissions**

Permissions on directories have specific meanings:

- Read (`r`): List the contents of the directory.
- Write (`w`): Create or delete files within the directory.
- Execute (`x`): Access files within the directory.

**Restoring Default Permissions**

Reset to safe defaults if permissions are overly permissive:

- Files: `chmod 644 filename` (Read/write for owner, read for others)
- Executable Files: `chmod 755 filename` (Read/write/execute for owner, read/execute for others)
