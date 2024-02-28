# Local Values in Terraform

* **Introduction**
  * Local values assign a name to an expression, allowing it to be reused within a module without repetition.
  * They simplify configurations by defining values or expressions once and using them multiple times.

* **Use Cases of Local Values**
  * **Common Tags for Resources:**
    * Example: Defining common tags for AWS resources (e.g., owner, service) using local values.
    * Usage: Tags can be reused across multiple resources without duplication.
    * Simplifies configuration and ensures consistency in tagging.

* **Implementation Example**
  * **local-values.tf:**
    ```sh
    provider "aws" {
      region     = "ap-southeast-1"
      access_key = "YOUR-ACCESS-KEY"
      secret_key = "YOUR-SECRET-KEY"
    }

    locals {
      common_tags = {
        Owner   = "DevOps Team"
        service = "backend"
      }
    }

    resource "aws_instance" "app-dev" {
       ami           = "ami-082b5a644766e0e6f"
       instance_type = "t2.micro"
       tags          = local.common_tags
    }

    resource "aws_instance" "db-dev" {
       ami           = "ami-082b5a644766e0e6f"
       instance_type = "t2.small"
       tags          = local.common_tags
    }

    resource "aws_ebs_volume" "db_ebs" {
      availability_zone = "us-west-2a"
      size              = 8
      tags              = local.common_tags
    }
    ```
  * **Explanation:**
    * `common_tags` local value defines common key-value pairs for resource tags.
    * Multiple AWS resources reuse `common_tags` for tagging, eliminating duplication.

* **Benefits and Considerations**
  * **Benefits:**
    * Avoids repetition of values or expressions within configurations.
    * Enhances readability and maintainability of Terraform code.
  * **Considerations:**
    * Overuse of local values can make configurations harder to understand.
    * Use local values judiciously, especially for values likely to change in the future.

* **Conclusion**
  * Local values streamline Terraform configurations by enabling reuse of expressions.
  * They improve code readability and maintainability by eliminating duplication.
  * Understanding when and how to use local values effectively is essential for efficient Terraform development.
