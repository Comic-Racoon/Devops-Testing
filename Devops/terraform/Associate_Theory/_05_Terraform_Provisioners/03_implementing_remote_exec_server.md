# Practical Overview of "remote-exec" Provisioner in Terraform

In today's video, we'll explore the practical implementation of the "remote-exec" provisioner from Terraform's documentation.

## Introduction
* The "remote-exec" provisioner executes a script on a remote resource after its creation.
* Common use cases include installing software on newly created instances like databases, Docker, or WordPress.

## Preparation Steps
* Manual Setup:
  * Create a new key pair named "terraform-key" in the AWS EC2 console and download the PEM file.
  * Launch a new EC2 instance with Amazon Linux 2, selecting "terraform-key" as the key pair.

## Manual Software Installation
* Connect to the EC2 instance via SSH using the downloaded key.
* Install software like Nginx manually by running appropriate commands.
* Adjust security group settings to allow SSH (Port 22) and HTTP (Port 80) traffic.

## Practical Implementation with Terraform
* Ensure the "terraform-key.pem" file is available in the working directory.
* Create a Terraform file named "remote-exec.tf" to define the EC2 instance and provisioner.
* Utilize the "remote-exec" provisioner to run commands on the remote EC2 instance after creation.
* Configure the connection settings including SSH user, private key, and host (public IP).
* Specify commands to install and start Nginx within the provisioner block.
* Ensure the EC2 instance is launched with the correct key pair specified.

## Terraform Execution
* Initialize the Terraform configuration with `terraform init`.
* Preview the changes with `terraform plan`.
* Apply the changes with auto-approval to avoid prompts using `terraform apply -auto-approve`.
* Monitor Terraform's connection attempts and software installation progress.
* Verify successful installation by accessing the EC2 instance's public IP in a browser.

## Conclusion
* The "remote-exec" provisioner in Terraform automates the process of software installation on EC2 instances.
* By combining Terraform's infrastructure management capabilities with provisioners, organizations can achieve efficient and consistent deployment workflows.
* Ensure proper security group configurations to allow necessary network traffic for SSH and application access.

---

### Documentation Referenced:

https://www.terraform.io/language/resources/provisioners/remote-exec

https://www.terraform.io/language/resources/provisioners/connection

https://www.terraform.io/language/functions/file

### Base Code:
```sh
provider "aws" {
  region     = "us-west-2"
  access_key = "YOUR-KEY"
  secret_key = "YOUR-KEY"
}


resource "aws_instance" "myec2" {
   ami = "ami-0f3769c8d8429942f"
   instance_type = "t2.micro"
}
```
### Final Code:


```sh
provider "aws" {
  region     = "us-west-2"
  access_key = "YOUR-KEY"
  secret_key = "YOUR-KEY"
}


resource "aws_instance" "myec2" {
   ami = "ami-0ca285d4c2cda3300"
   instance_type = "t2.micro"
   key_name = "terraform-key"

   connection {
   type     = "ssh"
   user     = "ec2-user"
   private_key = file("./terraform-key.pem")
   host     = self.public_ip
    }

 provisioner "remote-exec" {
   inline = [
    # Updating with the latest command for Amazon Linux machine
     "sudo yum install -y nginx",
     "sudo systemctl start nginx"
   ]
 }
}
```

```sh
terraform init
terraform plan
terraform apply -auto-approve
terraform destroy -auto-approve
```