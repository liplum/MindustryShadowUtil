package net.liplum

import net.lingala.zip4j.ZipFile
import java.io.File
import java.net.URL

const val RepoPath = "repo"
const val ShadowPath = "shadow"
val zip = File("temp/archive.zip").genDirs()
val repo = File(RepoPath)
fun main(args: Array<String>) {
    val archiveURL = args[0]
    URL(archiveURL).openStream().use { `in` ->
        zip.outputStream().use { out ->
            `in`.copyTo(out)
        }
    }
    ZipFile(zip).extractAll(RepoPath)
    val repoDir = repo.listFiles()!!.first()!!
    repoDir.renameTo(repoDir.parentFile.sub(ShadowPath))
}

fun File.genDirs(): File {
    this.parentFile.mkdirs()
    return this
}

fun File.sub(name: String) =
    File(this, name)