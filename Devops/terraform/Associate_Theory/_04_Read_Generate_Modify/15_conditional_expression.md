# Condition Expression in Terraform

* **Introduction**
  * Today's focus: Understanding the condition expression in Terraform.
  * Conditional expressions select one of two values based on a boolean expression.

* **Syntax and Usage**
  * Syntax: `condition ? true_value : false_value`
  * Explanation:
    * If the condition is true, true_value is used.
    * If the condition is false, false_value is used.

* **Use-Case: Environment-specific Resource Creation**
  * Scenario: Create environment-specific resources based on a variable value.
  * Example: Create either a development or production EC2 instance based on the value of the variable "is-test".

* **Implementation with Example**
  * Initial Setup:
    * Two resource blocks: one for Dev and one for Prod.
  * Challenge: Create resources based on the value of the "is-test" variable.

* **Using Conditional Expression**
  * Approach:
    * Utilize conditional expression within resource blocks.
    * Set count parameter based on the value of the "is-test" variable.

* **Practical Demonstration**
  * Steps:
    1. Define the "is-test" variable.
    2. Implement conditional expression within resource blocks.
    3. Assign values to the "is-test" variable to control resource creation.
  * Example:
    * If "is-test" is true, create Dev resources.
    * If "is-test" is false, create Prod resources.

* **Conclusion**
  * Conditional expressions offer flexibility in resource creation based on dynamic conditions.
  * Use of conditional expressions enhances Terraform configuration flexibility and efficiency.
  * Understanding and implementing conditional expressions is essential for environment-specific resource provisioning in Terraform.

---

## This snippet is for the Conditional Expression 

### conditional.tf

```sh

provider "aws" {
  region     = "us-west-2"
  access_key = "YOUR-ACCESS-KEY"
  secret_key = "YOUR-SECRET-KEY"
}

variable "istest" {}

resource "aws_instance" "dev" {
   ami = "ami-082b5a644766e0e6f"
   instance_type = "t2.micro"
   count = var.istest == true ? 3 : 0
}

resource "aws_instance" "prod" {
   ami = "ami-082b5a644766e0e6f"
   instance_type = "t2.large"
   count = var.istest == false ? 1 : 0
}
```

### terraform.tfvars

```sh
istest = false
```