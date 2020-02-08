package cn.kt.chapter1

fun main(args: Array<String>?) {

    html {

        "style"("stylesdad")
        "id"("tagId")


        head {
            "id"("headId")
        }

        body {
            id = "bodyId"
            `class` = "bodyClass"
            "a"{
                +"百度"
                "href"("https://www.baidu.com")
            }
        }
    }
        .render()
        .let { println(it) }

}