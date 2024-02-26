# Terraform Variables

* Introduction
    * Static values in Terraform code
        * Repeated static values lead to maintenance overhead
* Example Scenario
    * Project A
        * Whitelisted IP addresses on ports 22, 80, and 443
    * Project B
        * Same set of whitelisted IP addresses
    * Issue with Static Values
        * Changes in IP addresses require updates in multiple locations
* Solution: Using Variables
    * Centralized source for values
        * Reference values from Terraform code
* Demo Overview
    * `varsdemo.tf` file
        * Security group with whitelisted IP addresses on ports 443, 80, and 53
* Creating Variables
    * `variable.tf` file
        * Definition of `vpn_ip` variable with default value
* Implementation
    * Referencing Variables in Terraform code
        * Syntax: `var.variable_name`
    * Execution
        * `terraform plan`
        * `terraform apply`
* Maintenance Benefits
    * Updating IP addresses
        * Modify values in `variables.tf` only
        * No need to change code
* Conclusion
    * Enhanced maintainability and scalability with Terraform variables

---
```
variable "vpn_ip" {
  default = "116.50.30.50/32"
}
```