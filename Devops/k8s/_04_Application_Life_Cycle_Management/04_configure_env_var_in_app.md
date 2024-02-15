    Use the ENV property.
    ENV is an array, so each item starts with a dash indicating an item in the array.

    Each item in the ENV array has a name and a value property.
        The name is the name of the environment variable made available within the container.
        The value is the value assigned to the environment variable.
```
env:
    - name : app_color
      value : pinl
```

    Alternatively, environment variables can also be set using config maps and secrets.
        Instead of specifying a direct value, use valueFrom followed by a specification of the config map or secret.

```
env:
    - name : app_color
      valueFrom : 
        configMapKeyRef:

env:
    - name : app_color
      valueFrom : 
        secretKeyRef:
```