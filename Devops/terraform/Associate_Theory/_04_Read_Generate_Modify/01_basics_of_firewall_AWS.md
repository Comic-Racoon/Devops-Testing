# Basics of Firewall

## Introduction
- **Definition of Ports:**
  - Ports act as endpoints of communication to identify applications or processes in an operating system.
  - They are essential for communication between servers and clients.
- **Examples of Port Usage:**
  - Port 22: Used for SSH (Secure Shell)
  - Port 80: Used for HTTP (Hypertext Transfer Protocol)

## Port Configuration on Servers
- **Ports and Associated Software:**
  - SSH software binds to port 22.
  - HTTP software (e.g., Apache, NGINX) binds to port 80.
- **Verifying Open Ports:**
  - Using `netstat -ntlp` command to view open ports.
  - Example: Port 22 for SSH, Port 80 for NGINX.

## Firewall Basics
- **Definition and Purpose:**
  - Firewall is a network security system to control incoming and outgoing network traffic.
  - Controls access to specific processes or services running on a server.
- **Example Scenario:**
  - User access control: Permitting HTTP (Port 80) while blocking SSH (Port 22).

## Firewall in AWS
- **AWS Security Groups:**
  - Virtual firewalls controlling inbound and outbound traffic for instances.
  - Rules define allowed or denied traffic.
- **Demonstration:**
  - Modifying security group rules to allow/deny traffic.
  - Example: Allowing Port 80 for website access while blocking other ports.

## Firewall Configuration in Other Cloud Providers
- **Example: DigitalOcean:**
  - Similar setup with inbound and outbound rules.
  - Example: Allowing Port 21 with specified IP addresses.

## Inbound and Outbound Rules
- **Inbound Rules:**
  - Control incoming connections to the server.
  - Example: Allowing access to Port 80 for website visitors.
- **Outbound Rules:**
  - Control outgoing connections from the server.
  - Example: Restricting server access to specific remote systems.
