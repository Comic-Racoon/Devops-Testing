# Variable References: List and Map

* Introduction
    * Understanding how to reference specific values from lists and maps using variables.
    * Essential for both exams and real-world scenarios.

* Use-Case: Referencing Values
    * Objective: Reference a specific value from a list or map using a variable.
    * Scenario: Utilize variable references for practical applications.

* Map Reference
    * Example: Using a map with regions and instance types.
    * Syntax: `var.types["us-west-2"]` references the instance type associated with the region.
    * Demonstration: Successfully reference the desired instance type using the variable.

* List Reference
    * Example: Using a list of instance types.
    * Syntax: `var.list[0]`, `var.list[1]`, etc., references values by their position in the list.
    * Demonstration: Successfully reference specific instance types from the list using variables.

---
```
provider "aws" {
  region     = "us-west-2"
  access_key = "YOUR-KEY"
  secret_key = "YOUR-KEY"
}

resource "aws_instance" "myec2" {
   ami = "ami-082b5a644766e0e6f"
   instance_type = var.list[1]
}

variable "list" {
  type = list
  default = ["m5.large","m5.xlarge","t2.medium"]
}

variable "types" {
  type = map
  default = {
    us-east-1 = "t2.micro"
    us-west-2 = "t2.nano"
    ap-south-1 = "t2.small"
  }
}
```