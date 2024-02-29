* **Terraform Settings**

  * **Introduction**
    * Terraform configuration block type configures behavior of Terraform itself.
    * It includes settings like required Terraform version and provider versions.

  * **Terraform Configuration Block**
    * Special block used to configure Terraform settings.
    * Contains configurations for various behaviors including required Terraform version.

  * **Required Version**
    * Argument: `required_version`
    * Specifies minimum version of Terraform required for configuration to be applied.
    * Example: `required_version = "< 0.11"`

  * **Provider Version**
    * Argument: `required_providers`
    * Specifies required providers and their versions.
    * Example: 
      ```hcl
      required_providers {
        aws = {
          source  = "hashicorp/aws"
          version = ">= 2.0"
        }
      }
      ```

  * **Demonstration**
    * Demo with a `settings.tf` file.
    * `terraform init` shows error if Terraform version doesn't match required version.
    * Provider version specified within `required_providers` block.
    * Provider version also installable through `terraform init`.

  * **Provider Version in Provider Block**
    * Provider version can also be specified within provider block but not recommended post-Terraform 0.12.

  * **Conclusion**
    * Terraform settings configure key behaviors including required Terraform version and provider versions.

---


## Demo Code and Examples Used During Demo:
```sh
terraform {
  required_version = "< 0.11"
  required_providers {
    aws = "~> 2.0"
  }
}

provider "aws" {
  region     = "ap-southeast-1"
  access_key = "YOUR-KEY"
  secret_key = "YOUR-KEY"
}

resource "aws_instance" "myec2" {
   ami = "ami-0b1e534a4ff9019e0"
   instance_type = "t2.micro"
}
```