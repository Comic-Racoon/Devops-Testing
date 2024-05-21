# Docker Image Management

## Subtopic 1: Removing Docker Images
- **Command**: `docker image rm [image-name]`
  - Removes an image no longer in use.
  - Ensure no containers are running from the image before attempting removal.
  - Must stop and delete all dependent containers to delete an image.

### Process of Removing an Image
- **Two Steps**:
  1. Removes the soft link name (tag) associated with the image.
  2. Removes the image layers, freeing up space.

- **Example**:
  - Image ID: `e4e9`, Size: 112 MB
  - Tags: `alpine`, `customv1`
  - Removing the first tag will not remove the image layers, just the tag.
  - Only when the last tag is removed will the image layers be deleted, freeing up space.

## Subtopic 2: Handling Multiple Tags
- **Intelligent Tag Management**:
  - Docker retains image layers if there are multiple tags for a single image.
  - Only removes layers when the final tag is deleted.
  
## Subtopic 3: Pruning Unused Images
- **Command**: `docker image prune -a`
  - Deletes all unused images and reclaims space on the host.
  - Deletes only images without any associated containers.

### Usage Considerations
- Useful for cleaning up development or test environments with many unused images.
- **Caution**: Ensure no required images are pruned, as this command deletes all unused images.

## Summary
- **Removing Images**:
  - Stop and delete dependent containers.
  - Use `docker image rm` to remove tags and eventually image layers.
- **Pruning Images**:
  - Use `docker image prune -a` for bulk deletion of unused images.
  - Be cautious as this removes all unused images without container associations.

# Next Steps
- Proceed to demo on removing and pruning Docker images.
