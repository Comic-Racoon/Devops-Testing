* **Splat Expression**
  * **High-Level Overview**
    * Splat expression allows retrieval of a list of all attributes.

  * **Example: Using Splat with "aws_iam_user" Resource**
    * When creating IAM users with a count of three, each user will have an associated ARN.
    * The output ARN is specified as `"aws_iam_user.lb[*].arn"`, where `[*]` represents the splat expression.
    * Even with 100 IAM users, the ARN attribute will be listed for all users.

  * **Demonstration Steps**
    * **Documentation Page Review**
      * Review attributes of the `aws_iam_user` resource: ARN, name, and unique_id.
      * Focus on using the ARN attribute for the demo.

    * **Count and Count Index Understanding**
      * In this demo, a count of 3 is utilized.
      * The count index starts at zero and progresses sequentially (0, 1, 2 for a count of 3).
      * Demonstrating attribute output for specific IAM users using count indices (0, 1, 2).

    * **Terraform Plan**
      * Execute `terraform plan` to confirm the creation of 3 IAM users.

    * **Terraform Apply**
      * Execute `terraform apply` to deploy the infrastructure.

    * **Output Review**
      * Observe the output, showcasing the ARN attribute associated with each IAM user (e.g., `iamuser.0`).

  * **Splat Implementation**
    * Instead of manually specifying count indices, utilize Splat for retrieving attributes associated with all created users.
    * Splat expression syntax: `"aws_iam_user.lb[*].arn"`, where `[*]` denotes all instances created.

This documentation provides an understanding of Splat expressions and demonstrates their usage with the "aws_iam_user" resource in Terraform.

---

## This snippet is from the Splat Expression Video.

### splat.tf

```sh

provider "aws" {
  region     = "us-west-2"
  access_key = "YOUR-ACCESS-KEY"
  secret_key = "YOUR-SECRET-KEY"
}
resource "aws_iam_user" "lb" {
  name = "iamuser.${count.index}"
  count = 3
  path = "/system/"
}

output "arns" {
  value = aws_iam_user.lb[*].arn
}
```
