load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

#RULES_JVM_EXTERNAL_TAG = "2.10"

#RULES_JVM_EXTERNAL_SHA = "1bbf2e48d07686707dd85357e9a94da775e1dbd7c464272b3664283c9c716d26"

RULES_JVM_EXTERNAL_TAG = "2.8"

RULES_JVM_EXTERNAL_SHA = "79c9850690d7614ecdb72d68394f994fef7534b292c4867ce5e7dec0aa7bdfad"

http_archive(
    name = "rules_jvm_external",
    sha256 = RULES_JVM_EXTERNAL_SHA,
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)


load("@rules_jvm_external//:defs.bzl", "maven_install")

maven_install(
    artifacts = [
        "io.cucumber:cucumber-core:4.2.6",
        "io.cucumber:cucumber-java:4.2.6",
        "io.cucumber:cucumber-junit:4.2.6",
        "junit:junit:4.12",
        "io.vertx:vertx-web:3.8.2",
        "io.vertx:vertx-core:3.8.2",
        #        "io.netty:netty-all:4.1.42.Final",
        #        "org.slf4j:slf4j-log4j12:1.6.1",
    ],
    fetch_sources = True,
    repositories = [
        "https://repo1.maven.org/maven2",
    ],
)

###################     Vert.x      #############################
#maven_jar(
#    name = "vertx_web",
#    artifact = "io.vertx:vertx-web:3.8.2",
#)
#
#maven_jar(
#    name = "vertx_core",
#    artifact = "io.vertx:vertx-core:3.8.2",
#)
#
#maven_jar(
#    name = "io_netty",
#    artifact = "io.netty:netty-all:4.1.42.Final",
#)
