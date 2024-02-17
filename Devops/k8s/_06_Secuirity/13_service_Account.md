Types of Accounts in Kubernetes:
    User Account:
        Used by humans.
        Example: Administrator, Developer.
    Service Account:
        Used by machines or applications.
        Example: Monitoring tools like Prometheus, CI/CD tools like Jenkins.

Working with Service Accounts:
    Creating Service Accounts:
        Use kubectl create serviceaccount command followed by the account name.
        View service accounts with kubectl get serviceaccount command.
        Each service account has a token automatically generated.
        The token is stored as a secret object.

Using Service Account Tokens:
    Tokens are used for authenticating applications with the Kubernetes API.
    Tokens are stored as secrets.
    View token by describing the secret object with kubectl describe secret.
    Authenticate applications by providing the token as a bearer token in API requests.
    Tokens can be manually configured in applications or automatically mounted in pods.

Default Service Accounts:
    Each namespace has a default service account named default.
    Default service account and its token are automatically mounted to pods in the namespace.
    Pods can use the default service account unless specified otherwise.
    Service accounts can be manually specified in pod definitions.

Changes in Kubernetes Versions:
    Version 1.22:
        Introduction of TokenRequestAPI for more secure and scalable token provisioning.
        Pods no longer rely on service account secret tokens.
        Tokens with defined lifetimes are generated through TokenRequestAPI.
        Tokens are mounted as projected volumes in pods.
    Version 1.24:
        Reduction of secret-based service account tokens.
        Service accounts no longer automatically create secret objects.
        Tokens must be explicitly generated using kubectl create token command.
        Tokens have an expiry date, improving security.

Considerations:
    Use TokenRequestAPI for token provisioning as it provides more security and scalability.
    Service account token secrets should only be created if TokenRequestAPI is not viable.
    Tokens with defined lifetimes are recommended over non-expiring tokens for security reasons.

Final Notes:
    Service accounts and their tokens are crucial for authenticating applications with the Kubernetes API.
    Understanding the changes in token provisioning is essential for maintaining security in Kubernetes environments.

