Purpose:

    Manage environment data centrally using key-value pairs.
    Inject configuration data into pods as environment variables.

Config Maps Configuration:

    Two phases: Creation and injection.

    Two ways to create config maps:
    
        Imperative Approach:
            Use kubectl create configmap command.
            Specify key-value pairs directly.
            Example: 
            ```
            kubectl create configmap app-config --from-literal=app-color=blue.
            ```
            or for multiple literals
            ```
            kubectl create configmap app-config --from-literal=app-color=blue \
                                                --from-literal=text-color=black\
            ```
    
        Declarative Approach:
            Create a definition file (YAML).
            Specify apiVersion, kind, metadata, and data.
            Example:
            ```
            apiVersion: v1
            kind: ConfigMap
            metadata:
              name: app-config
            data:
              app-color: blue
            ```
Viewing Config Maps:

    Use ```kubectl get configmaps``` command.
    Use ```kubectl describe configmaps``` command to see configuration data.

Injecting Config Maps into Pods:

    Modify pod definition file to include config map.
    Add envFrom property to container.
    Specify config map name.
    Example:

```
        spec:
          containers:
            - name: my-app
              envFrom:
                - configMapRef:
                    name: app-config
```
    Alternative Injection Methods:
        Inject as single environment variable.
        Inject entire data as files in a volume.

By using config maps, you can effectively manage configuration data and inject it into pods as environment variables, simplifying the deployment and management of Kubernetes applications.