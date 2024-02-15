Using initContainers in Kubernetes Pods:

    Purpose:
        Run processes that complete before the main application container starts.
        Examples include pulling code or binaries, waiting for external services to be up.

    Configuration:
        Specified inside the initContainers section of the pod definition file.
        Each initContainer runs to completion before the main application container starts.
        Can configure multiple initContainers, executed sequentially.

    Failure Handling:
        If any initContainer fails to complete, Kubernetes restarts the pod until all initContainers succeed.

```
apiVersion: v1
kind: Pod
metadata:
  name: myapp-pod
  labels:
    app: myapp
spec:
  containers:
  - name: myapp-container
    image: busybox:1.28
    command: ['sh', '-c', 'echo The app is running! && sleep 3600']
  initContainers:
  - name: init-myservice
    image: busybox
    command: ['sh', '-c', 'git clone <some-repository-that-will-be-used-by-application> ; done;']
  - name: init-mydb
    image: busybox
    command: ['sh', '-c', 'until nslookup mydb; do echo waiting for mydb; sleep 2; done;']

```