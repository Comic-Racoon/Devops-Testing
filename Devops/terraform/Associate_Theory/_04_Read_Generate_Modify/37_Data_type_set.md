* **Understanding the Basics of List and Set in Terraform**

  * **List**
    * Lists are used to store multiple items in a single variable.
    * List items are order changeable and allow duplicate values.
    * Items in a list are indexed, starting from zero for the first item.

  * **Set**
    * Sets also store multiple items in a single variable.
    * Set items are unordered, and duplicates are not allowed.
    * There is no inherent index associated with set items.

  * **Conversion with `toset` Function**
    * The `toset` function in Terraform converts a list of values into a set.
    * When applied to a list containing duplicates, the `toset` function removes duplicates, resulting in a set without duplicate values.
  
  * **Usage in Terraform**
    * Depending on the use case, Terraform users may utilize either lists or sets.
    * Lists are suitable when maintaining order and allowing duplicates is necessary.
    * Sets are preferred when order is irrelevant, and duplicate values should be removed.
    * Sets and the `toset` function are particularly useful in scenarios like the `for_each` meta-argument, where a collection of unique values is required.

  * **Conclusion**
    * Understanding the distinctions between lists and sets, as well as their respective usage scenarios, is essential for effective Terraform configuration management.
    * The `toset` function provides a convenient way to convert lists to sets, removing duplicates and ensuring uniqueness when necessary.

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