## Redirecting STDOUT and STDERR in Bash

Redirecting `STDOUT` (standard output) and `STDERR` (standard error) in Bash can be incredibly useful, especially when managing various types of command output. Here's how you can do it:

### Redirecting STDOUT:

To redirect `STDOUT` to a file, use the `>` operator:

```
command > output.txt
```

This directs the output of `command` to the file `output.txt`. If `output.txt` doesn't exist, it will be created; if it does exist, it will be overwritten.

To append output to a file instead of overwriting it, use `>>`:

```
command >> output.txt
```

### Redirecting STDERR:

To redirect `STDERR` to a file, use the `2>` operator:

```
command 2> error.txt
```

This redirects the error output of `command` to the file `error.txt`.

Similarly, to append `STDERR` to a file, use `2>>`:

```
command 2>> error.txt
```

### Redirecting Both STDOUT and STDERR:

To redirect both `STDOUT` and `STDERR` to the same file, use `&>` or `2>&1`.

```
command &> output_and_error.txt
```
OR
```
command > output_and_error.txt 2>&1
```

### Redirecting to /dev/null:

To discard output entirely, redirect it to `/dev/null`:

```
command > /dev/null 2>&1
```

This effectively suppresses both `STDOUT` and `STDERR` outputs.
