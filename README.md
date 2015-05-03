# Java8

## Collections vs Streams

Collection is an *in-memory* data structure: all the items of the Collection are stored in memory. To read elements from a Collection we use a *pull* model: we ask the Collection to give us the next element.

In a Stream, elements are computed *on demand*. Kind of lazy constructed Collection. When reading elements from an Stream, a *push* model is used: when elements are available, the stream call us to perform an operation on the element.

## Lambdas

### Anonymous functions 
