    Creating a Role:
        To create a role:
            Create a role object.
            Create a role definition file with specified API version and kind.
            Name the role appropriately (e.g., "developer").
            Specify rules for the role, including API groups, resources, and verbs.
            Add rules for each resource and action developers need access to.
            Use kubectl create role command to create the role.

    Linking User to Role:
        To link a user to a role:
            Create a role binding object.
            Name the role binding appropriately.
            Specify the user details in the subjects section.
            Provide details of the role created in the roleRef section.
            Use kubectl create rolebinding command to create the role binding.

    Namespace Scope:
        Roles and role bindings are namespace-specific.
        Specify the namespace within the metadata of the definition file to limit access.
        View created roles with kubectl get roles command.
        List role bindings with kubectl get rolebindings command.
        Describe a role with kubectl describe role developer command.
        Describe role bindings with kubectl describe rolebindings command.

    Checking Access:
        Use kubectl auth can-i command to check access to specific resources.
        Admins can impersonate users to check permissions.
        Test permissions without authenticating using the --as option.
        Specify namespace to check access within a specific namespace.

    Resource Names:
        Access can be restricted to specific resources within a namespace.
        Add a resourceNames field to the rule to limit access to specific resources.

