# Terraform Data Sources Overview

## Introduction
- Data sources in Terraform fetch or compute data for use elsewhere in the configuration.
- Useful for retrieving dynamic information like AMI IDs, VPC IDs, etc.
- Helps avoid hardcoding values and enables dynamic configuration based on fetched data.

## Scenario
- AMI IDs vary by region and can change over time, posing a challenge for hardcoding in Terraform configurations.
- Example: Launching EC2 instances with different AMIs based on region.

## Solution: Data Sources
- Use data sources to fetch AMI IDs dynamically based on region.
- Data sources are defined under the `data` block.
- Example: `aws_ami` data source to fetch the most recent Amazon Linux 2 AMI.

## Configuration
- Specify data source configurations like `most_recent`, `owners`, and filters (`name`, `values`).
- Example: Fetching AMI IDs with filter criteria for Amazon Linux 2 AMIs owned by Amazon.

## Practical Demonstration
- Configure data source in Terraform configuration.
- Use the fetched AMI ID in the `ami` attribute of `aws_instance` resource.

## Testing and Verification
- Verify functionality with `terraform plan` and `terraform apply`.
- Confirm that the correct AMI IDs are fetched dynamically based on the region.
- Test with different regions to ensure accurate data retrieval.

## Conclusion
- Data sources provide a flexible and dynamic way to fetch data for Terraform configurations.
- Useful for scenarios where static values are not appropriate or data needs to be computed dynamically.
- Enhances configuration flexibility and maintainability by avoiding hardcoding and enabling dynamic updates.

---

## This snippet is for Data Sources.

### data-source.tf

```sh

provider "aws" {
  region     = "ap-southeast-1"
  access_key = "YOUR-ACCESS-KEY"
  secret_key = "YOUR-SECRET-KEY"
}

data "aws_ami" "app_ami" {
  most_recent = true
  owners = ["amazon"]


  filter {
    name   = "name"
    values = ["amzn2-ami-hvm*"]
  }
}

resource "aws_instance" "instance-1" {
    ami = data.aws_ami.app_ami.id
   instance_type = "t2.micro"
}
```