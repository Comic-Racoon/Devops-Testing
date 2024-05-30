# VPC Router

## Function
- Routes traffic between subnets and in/out of the VPC.

## Interface
- Has an interface in every subnet, reachable at the network plus one address.
  - Example: For subnet 192.168.10.0/24, the router's interface is 192.168.10.1.

# Route Table

## Purpose
- Controls the router by determining where network traffic is sent.

## Components
- A set of rules (routes) used to forward network traffic.
- Each rule consists of a destination and a target.

# How Routing Works

## Packet Handling
- Router examines the destination IP of outgoing packets.
- Matches the destination IP with the destination column in the route table.

## Rule Matching
- If multiple rules match, the one with the largest prefix length (most specific) is selected.
  - Example: A packet matching both 10.16.0.0/16 and 10.16.1.0/24 will use the /24 route.

# Route Selection

## Default Route
- All route tables have a default route called the local route.
- Matches traffic within the VPC (local traffic).
  - Example: For VPC CIDR 10.16.0.0/16, local route handles all internal traffic within this CIDR.

## IPv6
- If IPv6 is enabled, a local route for the IPv6 CIDR block is also present.

# Subnet Association with Route Tables

## Single Route Table
- Each subnet is associated with one route table.

## Multiple Associations
- A single route table can be associated with multiple subnets.

## Default Route Table
- Newly created subnets are associated with the default route table unless specified otherwise.

# Route Table Configuration

## Custom Route Tables
- Different route tables for public and private subnets.
  - Public subnets might have routes pointing to an internet gateway.
  - Private subnets might have routes pointing to a NAT gateway or other internal resources.

# Summary

## VPC Router
- Routes traffic within and outside the VPC.
- Accessible via the network plus one address of each subnet.

## Route Table
- Contains rules (routes) for traffic forwarding.
- Matches packets based on destination IP.

## Default Route
- Local route for internal VPC traffic.
- Additional local route for IPv6 if enabled.

## Subnet-Route Table Association
- Each subnet linked to one route table.
- Multiple subnets can share a single route table.

## Custom Routing
- Use different route tables for different subnet types (public/private).

---
### Questions
