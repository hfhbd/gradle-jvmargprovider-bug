package org.jetbrains.grammarkit.tasks

import org.gradle.api.file.*
import org.gradle.api.provider.Provider
import org.gradle.api.tasks.*

@CacheableTask
abstract class GenerateLexerTask : JavaExec() {
    @get:OutputDirectory
    abstract val targetOutputDir: DirectoryProperty

    @get:InputFile
    @get:PathSensitive(PathSensitivity.RELATIVE)
    abstract val sourceFile: RegularFileProperty

    init {
        mainClass.set("jflex.Main")

        argumentProviders.add {
            listOf(
                targetOutputDir.path.get(),
                sourceFile.path.get(),
            )
        }
    }

    private val <T : FileSystemLocation> Provider<T>.path
        get() = map { it.asFile.canonicalPath }
}
