# Java8

## Streams

### Collections vs Streams

Collection is an *in-memory* data structure: all the items of the Collection are stored in memory. To read elements from a Collection we use a **pull** model: we ask the Collection to give us the next element.

In a Stream, elements are computed *on demand*. Kind of lazy constructed Collection. Elements in a Stream are iterated internally: the caller (consumer) doesn't have any control over the iteration, but it just receives the items when they are ready.
This internal iteration enables implicit parallel processing, that cannot be achieved using external iteration (as in the collections). 

### Stream pipeline

A stream consists of:

+ Source (elements)
+ **Intermediate** operations (e.g. map, filter, ..)
+ One **Terminal** operation (e.g. collect, allMatch, ...)

## Lambdas

### Anonymous functions 
