* **Terraform Output**

  * **Introduction**
    * "terraform output" command extracts values of specific output variables from the state file.

  * **Syntax**
    * Use `terraform output` followed by the name of the output variable.

  * **Practical Demonstration**
    * Simple resource block creates 3 IAM users.
    * Output uses Splat Expression to display attributes (name and ARN) for all 3 IAM users.

  * **Applying Changes**
    * Execute `terraform apply` to apply the changes.

  * **Output Inspection**
    * Upon applying changes, values for IAM ARN and names are displayed in the output.
    * Values can also be inspected directly from the .tfstate file.

  * **Using "terraform output" Command**
    * Use `terraform output` command followed by the name of the output variable.
    * Values for IAM ARN and names are automatically retrieved.

  * **Conclusion**
    * "terraform output" provides a convenient way to extract specific values from the state file.

  * **Summary**
    * Three methods for retrieving output values:
      1. Displaying values during `terraform apply`.
      2. Inspecting values from the .tfstate file.
      3. Using the "terraform output"

---

### output-values.tf

```sh
provider "aws" {
  region = "us-east-1"
}

resource "aws_eip" "lb" {
  domain   = "vpc"
}

output "public-ip" {
  value = aws_eip.lb.public_ip
}
```

### Output Values Customization Shown in The Video:

```sh
output "public-ip" {
  value = aws_eip.lb.public_ip
}
```

```sh
output "public-ip" {
  value = "https://${aws_eip.lb.public_ip}:8080"
}
```

```sh
output "public-ip" {
  value = aws_eip.lb
}
```

### CLI Commands used:
```sh
terraform apply -auto-approve
terraform destroy -auto-approve
```