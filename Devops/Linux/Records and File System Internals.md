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
