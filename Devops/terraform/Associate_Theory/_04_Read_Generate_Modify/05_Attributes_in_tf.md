# Attributes in Terraform

* Overview
    * Each resource in Terraform has associated attributes.
    * Attributes are fields in a resource that hold values appearing in the state file.

* Understanding Attributes
    * When a resource like an EC2 instance is created, it has associated attributes such as ID, public IP, private IP, and private DNS.
    * These attributes and their values are stored in the state file.

* Resource Attributes
    * When exploring Terraform documentation for a resource, attributes associated with it are listed under "Attribute Reference."
    * These attributes are added to the state file upon resource creation.

* Example Demonstration
    * Creating Resources: elastic IP and EC2 instance.
    * Verification: Checking attributes in the state file without accessing the AWS console.

* Conclusion
    * Attributes are essential in Terraform for managing resources.
    * They provide key information about resources without needing to access the AWS console.
    * Further exploration and utilization of attributes will be covered in subsequent videos.
