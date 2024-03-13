* IAM Policies in Depth
  
  * Group Level Policies
    
    * Policies attached at the group level apply to all members of the group.
      * Example: Alice, Bob, and Charles belong to a developers group with a shared policy.
      * Example: David and Edward belong to an operations group with a different policy.
  
  * User Level Policies
  
    * Users not belonging to a group can have inline policies attached directly to them.
    * Inline policies are specific to individual users.
      * Example: Fred has a policy attached directly to him.
  
  * Multiple Policy Inheritance
  
    * Users belonging to multiple groups inherit policies from each group.
      * Example: Charles belongs to both the developers and audit team groups, inheriting policies from both.
      * Example: David belongs to the operations and audit team groups, inheriting policies accordingly.
  
  * Policy Structure
  
    * IAM policies are JSON documents.
    * Structure includes:
      * Version number (e.g., 2012-10-17)
      * Policy ID (optional)
      * Statements, each with:
        * Statement ID (optional)
        * Effect (allow/deny)
        * Principal (accounts/users/roles)
        * Action (API calls)
        * Resource (affected resources)
        * Condition (optional)
    * Key components to understand: Effect, Principal, Action, Resource.

```
{
   "Version":"2012-10-17",
   "sid": 1
   "Statement":[
      {
         "Effect":"Allow",
         "Action":[
            "s3:PutObject",
            "s3:GetObject",
            "s3:GetObjectVersion",
            "s3:DeleteObject",
            "s3:DeleteObjectVersion"
         ],
         "Resource":"arn:aws:s3:::DOC-EXAMPLE-BUCKET1/${aws:username}/*"
      }
   ]
}
```