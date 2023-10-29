### gRPC-ProtoBuf Example Project with Gradle

This project is a simple example of how to use gRPC and ProtoBuf in Java.
Other details will be added later.

### How to generate Java classes from .proto files

```zsh
protoc --java_out=./ ./src/main/proto/*.proto
```

### How to generate Javascript classes from .proto files with gRPC

```zsh
protoc --js_out=./ ./src/main/proto/*.proto
```

### How to generate Python classes from .proto files with gRPC-Web

```zsh
protoc --python_out=./ ./src/main/proto/*.proto
```

### How to generate documentation from .proto files

```zsh
protoc --doc_out=./ --doc_opt=markdown,README.md ./src/main/proto/*.proto
```