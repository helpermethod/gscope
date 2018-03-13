# GScope

GScope brings Kotlin's scoping functions to Groovy.

## Features

* *Typesafe* GScope is implemented as an extension module and compatible with type checking and static compilation.
* *Tiny* GScope has no external dependencies.

## Installation

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
    String name
}

def maintainer = new Person().apply {
    name = 'helpermethod'
}
```

## API

### apply

### also

### let

### run