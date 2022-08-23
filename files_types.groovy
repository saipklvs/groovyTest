import groovy.io.*

def ListDirectories(dir){
    dlist = []
    flist = []
    new File(dir).eachDir{dlist << it.name}
    return dlist
}

fs = ListDirectories(".")
fs.each{
    println it
}

def FindAllFiles(dir){
    flist = []
    new File(dir).eachFile{flist << it.name}
    for (f in flist){
        println "Files" + f
    }
}

FindAllFiles("./8988898/West")
