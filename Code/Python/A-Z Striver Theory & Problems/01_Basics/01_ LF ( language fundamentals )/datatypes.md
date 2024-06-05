### Data types in Python:

# Summary of Datatypes in Python 3

| Datatype  | Description                                                      | Is Immutable | Example                                                                                           |
|-----------|------------------------------------------------------------------|--------------|---------------------------------------------------------------------------------------------------|
| Int       | We can use to represent the whole/integral numbers               | Immutable    | ```python                                                                                         |
|           |                                                                  |              | a = 10                                                                                             |
|           |                                                                  |              | type(a)                                                                                           |
|           |                                                                  |              | <class 'int'>                                                                                     |
|           |                                                                  |              | ```                                                                                               |
| Float     | We can use to represent the decimal/floating point numbers       | Immutable    | ```python                                                                                         |
|           |                                                                  |              | b = 10.5                                                                                           |
|           |                                                                  |              | type(b)                                                                                           |
|           |                                                                  |              | <class 'float'>                                                                                   |
|           |                                                                  |              | ```                                                                                               |
| Complex   | We can use to represent the complex numbers                      | Immutable    | ```python                                                                                         |
|           |                                                                  |              | c = 10 + 5j                                                                                        |
|           |                                                                  |              | type(c)                                                                                           |
|           |                                                                  |              | <class 'complex'>                                                                                 |
|           |                                                                  |              | c.real                                                                                            |
|           |                                                                  |              | 10.0                                                                                              |
|           |                                                                  |              | c.imag                                                                                            |
|           |                                                                  |              | 5.0                                                                                               |
|           |                                                                  |              | ```                                                                                               |
| Bool      | We can use to represent the logical values (only allowed values  | Immutable    | ```python                                                                                         |
|           | are True and False)                                              |              | flag = True                                                                                       |
|           |                                                                  |              | type(flag)                                                                                         |
|           |                                                                  |              | <class 'bool'>                                                                                     |
|           |                                                                  |              | ```                                                                                               |
| Str       | To represent a sequence of characters                            | Immutable    | ```python                                                                                         |
|           |                                                                  |              | s = 'durga'                                                                                       |
|           |                                                                  |              | type(s)                                                                                           |
|           |                                                                  |              | <class 'str'>                                                                                     |
|           |                                                                  |              | s = "durga"                                                                                       |
|           |                                                                  |              | s = """durga Software Solutions ... Amerepet"""                                                   |
|           |                                                                  |              | type(s)                                                                                           |
|           |                                                                  |              | <class 'str'>                                                                                     |
|           |                                                                  |              | ```                                                                                               |
| Bytes     | To represent a sequence of byte values from 0-255                | Immutable    | ```python                                                                                         |
|           |                                                                  |              | l = [10, 20, 30, 40]                                                                              |
|           |                                                                  |              | b = bytes(l)                                                                                      |
|           |                                                                  |              | type(b)                                                                                           |
|           |                                                                  |              | <class 'bytes'>                                                                                   |
|           |                                                                  |              | ```                                                                                               |
| Bytearray | To represent a sequence of byte values from 0-255                | Mutable      | ```python                                                                                         |
|           |                                                                  |              | l = [10, 20, 30]                                                                                  |
|           |                                                                  |              | ba = bytearray(l)                                                                                 |
|           |                                                                  |              | type(ba)                                                                                          |
|           |                                                                  |              | <class 'bytearray'>                                                                               |
|           |                                                                  |              | ```                                                                                               |
| Range     | To represent a range of values                                   | Immutable    | ```python                                                                                         |
|           |                                                                  |              | r = range(10)                                                                                     |
|           |                                                                  |              | type(r)                                                                                           |
|           |                                                                  |              | <class 'range'>                                                                                   |
|           |                                                                  |              | r = range(10, 20)                                                                                 |
|           |                                                                  |              | ```                                                                                               |
| List      | To represent an ordered collection of objects                    | Mutable      | ```python                                                                                         |
|           |                                                                  |              | l = [10, 11, 12, 13, 14, 15]                                                                      |
|           |                                                                  |              | type(l)                                                                                           |
|           |                                                                  |              | <class 'list'>                                                                                    |
|           |                                                                  |              | ```                                                                                               |
| Tuple     | To represent an ordered collection of objects                    | Immutable    | ```python                                                                                         |
|           |                                                                  |              | t = (1, 2, 3, 4, 5)                                                                               |
|           |                                                                  |              | type(t)                                                                                           |
|           |                                                                  |              | <class 'tuple'>                                                                                   |
|           |                                                                  |              | ```                                                                                               |
| Set       | To represent an unordered collection of unique objects           | Mutable      | ```python                                                                                         |
|           |                                                                  |              | s = {1, 2, 3, 4, 5, 6}                                                                            |
|           |                                                                  |              | type(s)                                                                                           |
|           |                                                                  |              | <class 'set'>                                                                                     |
|           |                                                                  |              | ```                                                                                               |
| Frozenset | To represent an unordered collection of unique objects           | Immutable    | ```python                                                                                         |
|           |                                                                  |              | fs = frozenset(s)                                                                                 |
|           |                                                                  |              | type(fs)                                                                                          |
|           |                                                                  |              | <class 'frozenset'>                                                                               |
|           |                                                                  |              | ```                                                                                               |
| Dict      | To represent a group of key-value pairs                          | Mutable      | ```python                                                                                         |
|           |                                                                  |              | d = {101: 'durga', 102: 'ramu', 103: 'hari'}                                                      |
|           |                                                                  |              | type(d)                                                                                           |
|           |                                                                  |              | <class 'dict'>                                                                                    |
|           |                                                                  |              | ```                                                                                               |
