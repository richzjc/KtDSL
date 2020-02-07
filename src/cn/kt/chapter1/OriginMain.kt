package cn.kt.chapter1

fun main(args : Array<String>){

    Tag("html")
        .apply {
            children.add(Tag("head"))
            children.add(Tag("body"))

            properties.put("style", "stylesdad")
            properties.put("id", "tagId")
        }
        .render()
        .let(::println)
}