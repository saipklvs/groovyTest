#!groovy
import static groovy.io.FileType.FILES

node('master') {
    FILES_DIR = './foo'
    cleanWs()

    sh """
        mkdir foo
        touch foo/bar1
        touch foo/bar2
        touch foo/bar3
    """

    def filenames = [];
    def dir = new File("${env.WORKSPACE}/${FILES_DIR}");
    dir.traverse(type: FILES, maxDepth: 0) {
        filenames.add(it.getName())
    }

    for (int i = 0; i < filenames.size(); i++) {
        def filename = filenames[i]
        echo "${filename}"
    }
}