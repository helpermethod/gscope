# GScope

Kotlin's scoping functions for Groovy.

## Features

* *Typesafe* GScope is compatible with type checking and static compilation.
* *Small* GScope has no external dependencies.

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

Use `apply` for post-construction initialisation.

```groovy
def ash = new Person().apply {
    firstName = 'Ash'
    lastName = 'Williams'
}
```

You may also use `apply` when you want to expose a fluent API for methods that would normally return `void`.

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

`also` is like `apply` except that `this` becomes the closure's argument instead of its delegate.
Like `apply` you use it for post-construction initialisation.

```groovy
def ash = new Person().apply {
    it.firstName = 'Ash'
    it.lastName = 'Williams'
}
```

You may also use `also` to assign calculated values to fields.

```groovy
class Person {
    Person father
    List<Person> children

    def father(Person father) {
        father.also {
            this.father = it
            it.children += this
        }
    }
}
```

### use

> `run` calls the specified closure with `this` value as its delegate and returns its result.

Use `run` for transforming values.

```groovy
def fullName = new Person(firstName: 'Ash', lastName: 'Williams').let {
    "$firstName $lastName"
}
```

### let

> `let` calls the specified closure with `this` as its argument and returns its result.

`let` is like `run` except that `this` becomes the closure's argument instead of its delegate.
Like `run` you use it for transforming values.

```groovy
def fullName = new Person(firstName: 'Ash', lastName: 'Williams').let {
    "$it.firstName $it.lastName"
}
```

You may also use `let` to execute a block of code when the delegate is non-null.

```groovy
class PersonUtils {
    static def fullName(Person person) {
        person?.let {
            println it
            "$it.firstName $it.lastName"
        } ?: 'John Doe'
    }
}

def ashWilliams = PersonUtils.fullName(ash)
def johnDoe = PersonUtils.fullName(null)
```