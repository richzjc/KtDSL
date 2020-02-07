package cn.kt.chapter1

fun html(block : Tag.() -> Unit) : Tag{
    return Tag("html").apply(block)
}

fun Tag.head(block : Head.() -> Unit){
    this@head + Head().apply(block)
}

fun Tag.body(block : Body.() -> Unit) {
    this@body + Body().apply(block)
}

class Head : Tag("head")


class Body : Tag("body"){
    var id by MapDelegate(properties)
    var `class` by MapDelegate(properties)
}