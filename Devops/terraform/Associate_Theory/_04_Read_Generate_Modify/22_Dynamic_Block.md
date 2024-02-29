# Understanding Dynamic Blocks in Terraform

## Introduction
- Dynamic blocks in Terraform allow for the dynamic construction of repeatable nested blocks within resources, data, providers, and provisioners.
- They are useful for managing configurations with multiple repeatable blocks, such as security group rules.

## Example Scenario: Security Group Rules
- Consider a scenario where multiple ingress and egress rules need to be defined for a security group.
    - Dynamic blocks provide a solution to streamline the configuration of these rules.

## Implementation of Dynamic Blocks
- **Variable Definition**
    - Define a variable `sg_ports` as a list of port numbers.
        - This variable will serve as input for dynamic block generation.
- **Resource Configuration**
    - Utilize dynamic blocks within the `aws_security_group` resource.
    - **Ingress Rules**
        - Iterate over each port number in `sg_ports` using `for_each`.
            - Create a dynamic block for each port number to define ingress rules.
            - Specify attributes such as `from_port`, `to_port`, `protocol`, and `cidr_blocks`.
    - **Egress Rules**
        - Similarly, use dynamic blocks for egress rules.
        - Iterate over each port number in `sg_ports` to define egress rules dynamically.

## Benefits of Dynamic Blocks
- **Simplified Configuration**
    - Reduce code duplication by dynamically generating nested blocks based on input values.
- **Improved Readability**
    - Enhance code readability by using a single block definition to generate multiple nested blocks.
- **Scalability and Maintainability**
    - Scale configurations easily by adding or removing elements from the input list.
    - Improve maintainability of configurations with multiple repeatable blocks.

## Conclusion
- Dynamic blocks are a powerful feature in Terraform for managing configurations with repetitive nested blocks.
- They provide a flexible and efficient way to define multiple similar blocks within resources, data sources, providers, and provisioners.
- By leveraging dynamic blocks, Terraform users can streamline configuration management and improve code quality.

---

### before.tf

```sh
resource "aws_security_group" "demo_sg" {
  name        = "sample-sg"

  ingress {
    from_port   = 8200
    to_port     = 8200
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port   = 8201
    to_port     = 8201
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port   = 8300
    to_port     = 8300
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port   = 9200
    to_port     = 9200
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port   = 9500
    to_port     = 9500
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

```

### dynamic-block.tf

```sh



variable "sg_ports" {
  type        = list(number)
  description = "list of ingress ports"
  default     = [8200, 8201,8300, 9200, 9500]
}

resource "aws_security_group" "dynamicsg" {
  name        = "dynamic-sg"
  description = "Ingress for Vault"

  dynamic "ingress" {
    for_each = var.sg_ports
    iterator = port
    content {
      from_port   = port.value
      to_port     = port.value
      protocol    = "tcp"
      cidr_blocks = ["0.0.0.0/0"]
    }
  }

  dynamic "egress" {
    for_each = var.sg_ports
    content {
      from_port   = egress.value
      to_port     = egress.value
      protocol    = "tcp"
      cidr_blocks = ["0.0.0.0/0"]
    }
  }
}

```