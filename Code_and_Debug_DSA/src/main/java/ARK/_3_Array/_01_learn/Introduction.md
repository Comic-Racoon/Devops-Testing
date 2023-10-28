## What is an Array?

* An array is an indexed collection of fixed number of homogeneous data elements.
* The main advantage of arrays is we can represent multiple values with the same name
so that readability of the code will be improved.
* But the main disadvantage of arrays is:
  * Fixed in size that is once we created an array there is no chance of increasing or
  decreasing the size based on our requirement that is to use arrays concept compulsory
  we should know the size in advance which may not possible always.
  * We can resolve this (above-mentioned) problem by using collections.

### Basic Characteristic of array is 
* contiguous memory 
* fixed size
* indexed elements ...etc

---
## Array Declaration.

### Single dimensional array declaration:
example : 
```
int[] a;//recommended to use because name is clearly separated from the type
int []a;
int a[];
```
* At the time of declaration we can’t specify the size otherwise we will get compile time
  error
  example :
```
int[] a;//valid
int[5] a;//invalid
```
### Two dimensional array declaration:
```
int[][] a;
int [][]a;
int a[][];     //All are valid.
int[] []a;
int[] a[];
int []a[];
```
### Three dimensional array declaration:
```
int[][][] a;
int [][][]a;
int a[][][];
int[] [][]a;
int[] a[][];  //All are valid.
int[] []a[];
int[][] []a;
int[][] a[];
int []a[][];
int [][]a[];
```
---

## Array construction
#### Array construction :- Every array in java is an object hence we can create by using ***new*** operator

example:
```
int[] a=new int[3];
```
##### Rule 1 
* At the time of array creation compulsory we should specify the size otherwise we will
  get compile time error
```
Example:
int[] a=new int[3];
int[] a=new int[];//C.E:array dimension missing
```
##### Rule 2:
* It is legal to have an array with size zero in java.
```
Example:
int[] a=new int[0];
System.out.println(a.length);//0
```
##### Rule 3:
* If we are taking array size with -ve int value then we will get runtime exception saying
NegativeArraySizeException
```
Example:
int[] a=new int[-3];//R.E:NegativeArraySizeException
```
##### Rule 4:
* The allowed data types to specify array size are byte, short, char, int. By mistake if we
are using any other type we will get compile time error.
```
Example:
int[] a=new int['a'];//(valid)
byte b=10;
int[] a=new int[b];//(valid)
short s=20;
int[] a=new int[s];//(valid)
int[] a=new int[10l];//C.E:possible loss of precision//(invalid)
int[] a=new int[10.5];//C.E:possible loss of precision//(invalid)
```
##### Rule 5:
* The maximum allowed array size in java is maximum value of int size [2147483647].
```
Example:
int[] a1=new int[2147483647];(valid)
int[] a2=new int[2147483648];//C.E:integer number too large: 2147483648(invalid)
```
---

## Array initialization: 
* Whenever we are creating an array every element is initialized with default
value automatically.
```
Example 1:
int[] a=new int[3];
System.out.println(a);//[I@3e25a5
System.out.println(a[0]);//0
```

### Declaration construction and initialization of an array in a single line:
* We can perform declaration construction and initialization of an array in a single line
```
int[] int={1,2,3,4};(valid)
char[] ch={'a','e','i','o','u'};(valid)
String[] s={"balayya","venki","nag","chiru"};(valid)
```
---
## length vs length()

#### length:
1) It is the final variable applicable only for arrays.
2) It represents the size of the array.
```
int[] x=new int[3];
System.out.println(x.length());//C.E: cannot find symbol
System.out.println(x.length);//3
```

#### length() method:
1) It is a final method applicable for String objects.
2) It returns the no of characters present in the String.
```
Example:
String s="bhaskar";
System.out.println(s.length);//C.E:cannot find symbol
System.out.println(s.length());//7
```

---
## Basic operation in Array
* Traversal - This operation is used to print the elements of the array.
* Insertion - It is used to add an element at a particular index.
* Deletion - It is used to delete an element from a particular index.
* Search - It is used to search an element using the given index or by the value.
* Update - It updates an element at a particular index.

