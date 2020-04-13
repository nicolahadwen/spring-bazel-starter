load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

RULES_JVM_EXTERNAL_TAG = "3.0"
RULES_JVM_EXTERNAL_SHA = "62133c125bf4109dfd9d2af64830208356ce4ef8b165a6ef15bbff7460b35c3a"

http_archive(
    name = "rules_jvm_external",
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    sha256 = RULES_JVM_EXTERNAL_SHA,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

load("@rules_jvm_external//:defs.bzl", "maven_install")
load("@bazel_tools//tools/build_defs/repo:maven_rules.bzl", "maven_dependency_plugin", "maven_jar")

# spring versions
SPRING_VERSION = "5.1.5.RELEASE"
SPRING_BOOT_VERSION = "2.2.2.RELEASE"
#gson version
GSON_VERSION = "2.8.6"

# Install dependencies
maven_install(
    name = "maven",
    artifacts = [
        # javax
        "javax.servlet:javax.servlet-api:3.1.0",
        "javax.servlet:servlet-api:2.5",
        #apache commons
        "org.apache.commons:commons-lang3:3.9",
        # java assist
        "org.javassist:javassist:3.26.0-GA",
        # lombok
        "org.projectlombok:lombok:1.18.4",
        # spring boot
        "org.springframework.boot:spring-boot-starter-web:%s" % SPRING_BOOT_VERSION,
        "org.springframework.boot:spring-boot-starter-security:%s" % SPRING_BOOT_VERSION,
        # spring
        "org.springframework:spring-context:%s" % SPRING_VERSION,
        "org.springframework:spring-web:%s" % SPRING_VERSION,
        "org.springframework:spring-webmvc:%s" % SPRING_VERSION,
        "org.springframework.security:spring-security-config:%s" % SPRING_VERSION,
        "org.springframework.boot:spring-boot:%s" % SPRING_BOOT_VERSION,
        "org.springframework.boot:spring-boot-starter-web:%s" % SPRING_BOOT_VERSION,
        "org.springframework.security.oauth:spring-security-oauth2:%s" % SPRING_BOOT_VERSION,
        #gson
        "com.google.code.gson:gson:%s" % GSON_VERSION
    ],
    repositories = [
            "https://jcenter.bintray.com/",
            "https://repo1.maven.org/maven2",
    ],
    fail_on_missing_checksum = True,
    fetch_sources = True,   # Fetch source jars. Defaults to False.
)

# JUNIT DEPENDENCIES
load("@bazel_tools//tools/build_defs/repo:maven_rules.bzl", "maven_dependency_plugin", "maven_jar")
load(":junit5.bzl", "junit_jupiter_java_repositories", "junit_platform_java_repositories")

maven_server(
    name = "default",
    url = "https://repo1.maven.org/maven2/",
)

JUNIT_JUPITER_VERSION = "5.6.0"

JUNIT_PLATFORM_VERSION = "1.6.0"

junit_jupiter_java_repositories(
    version = JUNIT_JUPITER_VERSION,
)

junit_platform_java_repositories(
    version = JUNIT_PLATFORM_VERSION,
)

# Test
# Test dependencies
maven_install(
    name = "maven_test",
    artifacts = [
        "org.assertj:assertj-core:3.9.0",
        "org.mockito:mockito-core:3.2.4",
        "net.bytebuddy:byte-buddy:1.10.5",  # needed for mockito-core
    ],
    fail_on_missing_checksum = True,
    fetch_sources = True,   # Fetch source jars. Defaults to False.
    repositories = [
        "https://repo1.maven.org/maven2/",
        "https://jcenter.bintray.com/",
        "https://maven.google.com",
    ],
)

# Docker
http_archive(
    name = "io_bazel_rules_docker",
    sha256 = "dc97fccceacd4c6be14e800b2a00693d5e8d07f69ee187babfd04a80a9f8e250",
    strip_prefix = "rules_docker-0.14.1",
    urls = ["https://github.com/bazelbuild/rules_docker/releases/download/v0.14.1/rules_docker-v0.14.1.tar.gz"],
)


load(
    "@io_bazel_rules_docker//repositories:repositories.bzl",
    container_repositories = "repositories",
)
container_repositories()

# This is NOT needed when going through the language lang_image
# "repositories" function(s).
load("@io_bazel_rules_docker//repositories:deps.bzl", container_deps = "deps")

container_deps()

load(
    "@io_bazel_rules_docker//container:container.bzl",
    "container_pull",
    "container_image"
)

load(
    "@io_bazel_rules_docker//java:image.bzl",
    _java_image_repos = "repositories",
)

_java_image_repos()

container_pull(
  name = "java_base",
  registry = "gcr.io",
  repository = "distroless/java",
  digest = "sha256:ab2c346f00430bc4a6acb5ff282e99f532c386ea4277e1e472f493760f72fe73"
)