# Overview of Output Values in Terraform

- **Overview of Output Values in Terraform:**
  - Terraform provides information about infrastructure on the command line for exposure to other Terraform configurations.
    - Users can instruct Terraform to create resources and provide specific details like public IPs.
    - This facilitates efficient access to infrastructure details without manual intervention.

## Demonstration:

- **Demonstration:**
  - Created a Terraform file `output-values.tf` to create an AWS Elastic IP.
  - Executed `terraform apply` to create the Elastic IP.
  - Demonstrated the manual process of retrieving the public IP from the AWS console.

## Utilizing Output Values:

- **Utilizing Output Values:**
  - Output values can be defined within Terraform code using the `output` block.
    - Users specify attributes they want to expose, such as `public_ip`.
    - Customizations like HTTPS and port numbers can be included for convenience.

## Interoperability and Collaboration:

- **Interoperability and Collaboration:**
  - Output values facilitate collaboration between multiple Terraform projects.
    - Projects in separate repositories can share data via output values.
    - For example, Project B can fetch public IP details from Project A's output values.

## Advanced Usage:

- **Advanced Usage:**
  - Output values are stored in the `terraform.tfstate` file.
    - Other projects can access this file to retrieve shared output values.

Note: Further architectural details and advanced usage will be covered in later parts of the course.

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