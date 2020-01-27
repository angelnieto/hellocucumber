java_library(
    name = "tests",
    srcs = glob([
        "corporate-bff-api/src/test/java/**/*.java",
    ]),
    resources = glob([
        "corporate-bff-api/src/test/resources/**",
        "corporate-bff-api/src/main/resources/**",
    ]),
    visibility = [
        "//visibility:public",
    ],
    exports = [
        "@maven//:io_cucumber_cucumber_core",
        "@maven//:io_cucumber_cucumber_java",
        "@maven//:io_cucumber_cucumber_junit",
        "@maven//:junit_junit",
        "@maven//:io_vertx_vertx_core",
        #        "@maven//:org_slf4j_slf4j_log4j12",
    ],
)

###################     Vert.x      #############################
java_library(
    name = "sources",
    srcs = glob([
        "src/main/java/**/*.java",
    ]),
    resources = glob([
        "src/main/resources/**",
    ]),
    visibility = [
        "//visibility:public",
    ],
    exports = [
        "@maven//:io_vertx_vertx_core",
        "@maven//:io_vertx_vertx_web",
    ],
)