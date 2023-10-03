# AWS RDS Overview
* RDS stands for Relational Database Service
* It’s a managed DB service for DB use SQL as a query language.
* It allows you to create databases in the cloud that are managed by AWS
    * Postgres
    * MySQL
    * MariaDB
    * Oracle
    * Microsoft SQL Server
    * Aurora (AWS Proprietary database)

---

# Advantage over using RDS versus deploying DB on EC2
* RDS is a managed service:
    * Automated provisioning, OS patching
    * Continuous backups and restore to specific timestamp (Point in Time Restore)!
    * Monitoring dashboards
    * Read replicas for improved read performance
    * Multi AZ setup for DR (Disaster Recovery)
    * Maintenance windows for upgrades
    * Scaling capability (vertical and horizontal)
    * Storage backed by EBS (gp2 or io1)
* BUT you can’t SSH into your instances

---
# RDS Solution Architecture

<br> [![image](https://www.linkpicture.com/q/RDS-SOLUTION-ARCH.png)](https://www.linkpicture.com/view.php?img=LPic651a565a0ab732070537507)   

---
# RDS Deployments: Read Replicas, Multi-AZ Main Read ReplicaRead Replica
* Read Replicas:
    * Scale the read workload of your DB
    * Can create up to 15 Read Replicas
    * Data is only written to the main DB

---
* Multi-AZ:
    * Failover in case of AZ outage (high availability)
    * Data is only read/written to the main database
    * Can only have 1 other AZ as failover

---
# RDS Deployments: Multi-Region
[![image](https://www.linkpicture.com/q/rds-seployment.png)](https://www.linkpicture.com/view.php?img=LPic651a5a8ef2ef297396263)