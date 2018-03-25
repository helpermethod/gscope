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

> `apply` calls the specified closure with `this` value as its delegate and returns `this`.

`apply`'s typical use case is post-construction initialisation.

```groovy
def ash = new Person().apply {
    firstName = 'Ash'
    lastName = 'Williams'
}
```

It can be used for exposing a fluent API for methods that would normally return `void`.

```groovy
class Person {
    String firstName
    String lastName

    def firstName(String firstName) {
        apply { this.firstName = firstName }
    }

    def lastName(String lastName) {
        apply { this.lastName = lastName }
    }
}

def ash = new Person().firstName('Ash').lastName('Williams')
```

### also

> `also` calls the specified closure with `this` as its argument and returns `this`.

`also` is similar to `apply` and only differs in that `this` becomes the closure's argument instead of its delegate.
Like `apply` it can be used for post-construction initialisation.

```groovy
def ash = new Person().apply {
    it.firstName = 'Ash'
    it.lastName = 'Williams'
}
```

`also` may also be used to assign calculated values to fields.

```groovy
class Person {

}
```

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