# Practical Implementation of Terraform Modules

## Introduction
- Basics of DRY principle discussed in previous video
- Demo on Terraform Modules in today's video

## Getting Started
- Create a new folder named `kplabs-modules`
- Inside `kplabs-modules`, create two folders: `modules` and `projects`
- Inside `projects`, create two folders: `A` and `B`

## Creating Module for EC2
- Create a folder named `ec2` inside `modules`
- Create a new file named `ec2.tf` inside `ec2`
- Copy and paste EC2 resource block code into `ec2.tf`

## Referencing Module in Project
- Inside project `A`, create a new file named `myec2.tf`
- Reference the module in `myec2.tf` using module block and specify source path
- Copy `providers.tf` from previous project into `A`

## Initializing and Planning
- Run `terraform init` inside project `A` to initialize module and download plugins
- Run `terraform plan` to see the planned changes associated with the EC2 instance

## Benefits of Using Modules
- Modules abstract complexity for developers
- Developers only need to call the module without worrying about detailed configurations
- Changes to module parameters reflect across all projects using the module

## Conclusion
- Terraform modules simplify infrastructure provisioning
- Encourage reusability and abstraction of configuration details
- Developers can focus on high-level infrastructure requirements without dealing with low-level configurations
