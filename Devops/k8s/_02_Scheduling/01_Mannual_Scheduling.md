# Manual Scheduling

use key field : ***nodeName***


```
apiVersion: v1
kind: pod 
metadata:
    name: nginx
spec:
    nodeName : <--your node name-->
    - container:
        image: nginx
        name: nginx
```