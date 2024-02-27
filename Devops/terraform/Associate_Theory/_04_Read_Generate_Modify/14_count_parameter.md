# Count Parameter and Count Index in Terraform

* Introduction
    * Today's focus: Understanding the count parameter and count index in Terraform.
    * Simplifies configurations and scales resources efficiently.

* Use-Case: Scaling Resources
    * Common approach: Define separate resource blocks for multiple instances.
    * Limitations: Cumbersome and repetitive code for scaling.
    * Solution: Utilize count parameter for dynamic resource scaling.

* Implementation with Example
    * Scenario: Creating multiple EC2 instances.
    * Initial approach: Replicate resource blocks for each instance.
    * Drawbacks: Tedious and lengthy code for scalability.

* Introducing Count Parameter
    * Syntax: `count = 3` specifies the number of resource instances.
    * Benefits: Simplifies resource scaling and reduces code duplication.
    * Demonstration: Use count parameter to create multiple EC2 instances effortlessly.

* Understanding Count Index
    * Purpose: Fetch index of each iteration in the loop.
    * Syntax: `count.index` returns the distinct index number starting from zero.
    * Importance: Facilitates customization of resource configurations for each instance.

* Practical Demonstration
    * Challenge: Creating IAM users with unique names using count index.
    * Approach: Utilize count.index to append index to resource names dynamically.
    * Demonstration: Create IAM users with distinct names using count.index.

* Customizing Resource Names
    * Requirement: Utilize meaningful names instead of generic index-based names.
    * Solution: Define a list variable with custom names and iterate using count.index.
    * Demonstration: Create IAM users with custom names using count.index and a list variable.

* Conclusion
    * Count parameter simplifies resource scaling and configuration in Terraform.
    * Count index enhances customization by providing distinct indices in resource iterations.
    * Understanding and utilizing count parameter and count index is crucial for efficient Terraform usage.
---

### iam-count-parameter.tf

```sh
provider "aws" {
  region     = "us-west-2"
  access_key = "YOUR-ACCESS-KEY"
  secret_key = "YOUR-SECRET-KEY"
}

variable "elb_names" {
  type = list
  default = ["dev-loadbalancer", "stage-loadbalanacer","prod-loadbalancer"]
}

resource "aws_iam_user" "lb" {
  name = var.elb_names[count.index]
  count = 3
  path = "/system/"
}
```
### count-paremeter.tf

```sh
provider "aws" {
  region     = "us-west-2"
  access_key = "YOUR-ACCESS-KEY"
  secret_key = "YOUR-SECRET-KEY"
}


resource "aws_instance" "instance-1" {
   ami = "ami-082b5a644766e0e6f"
   instance_type = "t2.micro"
   count = 3
}
```