Using Secrets in Kubernetes:

    Purpose:
        Store sensitive information like passwords or keys.
        Encoded format for security.

    Creating Secrets:
        Two methods:
            Imperative Approach:
                Use kubectl create secret generic command.
                Specify key-value pairs directly.
                Example: kubectl create secret generic app-secret --from-literal=DB_password=MySQL.
            Declarative Approach:
                Create a definition file (YAML).
                Specify apiVersion, kind, metadata, and data.
                Data must be base64 encoded.

    Viewing Secrets:
        Use kubectl get secrets command.
        Use kubectl describe secrets command to see attributes (values hidden).
        Use kubectl get secret -o yaml to view encoded values.

    Injecting Secrets into Pods:
        Modify pod definition file to include secret.
        Add envFrom property to container.
        Specify secret name.
        Example:
```
    spec:
      containers:
        - name: my-app
          envFrom:
            - secretRef:
                name: app-secret
```
Alternative Injection Methods:

    Inject as single environment variables.
    Inject entire secret as files in a volume.

```
        spec:
          containers:
            - name: my-app
              envFrom:
                - secretRef:
                    name: app-config
```

Security Considerations:

    Secrets are encoded, not encrypted.
    Avoid checking secret definition files into version control.
    Configure encryption at rest for etcd.
    Restrict access using role-based access control (RBAC).
    Consider using third-party secret providers (AWS, Azure, GCP, Vault) for enhanced security.

Advanced Topics:

    Encryption at rest using encryption configuration.
    Third-party secret providers for enhanced security.