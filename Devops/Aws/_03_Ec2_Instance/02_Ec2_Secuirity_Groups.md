# Introduction to Security Groups
* Security Groups are the fundamental of network security in AWS
* They control how traffic is allowed into or out of our EC2 Instances.
<br>  [![image](https://www.linkpicture.com/q/secuirity_group.png)](https://www.linkpicture.com/view.php?img=LPic64f0e98a61537941484374)
* Security groups only contain **allow** rules
* Security groups rules can reference by IP or by security 

---

# Security Groups Deeper Dive
* Security groups are acting as a **“firewall”** on EC2 instances
* They regulate:
  * Access to Ports
  * Authorised IP ranges – IPv4 and IPv6
  * Control of inbound network (from other to the instance)
  * Control of outbound network (from the instance to other)

---

# Security Groups Good to know
* Can be attached to multiple instances
* Locked down to a region / VPC combination
* Does live “outside” the EC2 – if traffic is blocked the EC2 instance won’t see it
* ***It’s good to maintain one separate security group for SSH access*** 
* If your application is not accessible (time out), then it’s a security group issue
* If your application gives a “connection refused“ error, then it’s an application error or it’s not launched
* All inbound traffic is blocked by default
* All outbound traffic is authorised by default

---

# Classic Ports to know
* 22 = SSH (Secure Shell) - log into a Linux instance
* 21 = FTP (File Transfer Protocol) – upload files into a file share
* 22 = SFTP (Secure File Transfer Protocol) – upload files using SSH
* 80 = HTTP – access unsecured websites
* 443 = HTTPS – access secured websites
* 3389 = RDP (Remote Desktop Protocol) – log into a Windows instance

---

# How to SSH into your EC2 Instance

---

# EC2 Instances Purchasing Options
* **On-Demand Instances** – short workload, predictable pricing, pay by second
  * Pay for what you use:
    * Linux or Windows - billing per second, after the first minute
    * All other operating systems - billing per hour
  * Has the highest cost but no upfront payment
  * No long-term commitment
  * Recommended for short-term and un-interrupted workloads, where you can't predict how the application will behave
* **Reserved** (1 & 3 years)
* **Reserved Instances** – long workloads
  * Up to 72% discount compared to On-demand
  * You reserve a specific instance attributes (Instance Type, Region, Tenancy, OS)
  * Reservation Period – 1 year (+discount) or 3 years (+++discount)
  * Payment Options – No Upfront (+), Partial Upfront (++), All Upfront (+++)
  * Reserved Instance’s Scope – Regional or Zonal (reserve capacity in an AZ)
  * Recommended for steady-state usage applications (think database)
  * You can buy and sell in the Reserved Instance Marketplace
* **Convertible Reserved Instances** – long workloads with flexible instances
  * Can change the EC2 instance type,
  * Saved up to 66% w.r.t on demand 
* **Savings Plans** (1 & 3 years) –commitment to an amount of usage, long workload
  * Get a discount based on long-term usage (up to 72% - same as RIs)
  * Commit to a certain type of usage ($10/hour for 1 or 3 years)
  * Usage beyond EC2 Savings Plans is billed at the On-Demand price
  * Locked to a specific instance family & AWS region (e.g., M5 in us-east-1)
  * Flexible across:
    * Instance Size (e.g., m5.xlarge, m5.2xlarge)
    * OS (e.g., Linux, Windows)
    * Tenancy (Host, Dedicated, Default)
* **Spot Instances** – short workloads, cheap, can lose instances (less reliable)
  * Can get a discount of up to 90% compared to On-demand
  * Instances that you can “lose” at any point of time if your max price is less than the current spot price
  * The MOST cost-efficient instances in AWS
  * Useful for workloads that are resilient to failure
    * Batch jobs
    * Data analysis
    * Image processing
    * Any distributed workloads
    * Workloads with a flexible start and end time
  * Not suitable for critical jobs or databases
* **Dedicated Hosts** – book an entire physical server, control instance placement
  * A physical server with EC2 instance capacity fully dedicated to your use
  * Allows you address compliance requirements and use your existing server-
  bound software licenses (per-socket, per-core, pe—VM software licenses)
  * Purchasing Options:
  * On-demand – pay per second for active Dedicated Host
  * Reserved - 1 or 3 years (No Upfront, Partial Upfront, All Upfront)
  * The most expensive option
  * Useful for software that have complicated licensing model (BYOL – Bring Your
  Own License)
  * Or for companies that have strong regulatory or compliance needs
* **Dedicated Instances** – no other customers will share your hardware
  * Instances run on hardware that’s dedicated to you
  * May share hardware with other instances in same account
  * No control over instance placement (can move hardware after Stop / Start)
* **Capacity Reservations** – reserve capacity in a specific AZ for any
  * Reserve On-Demand instances capacity in a specific AZ(availability zone) for any
  duration
  * You always have access to EC2 capacity when you need it
  * No time commitment (create/cancel anytime), no billing discounts
  * Combine with Regional Reserved Instances and Savings Plans to benefit
  from billing discounts
  * You’re charged at On-Demand rate whether you run instances or not
  * Suitable for short-term, uninterrupted workloads that needs to be in a
  specific AZ

---

# EC2 Section – Summary
* EC2 Instance: AMI (OS) + Instance Size (CPU + RAM) + Storage + security groups + EC2 User Data
* Security Groups: Firewall attached to the EC2 instance
* EC2 User Data: Script launched at the first start of an instance
* SSH: start a terminal into our EC2 Instances (port 22)
* EC2 Instance Role: link to IAM roles
* Purchasing Options: On-Demand, Spot, Reserved (Standard + Convertible + Scheduled), Dedicated Host, Dedicated Instance