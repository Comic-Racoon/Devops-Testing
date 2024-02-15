Rollouts and Versioning in Deployments:
    Deployment triggers a rollout upon creation.
    Each rollout creates a new deployment revision.
    Rollouts track changes and enable rollbacks.

Rollout Status and History:
    Check rollout status: kubectl rollout status <deployment-name>.
    View rollout history: kubectl rollout history <deployment-name>.

Deployment Strategies:
    Recreate: Destroy all old pods, then create new ones.
    Rolling update: Upgrade pods one by one, ensuring continuous availability.

Updating Deployments:
    Modify deployment definition file and apply changes.
    Alternatively, use kubectl set image command to update container images.

Deployment Upgrade Process:
    New deployment creates a new replica set.
    Pods are gradually replaced with the new version using rolling update.

Rolling Back Deployments:
    Use kubectl rollout undo command followed by deployment name.
    Previous replica set is restored, rolling back changes.

Key Commands:
    kubectl create -f deployment-defination.yaml
    kubectl get deployments              : List deployments.
    kubectl apply -f deployment-defination.yaml 
    kubectl set image deployment/deplyent-name <image-name>=<new:image-nam>:<tag>
    kubectl rollout status deployment/deplyent-name
    kubectl undo deployment/deplyent-name