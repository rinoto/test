# Java8

## What is new

http://www.oracle.com/technetwork/java/javase/8-whats-new-2157071.html

Most info stolen form http://www.oracle.com/technetwork/articles/java/ma14-java-se-8-streams-2177646.html

## Lambdas

https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html

Let you treat **code as data**. Syntatic sugar for interfaces declaring just one method. 

### Why "lambda"

Name comes from Lambda Calculus (λ-calculus -  Alonzo Church 1936): method for creating functions,  formal system in mathematical logic for expressing computation based on function abstraction and application using variable binding and substitution.

### Something new in programming languages?

There have been Lambdas since Lisp 1958

### Syntax

https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#syntax

### Shadowing
Unlike local and anonymous classes, lambda expressions do not have any shadowing issues ("if a declaration of a type (such as a member variable or a parameter name) in a particular scope (such as an inner class or a method definition) has the same name as another declaration in the enclosing scope, then the declaration shadows the declaration of the enclosing scope") 

Lambda expressions are **lexically scoped**. This means that they do not inherit any names from a supertype or introduce a new level of scoping. Declarations in a lambda expression are interpreted just as they are in the enclosing environment. 

If a lambda expression tries to redeclare a variable, the code will not compile (see LambdaNoShadowing example).

### The @FunctionalInterface annotation

We can see it in a lot of Java8 classes (e.g. Comparator). It is just an **informative** annotation that indicates that an interface defines exactly one *abstract* method (i.e. one without a default implementation, and that is not already defined in java.lang.Object).

Compilers will throw an exception if an interface annotated with @FunctionalInterface does not have exactly one abstract method, but the interfaces designed to be "Funtional" do not need to declare the annotation, as they will be treated like that by the compiler.

### Lambdas vs Anonymous functions 

Bytecode implementation is different. It's implemented in a way (using "redirection") that may be changed in the future, without the need to recompile the code (minor java updates).

#### Performance

**Non-capturing lambdas** (lambdas that do not declare any variables, nor use any from the surrounding context), performance much better than Anonymous Inner Classes, because no new instance has to be created (the lambda can be cached).

	((x,y) -> x+y)  :   This code will be instantiated only once. It keeps no state, so it can be reused!

### Serialization
Possible, but strongly discouraged

### Method references

see examples

## Streams

Streams are a sequence of elements from a source that supports aggregate operations:

+ **Sequence** of elements: A stream provides an interface to a sequenced set of values of a specific element type. However, streams don’t actually store elements; they are computed on demand.
+ **Source**: Streams consume from a data-providing source such as collections, arrays, or I/O resources.
+ Aggregate **operations**: Streams support operations from functional programming languages, such as filter, map, reduce, find, match, sorted, and so on. 


### Collections vs Streams

Collection is an *in-memory* data structure: all the items of the Collection are stored in memory. To read elements from a Collection we use a **pull** model: we ask the Collection to give us the next element.

Collections are about data and streams are about computations.

In a Stream, elements are computed *on demand*. Kind of lazy constructed Collection. Elements in a Stream are iterated internally: the caller (consumer) doesn't have any control over the iteration, but it just receives the items when they are ready.

This internal iteration enables implicit parallel processing, that cannot be achieved using external iteration (as in the collections). 

### Stream pipeline

A stream consists of:

+ Source (elements)
+ **Intermediate** operations (e.g. map, filter, ..)
+ One **Terminal** operation (e.g. collect, allMatch, ...)

### Reduction operations

A terminal operation that returns one value combining the elements of the stream is called **reduction** operation (e.g. average, sum, min, max).

JDK provides the **reduce** and **collect** methods as *general-purpose reduction operations*.

## javac -paramters

The -parameters option of the javac command can be used to store formal parameter names and enable the Reflection API to retrieve formal parameter names


## Date-Time Package 

A new set of packages that provide a comprehensive date-time model. Similar to Joda Time, but in Java.



## Concurrency (see last talk ;)

## Removal of PermGen!

Replaced with Metaspace.

* -XX:MaxMetaspaceSize can set the max size. Default is infinite.
* -XX:MetaspaceSize : define initial size
 

