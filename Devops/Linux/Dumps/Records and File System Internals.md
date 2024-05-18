DNS Records:

- **What is an A record?**
  - **Answer:** An A record (Address record) maps a domain name to an IPv4 address. It is used to point a domain or subdomain to a specific IP address.

- **Explain the purpose of an NS record.**
  - **Answer:** An NS record (Name Server record) specifies which DNS server is authoritative for a domain. It delegates the responsibility of resolving domain names within a zone to designated name servers.

- **What is a PTR record used for?**
  - **Answer:** A PTR record (Pointer record) maps an IP address to a domain name. It is primarily used in reverse DNS lookups to determine the domain associated with a given IP address.

- **Describe the function of a CNAME record.**
  - **Answer:** A CNAME record (Canonical Name record) creates an alias for a domain name. It allows multiple domain names to resolve to the same IP address and simplifies domain management by pointing one domain to another.

- **What does an MX record do?**
  - **Answer:** An MX record (Mail Exchange record) specifies the mail server responsible for receiving email messages on behalf of a domain. It identifies the domain's mail exchanger(s) and their priority for handling incoming mail.

File System Internals:

- **Differentiate between hard links and soft links (symbolic links).**
  - **Answer:** Hard links are directory entries pointing to the same inode (data structure representing a file) as the original file. Changes to the file content affect all hard links. Soft links, also known as symbolic links, are pointers to the filename of the target file. They reference the target file by its path and filename, rather than its inode. Soft links can span across file systems and point to directories.

- **What is an inode?**
  - **Answer:** An inode (index node) is a data structure used by a file system to store metadata about a file or directory, such as its permissions, ownership, size, and location on disk. Each file and directory on a Unix-like file system is associated with an inode.

- **Explain how file systems handle hard links and their impact on file management.**
  - **Answer:** When a hard link is created, a new directory entry is added to the file system pointing to the same inode as the original file. Both the original file and the hard link share the same inode, meaning they reference the same data blocks on disk. Changes made to one file are reflected in the other since they both point to the same data. Hard links can be used to create multiple directory entries for the same file, providing efficient file management and saving disk space.

- **What are the advantages and disadvantages of using symbolic links?**
  - **Answer:** Symbolic links provide flexibility by allowing files to be referenced by multiple paths. They can span across file systems and point to directories. However, symbolic links require additional disk space to store the path information, and if the target file is moved or deleted, the symbolic link becomes invalid. Additionally, symbolic links may introduce security risks if they point to sensitive files or directories.

---

# DNS Records

DNS (Domain Name System) records are used to map domain names to various types of data, such as IP addresses. Here are some common DNS record types:

## A Record (Address Record)
- **Purpose**: Maps a domain name to an IPv4 address.
- **Example**: `example.com -> 93.184.216.34`
- **Usage**: When a user types `example.com` in a browser, the A record tells the browser which IP address to connect to.

## NS Record (Name Server Record)
- **Purpose**: Specifies the authoritative name servers for a domain.
- **Example**: `example.com -> ns1.nameserver.com`
- **Usage**: Directs queries to the appropriate name servers that hold the DNS records for the domain.

## PTR Record (Pointer Record)
- **Purpose**: Maps an IP address to a domain name (reverse DNS lookup).
- **Example**: `93.184.216.34 -> example.com`
- **Usage**: Used mainly for verifying the identity of an IP address, such as in email server configurations to prevent spam.

## CNAME Record (Canonical Name Record)
- **Purpose**: Maps an alias name to a true (canonical) domain name.
- **Example**: `www.example.com -> example.com`
- **Usage**: Useful for pointing multiple domain names to the same site and managing subdomains more easily.

## MX Record (Mail Exchange Record)
- **Purpose**: Specifies the mail servers responsible for receiving email on behalf of a domain.
- **Example**: `example.com -> mail.example.com`
- **Usage**: Directs email to the appropriate mail servers for a domain, with priority levels to indicate backup servers.

# File System Internals

File systems manage how data is stored and retrieved on disk. Here are some key components:

## Inodes
- **Definition**: Data structures that store information about files and directories, except their name or actual data.
- **Contents**: Include metadata such as file size, permissions, ownership, timestamps, and pointers to data blocks.
- **Usage**: Each file or directory has an inode, which the file system uses to access the file’s data and metadata.

## Hard Links
- **Definition**: Directory entries that associate a name with an inode.
- **Characteristics**: Multiple hard links can reference the same inode, meaning multiple filenames point to the same file data.
- **Usage**: If the original file is deleted, the data remains accessible as long as at least one hard link exists.

## Soft Links (Symbolic Links)
- **Definition**: Files that contain a path to another file or directory.
- **Characteristics**: Unlike hard links, soft links are independent of the inode and can span different file systems.
- **Usage**: Used to create shortcuts or references to files/directories. If the target is deleted, the soft link becomes a broken link.

# Examples

## Inodes
- **Explanation**: When you create a file, the file system allocates an inode to it. The inode number is a unique identifier within the file system.
- **Command**: `ls -i` lists files along with their inode numbers.

## Hard Links
- **Command**: `ln file1 file2` creates a hard link named `file2` pointing to the same inode as `file1`.
- **Command**: `ls -l` shows the link count for each file.

## Soft Links
- **Command**: `ln -s /path/to/original /path/to/link` creates a symbolic link.
- **Command**: `ls -l` shows links with `->` indicating the target file.
