Akka gRPC の例
---

## asdf

Homebrew を使って asdf をインストールします。

```shell
brew install asdf
```

## Java

asdf を使って java をインストールします。

```shell
asdf plugin add java
asdf install java temurin-17.0.5+8
```

デフォルトでインストールしたバージョンの java が使用されるように設定します。

```shell
asdf global java temurin-17.0.5+8
```

## sbt

asdf を使って sbt をインストールします。

```shell
asdf plugin add sbt
asdf install sbt 1.8.2
```

デフォルトでインストールしたバージョンの sbt が使用されるように設定します。

```shell
asdf global sbt 1.8.2
```

## プロジェクトの生成

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
