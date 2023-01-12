Akka gRPC の例
---

## 1. 開始

### asdf

Homebrew を使って asdf をインストールします。

```shell
brew install asdf
```

### grpcurl

Homebrew を使って grpcurl をインストールします。

```shell
brew install grpcurl
```

### Java

asdf を使って java をインストールします。

```shell
asdf plugin add java
asdf install java temurin-17.0.5+8
```

デフォルトでインストールしたバージョンの java が使用されるように設定します。

```shell
asdf global java temurin-17.0.5+8
```

### sbt

asdf を使って sbt をインストールします。

```shell
asdf plugin add sbt
asdf install sbt 1.8.2
```

デフォルトでインストールしたバージョンの sbt が使用されるように設定します。

```shell
asdf global sbt 1.8.2
```

### プロジェクトの生成

sbt を使ってプロジェクトを生成します。

```shell
sbt new sbt/scala-seed.g8
```

プロジェクト名は、ここでは `hello-akka-grpc` とします。

```shell
name [Scala Seed Project]: hello-akka-grpc
```

生成したプロジェクトをカレントディレクトリに設定します。

```shell
cd hello-akka-grpc
```

## 2. akka-grpc

- [Introduction to Akka gRPC](https://youtu.be/kXN30ttsf-I)
- [Walkthrough](https://doc.akka.io/docs/akka-grpc/current/server/walkthrough.html)
- [Overview of Akka libraries and modules](https://doc.akka.io/docs/akka/2.7.0/typed/guide/modules.html)

`Main.scala` を IDE 等で実行します。

ターミナルから次のコマンドを実行してください。

```shell
grpcurl -plaintext localhost:8080 list
```

次のレスポンスが返ります。

```text
com.pigumer.HelloService
grpc.reflection.v1alpha.ServerReflection
```

ターミナルから次のコマンドを実行してください。

```shell
grpcurl -plaintext localhost:8080 list com.pigumer.HelloService
```

次のレスポンスが返ります。

```text
com.pigumer.HelloService.Hello
```

HelloService を実行します。

```shell
grpcurl -plaintext -d '{"name":"Foo"}' localhost:8080 com.pigumer.HelloService.Hello
```

次のレスポンスが返ります。

```json
{
  "value": "Hello Foo"
}
```
