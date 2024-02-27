# Data Types for Variables in Terraform

* Introduction
    * When defining variables in Terraform, specifying a data type can restrict the accepted values.
    * Type constraint ensures only values of the specified type are accepted for the variable.

* Importance of Type in Variables
    * Explicitly defining a type ensures correctness and prevents errors in resource creation.
    * Useful for enforcing specific data requirements, such as identification numbers.

* Example Demonstration
    * Consider an example where an identification number must be provided for resource naming.
    * By enforcing the type, Terraform ensures only valid values are accepted.

* Demonstration Steps
    * Define variables with explicit types.
    * Demonstrate Terraform's behavior with and without type constraints.
    * Explore various data types available for variables.

* Data Types Available
    * **String:** Represents text data, e.g., "Hello".
    * **List:** Sequential list of values, identified by position.
    * **Map:** Group of values identified by name.
    * **Number:** Represents numeric data, e.g., 200.
    * **Boolean:** Represents true or false values.

* Example with AWS ELB Resource
    * Demonstrate variable types for ELB resource configuration.
    * Best practice: Explicitly specify types for each variable in modules.

* Conclusion
    * Specifying data types for variables in Terraform ensures correctness and prevents errors.
    * Understanding and utilizing various data types available enhances Terraform code readability and reliability.

---

## This snippet is from the Data Types for Variable video.

### ec2_datatype.tf

```sh
provider "aws" {
  region     = "us-west-2"
  access_key = "YOUR-ACCESS-KEY"
  secret_key = "YOUR-SECRET-KEY"
}

resource "aws_iam_user" "lb" {
  name = var.usernumber
  path = "/system/"
}

```
### elb.tf

Documentation:  https://www.terraform.io/docs/providers/aws/r/elb.html

Final Code:

```sh
provider "aws" {
  region     = "us-west-2"
  access_key = "YOUR-ACCESS-KEY"
  secret_key = "YOUR-SECRET-KEY"
}

resource "aws_elb" "bar" {
  name               = var.elb_name
  availability_zones = var.az

  listener {
    instance_port     = 8000
    instance_protocol = "http"
    lb_port           = 80
    lb_protocol       = "http"
  }

  health_check {
    healthy_threshold   = 2
    unhealthy_threshold = 2
    timeout             = 3
    target              = "HTTP:8000/"
    interval            = 30
  }

  cross_zone_load_balancing   = true
  idle_timeout                = var.timeout
  connection_draining         = true
  connection_draining_timeout = var.timeout

  tags = {
    Name = "foobar-terraform-elb"
  }
}
```
### variables.tf

```sh

variable "usernumber" {
  type = number
}

variable "elb_name" {
  type = string
}

variable "az" {
  type = list
}

variable "timeout" {
  type = number
}
```
### terraform.tfvars
```sh
elb_name="myelb"
timeout="400"
az=["us-west-1a","us-west-1b"]
```