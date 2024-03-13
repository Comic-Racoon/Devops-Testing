* IAM (Identity and Access Management)
  * Introduction to IAM
    * IAM stands for identity and access management.
    * It is a global service where users and groups are managed.
    * When creating an AWS account, a root account is automatically created.
      * The root account is solely for initial setup and should not be shared or used regularly.
  * Creating Users in IAM
    * Users represent individuals within an organization.
    * Users can be grouped together for easier management.
      * Example: Alice, Bob, and Charles are developers grouped under "developers."
      * Example: David and Edward are in an operations group.
    * Users not belonging to a group are possible but not recommended.
    * Users can belong to multiple groups.
  * IAM Groups
    * Groups contain users only, not other groups.
    * Users can belong to multiple groups.
      * Example: Charles and David could be part of an audit team group.
  * Assigning Permissions with IAM Policies
    * Users and groups are assigned IAM policies.
    * IAM policies are JSON documents defining permissions.
    * Policies follow the principle of least privilege.
    * Example policy allows access to EC2, Elastic Load Balancing, and CloudWatch.
    * Policies restrict users to necessary permissions, avoiding excessive access.
