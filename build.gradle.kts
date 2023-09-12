plugins {
    id("org.jetbrains.grammarkit")
}

tasks {
    generateLexer {
        sourceFile.set(layout.projectDirectory.file("build.gradle.kts"))
        targetOutputDir.set(layout.buildDirectory.dir("generated/lexer/main/java/app/softwork/kobol/"))
    }
}
