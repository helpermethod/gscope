# GScope

Kotlin's scoping functions for Groovy.

## Features

* *Typesafe* GScope is compatible with type checking and static compilation.
* *Tiny* GScope has no external dependencies.

## Setup

### Gradle

```groovy
repositories {
    maven {
        url 'http://dl.bintray.com/helpermethod/maven'
    }
}

dependencies {
    compile 'com.github.helpermethod:gscope:0.2.0'
}
```

### Maven

```xml
<repositories>
    <repository>
        <id>bintray</id>
        <url>http://dl.bintray.com/helpermethod/maven</url>
    </repository>
</repositories>

<dependency>
  <groupId>com.github.helpermethod</groupId>
  <artifactId>gscope</artifactId>
  <version>0.2.0</version>
</dependency>
```

## Quickstart

```groovy
class Person {
    String firstName
    String lastName
}

def ash = new Person().apply {
    firstName = 'Ash'
    lastName = 'Williams'
}
```

## API

### apply

Use apply for post-construction initialisation.

### also

### let

Use let for performing transformations.

Another use case is executing a block of code when the delegate is non-null.

```groovy
foo?.let {
    println it
    number ** 2
}
```

<!-- example with ?: -->

### run