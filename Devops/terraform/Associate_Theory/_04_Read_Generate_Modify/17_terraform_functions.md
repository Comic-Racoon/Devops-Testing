# Terraform Functions Overview

## Introduction
- Terraform language includes built-in functions for transforming and combining values.
- General syntax: `function_name(arguments)`.
- Functions categorized into Numeric, String, Collection, Encoding, Filesystem, Date and Time, Hash, Cryptography, IP Network, and Type Conversion.

## Usage Examples
- **Numeric Functions**: `max`, `min`.
- **String Functions**: `format`, `lower`, `join`.
- **Collection Functions**: `lookup`, `element`.
- **Filesystem Functions**: `file`.
- **Date and Time Functions**: `timestamp`, `formatdate`.
- **Others**: `count`.

## Practical Demonstration
- Create resources using Terraform functions.
- Example: `lookup` function to select AMI based on region, `element` function for resource tagging, `file` function for reading file content, `timestamp` and `formatdate` for displaying current timestamp.

## Testing and Verification
- Use `terraform console` to test functions interactively.
- Verify functionality and outputs with `terraform plan` and `terraform apply`.
- Inspect created resources and output values to ensure correctness.

## Conclusion
- Functions provide powerful capabilities for manipulating and processing data within Terraform configurations.
- Understanding function syntax and usage is essential for efficient and effective infrastructure provisioning.
- Testing and verification are crucial steps to ensure proper functioning of functions within Terraform configurations.

---

## This snippet is fro Terraform Function 

### functions.tf

```sh
provider "aws" {
  region     = var.region
  access_key = "YOUR-ACCESS-KEY"
  secret_key = "YOUR-SECRET-KEY"
}

locals {
  time = formatdate("DD MMM YYYY hh:mm ZZZ", timestamp())
}

variable "region" {
  default = "ap-south-1"
}

variable "tags" {
  type = list
  default = ["firstec2","secondec2"]
}

variable "ami" {
  type = map
  default = {
    "us-east-1" = "ami-0323c3dd2da7fb37d"
    "us-west-2" = "ami-0d6621c01e8c2de2c"
    "ap-south-1" = "ami-0470e33cd681b2476"
  }
}

resource "aws_key_pair" "loginkey" {
  key_name   = "login-key"
  public_key = file("${path.module}/id_rsa.pub")
}

resource "aws_instance" "app-dev" {
   ami = lookup(var.ami,var.region)
   instance_type = "t2.micro"
   key_name = aws_key_pair.loginkey.key_name
   count = 2

   tags = {
     Name = element(var.tags,count.index)
   }
}


output "timestamp" {
  value = local.time
}
```
### The id_rsa.pub file that we have used within the video
```sh
https://github.com/zealvora/terraform-beginner-to-advanced-resource/blob/master/section04/id_rsa.pub
```