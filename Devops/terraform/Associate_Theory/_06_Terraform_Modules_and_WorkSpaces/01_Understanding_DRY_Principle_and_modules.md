# DRY Principle in Software Engineering

* Introduction
    * DRY principle applies to software development
    * Also applicable in infrastructure as code

* Understanding DRY Principles
    * DRY stands for "Don't Repeat Yourself"
    * Aims to reduce repetitive patterns in code

* Application in Terraform Variables
    * Used to remove static patterns
    * Centralized source of information referenced in Terraform files

* Application in Code Structure
    * Demonstrated with resource blocks in Terraform
    * Avoiding repetition across multiple projects

* Introduction to Terraform Modules
    * Centralized structure for code reuse
    * Example with "kplabs-demo" directory

* Comparing Code with and without Modules
    * Example with "ec2_web.tf" file
    * Modules reduce code size and repetition

* Demonstration of Terraform Modules
    * Changing instance type in "ec2_web.tf"
    * Illustrating the flexibility and efficiency of modules

* Conclusion
    * Modules provide a centralized source for code and resource blocks
    * Simplify code management and enhance reusability
