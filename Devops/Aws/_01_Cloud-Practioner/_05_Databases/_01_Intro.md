# Databases Intro
* Storing data on disk (EFS, EBS, EC2 Instance Store, S3) can have its limits
* Sometimes, you want to store data in a database…
* You can structure the data
* You build indexes to efficiently query / search through the data
* You define relationships between your datasets
* Databases are optimized for a purpose and come with different features, shapes and constraints

---

# Relational Databases
* Looks just like Excel spreadsheets, with links between them!
* Can use the SQL language to perform queries / lookups

---

# NoSQL Databases
* NoSQL = non-SQL = non relational databases
* NoSQL databases are purpose built for specific data models and have flexible schemas for building modern applications.
* Benefits:
    * Flexibility: easy to evolve data model
    * Scalability: designed to scale-out by using distributed clusters
    * High-performance: optimized for a specific data model
    * Highly functional: types optimized for the data model
* Examples: Key-value, document, graph, in-memory, search databases

---

# NoSQL data example: JSON
* JSON = JavaScript Object Notation
* JSON is a common form of data that fits into a NoSQL model
* Data can be nested
* Fields can change over time
* Support for new types: arrays, etc

---

# Databases & Shared Responsibility on AWS
* AWS offers use to manage different databases
* Benefits include:
    * Quick Provisioning, High Availability, Vertical and Horizontal Scaling
    * Automated Backup & Restore, Operations, Upgrades
    * Operating System Patching is handled by AWS
    * Monitoring, alerting
* Note: many databases technologies could be run on EC2, but you must 
handle yourself the resiliency, backup, patching, high availability, fault
tolerance, scaling…

---