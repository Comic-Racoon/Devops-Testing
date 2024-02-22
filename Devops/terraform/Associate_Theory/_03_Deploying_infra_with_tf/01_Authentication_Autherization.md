Authentication and Authorization with TerraForm:

    Authentication:
        TerraForm requires authentication before creating resources in any provider environment.
        Authentication credentials vary based on the provider (e.g., username/password, token).
        Provider verifies the existence of the user upon receiving authentication credentials.

    Authorization:
        Determines the level of access granted to authenticated users.
        Permissions can range from admin access to read-only or no access.
        In TerraForm, credentials must have relevant permissions to create/manage resources.
    
    Provider-specific Authentication:
        AWS Provider:
            Access and secret keys are required for authentication.
        GitHub Provider:
            Token-based authentication.
            Tokens can be generated with specified permissions.
    
    Credential Management:
        Credentials should match the desired level of access for resource creation.
        Granular permissions ensure security and prevent unintended actions.
        For example, in GitHub, tokens can be restricted to specific repositories with defined access levels.