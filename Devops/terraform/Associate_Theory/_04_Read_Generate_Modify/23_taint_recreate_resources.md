# Understanding Resource Recreations in Terraform

## Introduction
In organizations utilizing Terraform for infrastructure management, manual changes to resources pose challenges. Manual interventions, whether at the infrastructure or server level, can lead to discrepancies between Terraform-managed resources and manually modified ones.

## Common Challenges
1. **Manual Modifications:**
   - Team members may make manual changes directly to infrastructure or server configurations.
   - These changes are not tracked by Terraform, leading to inconsistencies in infrastructure configurations.

2. **Recreating Resources:**
   - Recreating resources becomes necessary to ensure consistency across environments or to revert to a known working state.
   - Terraform provides options to force the recreation of resources even if no configuration changes are detected.

## Solution: Using Terraform Replace
Terraform's `-replace` option with `terraform apply` allows for the forced recreation of resources. This option is recommended over the use of `terraform taint` for resource recreation.

## Practical Demonstration
1. **Initial Resource Creation:**
   - Example scenario involves creating an EC2 instance using Terraform.
   - Manual modifications are made to the instance post-creation, leading to application issues.

2. **Recreating Resources:**
   - To revert to the original infrastructure state, the EC2 instance needs to be recreated.
   - `terraform apply -replace` command is used to force the recreation of the EC2 instance from the Terraform configuration.

## Key Points
- **Version Consideration:**
   - Prior to Terraform 0.15.2, `terraform taint` was commonly used for resource recreation.
   - HashiCorp recommends using `-replace` with `terraform apply` for newer versions.

## Conclusion
Ensuring consistency and reproducibility in infrastructure configurations requires careful management of manual changes. Terraform's ability to force resource recreation facilitates maintaining desired infrastructure states and enables efficient workflow automation.

---


### taint.tf
```sh
provider "aws" {
  region     = "us-east-1"
  access_key = "YOUR-ACCESS-KEY"
  secret_key = "YOUR-SECRET-KEY"
}

resource "aws_instance" "myec2" {
    ami = "ami-00c39f71452c08778"
    instance_type = "t2.micro"
}

```

### Recreating the resource:
```sh
terraform apply -replace="aws_instance.myec2"
```