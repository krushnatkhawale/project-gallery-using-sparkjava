## Spark - A web applications micro framework in Kotlin and Java 8 with minimal effort


Spark Framework is a simple and expressive Java/Kotlin web framework DSL built for rapid development. Sparks intention is to provide an alternative for Kotlin/Java developers that want to develop their web applications as expressive as possible and with minimal boilerplate. With a clear philosophy Spark is designed not only to make you more productive, but also to make your code better under the influence of Spark’s sleek, declarative and expressive syntax. [More info](https://sparkjava.com/)

## Getting started (with Java and gradle)


### First add sparkjava dependency

``` implementation "com.sparkjava:spark-core:2.9.3" ```

### Write an endpoint
```
import static spark.Spark.get;
public class Api {
    public static void main(String[] args) {
        get("/hello", (request, response)-> "Hello world" );
    }
}
```
Yes, that's the only line you will have to write.
That only line will do at least following things for you,

- define a GET endpoint "/hello"
- define response to return when "/hello" endpoint is hit
- starts web-server on default port which is 4567